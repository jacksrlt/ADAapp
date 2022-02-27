package com.mijale.adaapp;

public class SendPost {

    String useruid, message;

    public SendPost() {
    }

    public SendPost(String useruid, String message) {
        this.useruid = useruid;
        this.message = message;
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
}
