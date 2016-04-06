package com.openfda.drug.event.source.dao;

/**
 * Created by niranjan on 6/18/15.
 */

import com.openfda.drug.event.source.model.FDAModels.drug_event_pair;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@SuppressWarnings("unchecked")
public class OpenFDADAO extends BaseDAO {

    public void storedrugeventstats(final List<drug_event_pair> drugList) {

        String query = "INSERT INTO drug_event_pair_table_one"  +
                "drug_name,"+
                "event_name,"+
                "literature_source)" +
                "VALUES"+
                "?,?,?)";


        getJdbcTemplate().batchUpdate(query, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement statement, int i) throws SQLException {
                drug_event_pair drugStatsLoader = drugList.get(i);

                statement.setString(1,drugStatsLoader.getDrug_name());
                statement.setString(2, drugStatsLoader.getEvent_name());
                statement.setString(3, drugStatsLoader.getLiterature_source());
            }

            @Override
            public int getBatchSize() {
                return drugList.size();
            }
        });
    }

    public void testdrugeventstats() throws SQLException {

        PreparedStatement statement = null;
        String query = "INSERT INTO drug_event_pair_table_test"  +
                "drug_name,"+
                "event_name,"+
                "literature_source)" +
                "VALUES"+
                "?,?,?)";

                statement.setString(1,"test_drug");
                statement.setString(2, "test_event");
                statement.setString(3, "test");

        statement.executeQuery(query);

    }
}
