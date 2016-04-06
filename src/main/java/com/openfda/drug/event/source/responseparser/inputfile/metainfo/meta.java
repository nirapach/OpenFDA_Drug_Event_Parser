package com.openfda.drug.event.source.responseparser.inputfile.metainfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class meta{
    @SerializedName("last_updated")
    public String last_updated;

    @SerializedName("license")
    public String license;

    @SerializedName("disclaimer")
    public String date_start;

    public meta_results results;

}
