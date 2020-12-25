package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepo extends JpaRepository<Sensor,Long> {

}
