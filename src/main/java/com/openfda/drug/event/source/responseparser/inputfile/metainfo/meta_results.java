package com.openfda.drug.event.source.responseparser.inputfile.metainfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class meta_results {
    @SerializedName("skip")
    public int skip;

    @SerializedName("total")
    public long total;

    @SerializedName("limit")
    public int limit;
}

