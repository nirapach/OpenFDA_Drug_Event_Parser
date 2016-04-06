package com.openfda.drug.event.source.views;

/**
 * Created by niranjan on 6/19/15.
 */


import com.openfda.drug.event.source.api.OpenFDAFile.OpenFDAStats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Service
@SuppressWarnings("unchecked")
public class StatsInformationCaller {

        //Autowired the instance for all the API classes

    @Autowired
    OpenFDAStats openFDAStats;

    public void getAllStats(String file_address,String result_file_address) throws IOException, URISyntaxException, PropertyVetoException, SQLException {

        /*
        objects for all the stats create here statically
         */
        Logger logger = LoggerFactory.getLogger(StatsInformationCaller.class);

            //Calling the method to get ad group action stats

            boolean finishedstats = openFDAStats.getOverAllFDAstats(file_address,result_file_address);

            if(finishedstats){
                System.out.println("Completed Successfully");

            }



    }

}
