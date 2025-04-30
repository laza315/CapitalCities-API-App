package com.example.aplikacija1;

import android.os.Handler;

public class ReadDataHandler extends Handler {
    private String json;

    public String getJson2()  {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
