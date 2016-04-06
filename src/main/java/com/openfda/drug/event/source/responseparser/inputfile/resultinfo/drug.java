package com.openfda.drug.event.source.responseparser.inputfile.resultinfo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Niranjan on 1/25/2016.
 */
public class drug {

    @SerializedName("medicinalproduct")
    public String medicinalproduct;

    @SerializedName("drugindication")
    public String drugindication;

    @SerializedName("drugadministrationroute")
    public String drugadministrationroute;

    @SerializedName("actiondrug")
    public String actiondrugserious;

    @SerializedName("drugbatchnumb")
    public String drugbatchnumb;

    @SerializedName("drugcharacterization")
    public String drugcharacterization;

    @SerializedName("drugrucerreadministration")
    public String drugrucerreadministration;

    @SerializedName("drugauthorizationnumb")
    public String drugauthorizationnumb;

    @SerializedName("drugdosageform")
    public String drugdosageform;

    public activesubstance activesubstance;

}
