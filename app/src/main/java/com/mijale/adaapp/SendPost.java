package com.mijale.adaapp;

public class SendPost {

    String useruid, message, image;

    public SendPost() {
    }

    public SendPost(String useruid, String message, String image) {
        this.useruid = useruid;
        this.message = message;
        this.image = image;
    }

    public String getUseruid() {
        return useruid;
    }

    public void setUseruid(String useruid) {
        this.useruid = useruid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
