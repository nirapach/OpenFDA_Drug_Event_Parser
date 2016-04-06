package com.openfda.drug.event.source.responseparser.inputfile.resultinfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class sender {
    @SerializedName("senderorganization")
    public String senderorganization;

    @SerializedName("sendertype")
    public String sendertype;

}
