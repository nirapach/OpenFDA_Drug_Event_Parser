package com.openfda.drug.event.source.responseparser.inputfile.resultinfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class primarysource {

    @SerializedName("literaturereference")
    public String literaturereference ;

    @SerializedName("reportercountry")
    public String reportercountry;

    @SerializedName("qualification")
    public String qualification;

}
