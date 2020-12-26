package com.example.RestApp3.Models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Sensor")
public class Sensor {
    @Id
//    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
//    @SequenceGenerator(name="seq",
//            sequenceName = "id_seq",
//            initialValue = 1,
//            allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long sensorId;
    private String sensorName;
    @JsonManagedReference
    @OneToMany(mappedBy="sensor")
    private List<SensorData> sensorDatas=new ArrayList<>();
    @JsonManagedReference
    @OneToMany(mappedBy="sensor")
    private List<Alert> alertDatas=new ArrayList<>();
    public Sensor() {
    }

    public Sensor(long sensorId, String sensorName, List<SensorData> sensorDatas, List<Alert> alertDatas) {
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.sensorDatas = sensorDatas;
        this.alertDatas = alertDatas;
    }

    public long getSensorId() {
        return sensorId;
    }

    public void setSensorId(long sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public List<SensorData> getSensorDatas() {
        return sensorDatas;
    }

    public void setSensorDatas(List<SensorData> sensorDatas) {
        this.sensorDatas = sensorDatas;
    }

    public List<Alert> getAlertDatas() {
        return alertDatas;
    }

    public void setAlertDatas(List<Alert> alertDatas) {
        this.alertDatas = alertDatas;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "sensorId=" + sensorId +
                ", sensorName='" + sensorName + '\'' +
                ", sensorDatas=" + sensorDatas +
                ", alertDatas=" + alertDatas +
                '}';
    }
}
