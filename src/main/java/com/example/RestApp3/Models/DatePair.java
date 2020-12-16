package com.example.RestApp3.Models;

import java.util.Date;

public class DatePair {
    private String lowerdate;
    private String higherdate;

    public DatePair() {
    }

    public DatePair(String lowerdate, String higherdate) {
        this.lowerdate = lowerdate;
        this.higherdate = higherdate;
    }

    public String getLowerdate() {
        return lowerdate;
    }

    public void setLowerdate(String lowerdate) {
        this.lowerdate = lowerdate;
    }

    public String getHigherdate() {
        return higherdate;
    }

    public void setHigherdate(String higherdate) {
        this.higherdate = higherdate;
    }
}
