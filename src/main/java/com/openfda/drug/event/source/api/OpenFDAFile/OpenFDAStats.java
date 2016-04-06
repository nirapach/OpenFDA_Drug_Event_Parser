package com.openfda.drug.event.source.api.OpenFDAFile;

/**
 * Created by niranjan on 6/18/15.
 */

import com.google.gson.Gson;
import com.openfda.drug.event.source.dao.OpenFDADAO;
import com.openfda.drug.event.source.model.FDAModels.drug_event_pair;
import com.openfda.drug.event.source.responseparser.inputfile.response.dataset;
import com.openfda.drug.event.source.responseparser.inputfile.resultinfo.*;


import java.io.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.http.HTTPException;
import java.beans.PropertyVetoException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.*;

@Service
@SuppressWarnings("unchecked")
public class OpenFDAStats {

    Logger logger = LoggerFactory.getLogger(OpenFDAStats.class);

    @Autowired
    OpenFDADAO openFDADAO;
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    /*
      parsing all the json files
        */
    public boolean getOverAllFDAstats(String file_address,String result_file_address) throws URISyntaxException, IOException, PropertyVetoException, SQLException, HTTPException {


        /*
        both databse storage and csv file writing is done. Base on requirement comment the other one if both are not needed
         */
        BufferedReader reader = null;
        FileWriter fileWriter = null;
        try {
            File indexdirectory = new File(file_address);

            File[] files=indexdirectory.listFiles();

            //int file_count=0;

            //create File object
            File csv_file = new File(result_file_address+"OpenFDA_File_Drug_Event_POS"+"."+"txt");
            String filename=csv_file.getAbsolutePath();
            //File writer
            fileWriter = new FileWriter(filename);
            //Add a new line separator after the header

            //Hashmap for storing the event pairs

            HashMap<HashMap<String,String>,Integer> Map_One= new HashMap<HashMap<String, String>, Integer>();

            ArrayList<HashMap<String,String>> Map_List=new ArrayList<HashMap<String, String>>();

            for(int i=0;i<files.length;i++){

                if (!files[i].isDirectory() && !files[i].isHidden()
                        && files[i].canRead() && files[i].exists()) {
                    System.out.println("\n Extraction is going on with file"
                            + files[i].getCanonicalPath());


                    FileReader fileReader = new FileReader(files[i].getCanonicalPath());
                    // Always wrap FileReader in BufferedReader.
                    reader = new BufferedReader(fileReader);

                    StringBuffer fbresponse = new StringBuffer();

                    String line;
                    while ((line = reader.readLine()) != null) {
                        fbresponse.append(line);
                    }

                    String jsonfeed = fbresponse.toString();

                    Gson gson = new Gson();

                    dataset response = gson.fromJson(jsonfeed, dataset.class);

                    List<results> resultsList = response.results;

                    List<drug_event_pair> statsList = null;
                    int count = 0;
                    for (results result : resultsList) {
                        //this if statement is for serousness of the events. "1" means hospitalization or death
                        if(result.seriousnessdeath!=null){
                            int seriousdeath= Integer.parseInt(result.seriousnessdeath);
                            if (seriousdeath==1) {
                                //System.out.println("Inside Loop:" +result.serious);
                                primarysource primarySource = result.primarysource;
                                patient patient = result.patient;

                                List<reaction> events = patient.reaction;
                                List<drug> drugs = patient.drug;

/*                                drug_event_pair drugEventPair;
                                statsList = new ArrayList<drug_event_pair>();*/

                                for (drug resultData : drugs) {

                                    for (reaction adverse_events : events) {

                                        String medDrug = resultData.medicinalproduct.replaceAll("[-+.^:,]", " ");
                                        String medEvent = adverse_events.reactionmeddrapt.replaceAll("[-+.^:,]", " ");
                                        while(medDrug.contains("(") && medDrug.contains(")") ){
                                            int startIndex=medDrug.indexOf("(");
                                            int endIndex=medDrug.indexOf(")");
                                            if (endIndex<medDrug.length()) {
                                                String extraContent = medDrug.substring(startIndex, endIndex+1);
                                                medDrug = medDrug.replace(extraContent, " ");
                                            }
                                            else{
                                                String extraContent = medDrug.substring(startIndex, endIndex-1);
                                                medDrug = medDrug.replace(extraContent, " ");
                                            }
                                        }
                                        medDrug = medDrug.replaceAll("MG", " ");
                                        medDrug = medDrug.replaceAll("ML", " ");
                                        medDrug = medDrug.replaceAll("[^a-zA-Z]+", " ");
                                        medEvent = medEvent.replaceAll("[^a-zA-Z]+", " ");

                                        HashMap<String, String> Map_Key = new HashMap<String, String>();
                                        Map_Key.put(medDrug, medEvent);

                                        //adding things into hashmap
                                        if (!Map_One.containsKey(Map_Key)) {
                                            count = +1;
                                            Map_One.put(Map_Key, count);
                                        }

                                    }

                                }
                            }
                        }
                    }
                /*    //for storing into database
                    openFDADAO.storedrugeventstats(statsList);*/

                }

            }
            /*reading from a hashmap and writing it to the outfile
            */
            //extracting all the keys from initial hashmap

            for (HashMap<String,String> Map_Value:Map_One.keySet()){
                Map_List.add(Map_Value);
                }
            //iterating over the inner hashmap list
            Iterator<HashMap<String,String>> iterator=Map_List.iterator();
            while(iterator.hasNext()){
                for (Map.Entry<String, String> entry  : iterator.next().entrySet()){
                    String write_line=entry.getKey()+COMMA_DELIMITER+entry.getValue();
                    //System.out.println(write_line);
                    fileWriter.append(write_line);
                    fileWriter.append(NEW_LINE_SEPARATOR);
                }

            }

        }
        catch (IOException e) {
            logger.info("IO exception");
            logger.info(String.valueOf(e));
            e.printStackTrace();
        } catch (NullPointerException e) {
            logger.info("Null Pointer Exception");
            logger.info(String.valueOf(e));
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader/Writer !!!");
                e.printStackTrace();
            }
        }
        reader.close();
        return true;

    }
}
