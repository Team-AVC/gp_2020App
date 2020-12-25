package com.example.RestApp3.Models;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "sensordata")
public class SensorData {
    @Id
//    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name="seq",
//            sequenceName = "id_seq",
//            initialValue = 1,
//            allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long sigId;
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    private int dataValue;
    @ManyToOne
    @JoinColumn(name = "sensorId",referencedColumnName = "sensorId")
    private Sensor sensor;
    public SensorData() {
    }

    public SensorData(long sigId, Date timestamp, int dataValue, Sensor sensor) {
        this.sigId = sigId;
        this.timestamp = timestamp;
        this.dataValue = dataValue;
        this.sensor = sensor;
    }

    public long getSigId() {
        return sigId;
    }

    public void setSigId(long sigId) {
        this.sigId = sigId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }


    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Date getDate() {
        return timestamp;
    }

    public void setDate(Date date) {
        this.timestamp = timestamp;
    }

    public int getDataValue() {
        return dataValue;
    }

    public void setDataValue(int dataValue) {
        this.dataValue = dataValue;
    }

    @Override
    public String toString() {
        return "SensorData{" +
                "sigId=" + sigId +
                ", timestamp=" + timestamp +
                ", dataValue=" + dataValue +
                ", sensor=" + sensor +
                '}';
    }
}
