package com.example.RestApp3.Models;

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
    @OneToMany(mappedBy="Sensor")
    private List<SensorData> sensorDatas=new ArrayList<>();

    public Sensor() {
    }

    public Sensor(long sensorId, String sensorName, List<SensorData> sensorDatas) {
        this.sensorId = sensorId;
        this.sensorName = sensorName;
        this.sensorDatas = sensorDatas;
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
}
