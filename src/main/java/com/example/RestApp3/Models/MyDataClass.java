package com.example.RestApp3.Models;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SensorData")
public class MyDataClass {
    @Id
    @GeneratedValue
    private int sigId;
    private int sensorId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String dataValue;

    public MyDataClass() {
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "MyDataClass{" +
                "sensorId=" + sensorId +
                ", date=" + date +
                ", dataValue='" + dataValue + '\'' +
                '}';
    }
}
