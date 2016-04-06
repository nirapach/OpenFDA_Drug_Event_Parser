package com.openfda.drug.event.source.model.FDAModels;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class drug_event_pair {

    private String drug_name;
    private String event_name;
    private String literature_source;

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public String getLiterature_source() {
        return literature_source;
    }

    public void setLiterature_source(String literature_source) {
        this.literature_source = literature_source;
    }

    @Override
    public String toString() {
        return "drug_event_pair{" +
                "drug_name='" + drug_name + '\'' +
                ", event_name='" + event_name + '\'' +
                ", literature_source='" + literature_source + '\'' +
                '}';
    }
}

