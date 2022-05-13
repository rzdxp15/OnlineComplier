package com.example.springdemo.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class newss {
    String title;
    String url;
    @JsonIgnoreProperties(value = "res")
    String res;
   public newss(String title,String url,String res){
       this.title=title;
       this.url=url;
       this.res=res;
   }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
