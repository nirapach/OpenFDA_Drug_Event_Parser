package com.openfda.drug.event.source.responseparser.inputfile.resultinfo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class patient {

    @SerializedName("patientonsetage")
    public String patientonsetage;

    @SerializedName("patientsex")
    public String serious;

    @SerializedName("patientgroup")
    public String patientgroup;

    @SerializedName("patientonsetageunit")
    public String patientonsetageunit;

    public List<reaction> reaction;

    public List<drug> drug;

}
