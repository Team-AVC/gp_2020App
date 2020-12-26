package com.example.RestApp3.Repos;

import com.example.RestApp3.Models.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepo extends JpaRepository<Alert,Long> {
}
