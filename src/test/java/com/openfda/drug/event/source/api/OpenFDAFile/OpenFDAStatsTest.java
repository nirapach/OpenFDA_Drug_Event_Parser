package com.openfda.drug.event.source.api.OpenFDAFile;

import com.openfda.drug.event.source.dao.OpenFDADAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Niranjan on 1/27/2016.
 */
public class OpenFDAStatsTest {

    @Autowired
    OpenFDADAO openFDADAO;

    @Test
    public void testGetOverAllFDAstats() throws Exception {

        //openFDADAO.testdrugeventstats();

    }
}