package com.sit.myfirstapp.networking;

import com.google.gson.annotations.SerializedName;

public class Repo {

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String repoName;
}
