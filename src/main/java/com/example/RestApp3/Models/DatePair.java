package com.example.RestApp3.Models;

import java.util.Date;

public class DatePair {
    private Date lowerdate;
    private Date higherdate;

    public DatePair() {
    }

    public DatePair(Date lowerdate, Date higherdate) {
        this.lowerdate = lowerdate;
        this.higherdate = higherdate;
    }

    public Date getLowerdate() {
        return lowerdate;
    }

    public void setLowerdate(Date lowerdate) {
        this.lowerdate = lowerdate;
    }

    public Date getHigherdate() {
        return higherdate;
    }

    public void setHigherdate(Date higherdate) {
        this.higherdate = higherdate;
    }
}
