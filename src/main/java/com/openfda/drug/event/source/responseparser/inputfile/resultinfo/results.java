package com.openfda.drug.event.source.responseparser.inputfile.resultinfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class results {

    @SerializedName("receivedate")
    public String receivedate;

    @SerializedName("receivedateformat")
    public String receivedateformat;

    @SerializedName("transmissiondate")
    public String transmissiondate;

    @SerializedName("fulfillexpeditecriteria")
    public String fulfillexpeditecriteria;

    @SerializedName("occurcountry")
    public String occurcountry;

    @SerializedName("receiptdate")
    public String receiptdate;

    @SerializedName("receiptdateformat")
    public String receiptdateformat;

    @SerializedName("transmissiondateformat")
    public String transmissiondateformat;

    @SerializedName("duplicate")
    public String duplicate;

    @SerializedName("reporttype")
    public String reporttype;

    @SerializedName("serious")
    public String serious;

    @SerializedName("safetyreportversion")
    public String safetyreportversionreceivedateformat;

    @SerializedName("companynumb")
    public String companynumb;

    @SerializedName("seriousnesscongenitalanomali")
    public String seriousnesscongenitalanomali;

    @SerializedName("seriousnesshospitalization")
    public String seriousnesshospitalization;

    @SerializedName("seriousnessdisabling")
    public String seriousnessdisabling;

    @SerializedName("seriousnessdeath")
    public String seriousnessdeath;

    @SerializedName("seriousnesslifethreatening")
    public String seriousnesslifethreatening;

    @SerializedName("safetyreportid")
    public String safetyreportid;

    @SerializedName("primarysourcecountry")
    public String primarysourcecountry;

    public sender sender;

    public primarysource primarysource;

    public reportduplicate reportduplicate;

    public receiver receiver;

    public patient patient;

}
