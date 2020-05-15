package com.leandro.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Picture {

    String title;
    String hdurl;
    String explanation;
    String date;
    String copyright;

    public Picture(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHdurl() {
        return hdurl;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @Override
    public String toString() {
        return "Picture [title=" + title +", date=" + date + ", explanation=" + explanation + ", hdurl="
                + hdurl + ", copyright=" + copyright + "]";
    }

}