package com.caesar_84.retrofitlearning.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;

public class Hero implements Serializable {
    @SerializedName("name")
    @Expose
    @Getter
    private String name;
    @SerializedName("realname")
    @Expose
    @Getter
    private String realname;
    @SerializedName("team")
    @Expose
    @Getter
    private String team;
    @SerializedName("firstappearance")
    @Expose
    @Getter
    private String firstappearance;
    @SerializedName("createdby")
    @Expose
    @Getter
    private String createdby;
    @SerializedName("publisher")
    @Expose
    @Getter
    private String publisher;
    @SerializedName("imageurl")
    @Expose
    @Getter
    private String imageurl;
    @SerializedName("bio")
    @Expose
    @Getter
    private String bio;

    public Hero(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imageurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imageurl = imageurl;
        this.bio = bio;
    }
}