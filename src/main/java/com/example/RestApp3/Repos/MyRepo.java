package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.MyDataClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface MyRepo extends JpaRepository<MyDataClass,Integer> {

    @Query("from SensorData where dataValue<?1 or dataValue>?2")
    public List<MyDataClass>getOutOfRange(int lower,int higher);

    @Query("from SensorData where dataValue>?1 and dataValue<?2")
    public List<MyDataClass>getInRange(int lower,int higher);

    @Query("from SensorData where sensorId=?1 order by date")
    public List<MyDataClass>getSignalsOfSensor(int id);

}
