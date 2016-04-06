package com.openfda.drug.event.source.main;

/**
 * Created by niranjan on 6/19/15.
 */

import com.openfda.drug.event.source.views.StatsInformationCaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;


@Component
@SuppressWarnings("unchecked")
public class OpenFDAClient {


    @Autowired
    StatsInformationCaller statsInformationCaller;

    public static void main(String args[]) throws IOException, PropertyVetoException, URISyntaxException, SQLException {

        String json_files_address=args[0];
        String result_files_address=args[1];

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("OpenFDA-Parser-app-context.xml");
        context.getBean(OpenFDAClient.class).statsInformationCaller.getAllStats(json_files_address,result_files_address);
    }

}
