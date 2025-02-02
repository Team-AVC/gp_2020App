package com.example.RestApp3.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Alert")
public class Alert {
    @Id
//    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name="seq",
//            sequenceName = "id_seq",
//            initialValue = 1,
//            allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long alertId;
    private long sensorId;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "sensId",referencedColumnName = "sensorId")
    private Sensor sensor;
    private String aMessage;
    private Timestamp timestamp;

    public Alert() {
    }

    public Alert(long alertId, long sensorId, Sensor sensor, String aMessage, Timestamp timestamp) {
        this.alertId = alertId;
        this.sensorId = sensorId;
        this.sensor = sensor;
        this.aMessage = aMessage;
        this.timestamp = timestamp;
    }

    public Alert(long sensorId, Sensor sensor, String aMessage, Timestamp timestamp) {
        this.sensorId = sensorId;
        this.sensor = sensor;
        this.aMessage = aMessage;
        this.timestamp = timestamp;
    }

    public long getAlertId() {
        return alertId;
    }

    public void setAlertId(long alertId) {
        this.alertId = alertId;
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

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }

    public String getaMessage() {
        return aMessage;
    }

    public void setaMessage(String aMessage) {
        this.aMessage = aMessage;
    }

    @Override
    public String toString() {
        return "Alert{" +
                "alertId=" + alertId +
                ", sensorId=" + sensorId +
                ", sensor=" + sensor +
                ", aMessage='" + aMessage + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
