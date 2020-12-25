package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;

public interface TemperatureRepo extends JpaRepository<SensorData,Long> {

    @Query("from SensorData where dataValue< ?1 or dataValue> ?2")
    public List<SensorData>getOutOfRange(int lower, int higher);

    @Query("from SensorData where dataValue> ?1 and dataValue< ?2")
    public List<SensorData>getInRange(int lower, int higher);

    @Query("from SensorData where sensorId= ?1 order by date")
    public List<SensorData>getSignalsOfSensorId(int id);

    @Query("from SensorData where date> ?1 and date< ?2")
    public List<SensorData> getWithingdate(Date d1, Date d2);


}
