package com.medimate.WorkingHoursMicroservice.repositories;

import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import com.medimate.WorkingHoursMicroservice.models.WorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackWorkingHoursRepository extends JpaRepository<TrackWorkingHours, Integer> {
}
