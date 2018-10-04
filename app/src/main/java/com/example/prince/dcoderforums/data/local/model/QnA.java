package com.example.prince.dcoderforums.data.local.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QnA {

    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_image_url")
    @Expose
    private String userImageUrl;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("tags")
    @Expose
    private List<String> tags = null;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("upvotes")
    @Expose
    private Integer upvotes;
    @SerializedName("downvotes")
    @Expose
    private Integer downvotes;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

}
