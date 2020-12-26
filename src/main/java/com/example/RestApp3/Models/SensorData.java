package com.example.RestApp3.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private long sensorId;
//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;
    private int dataValue;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sensId",referencedColumnName = "sensorId")
    private Sensor sensor;
    public SensorData() {
    }

    public SensorData(long sigId, long sensorId, Timestamp timestamp, int dataValue, Sensor sensor) {
        this.sigId = sigId;
        this.sensorId = sensorId;
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

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }


    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public Timestamp getDate() {
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
                ", sensorId=" + sensorId +
                ", timestamp=" + timestamp +
                ", dataValue=" + dataValue +
                ", sensor=" + sensor +
                '}';
    }
}
