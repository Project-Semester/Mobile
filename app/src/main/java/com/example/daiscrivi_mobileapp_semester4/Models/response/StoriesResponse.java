package com.example.daiscrivi_mobileapp_semester4.Models.response;

import java.util.List;

public class StoriesResponse {

    private boolean status;
    private String message;
    List<Stories> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Stories> getData() {
        return data;
    }

    public void setData(List<Stories> data) {
        this.data = data;
    }
}
