package com.example.RestApp3.Models;


import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sensordata")
public class MyDataClass {
    @Id
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="seq",
            sequenceName = "id_seq",
            initialValue = 1,
            allocationSize = 1)
    private int sigId;
    private int sensorId;
    @Temporal(TemporalType.DATE)
    private Date date;
    private int dataValue;

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

    public int getDataValue() {
        return dataValue;
    }

    public void setDataValue(int dataValue) {
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
