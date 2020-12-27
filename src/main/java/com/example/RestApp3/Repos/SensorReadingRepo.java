package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Date;
import java.util.List;

public interface SensorReadingRepo extends JpaRepository<SensorData,Long> {

    @Query("from SensorData where dataValue< ?1 or dataValue> ?2")
    public List<SensorData>getOutOfRange(int lower, int higher);

    @Query("from SensorData where dataValue> ?1 and dataValue< ?2")
    public List<SensorData>getInRange(int lower, int higher);

    @Query("from SensorData where sensorId= ?1 order by timestamp")
    public List<SensorData>getSignalsOfSensorId(long id);

    @Query("from SensorData where timestamp> ?1 and timestamp< ?2")
    public List<SensorData> getWithingdate(Date d1, Date d2);


}
