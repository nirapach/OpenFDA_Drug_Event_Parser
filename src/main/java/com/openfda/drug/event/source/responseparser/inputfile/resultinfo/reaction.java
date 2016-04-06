package com.openfda.drug.event.source.responseparser.inputfile.resultinfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class reaction {

    @SerializedName("reactionmeddrapt")
    public String reactionmeddrapt;

    @SerializedName("reactionmeddraversionpt")
    public String reactionmeddraversionpt;

    @SerializedName("reactionoutcome")
    public String reactionoutcome;

}
