package com.example.prince.dcoderforums.data.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chat {

    @SerializedName("user_name")
    @Expose
    private String userName;
    @SerializedName("user_image_url")
    @Expose
    private String userImageUrl;
    @SerializedName("is_sent_by_me")
    @Expose
    private Boolean isSentByMe;
    @SerializedName("text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     */
    public Chat() {
    }

    /**
     * @param text
     * @param userImageUrl
     * @param isSentByMe
     * @param userName
     */
    public Chat(String userName, String userImageUrl, Boolean isSentByMe, String text) {
        super();
        this.userName = userName;
        this.userImageUrl = userImageUrl;
        this.isSentByMe = isSentByMe;
        this.text = text;
    }

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

    public Boolean getIsSentByMe() {
        return isSentByMe;
    }

    public void setIsSentByMe(Boolean isSentByMe) {
        this.isSentByMe = isSentByMe;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}
