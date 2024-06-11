package com.medimate.WorkingHoursMicroservice.repositories;

import com.medimate.WorkingHoursMicroservice.models.TrackWorkingHours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackWorkingHoursRepository extends JpaRepository<TrackWorkingHours, Integer> {
    List<TrackWorkingHours> findByAdminId(Integer adminId);

    @Modifying
    @Query("DELETE FROM TrackWorkingHours AS twh WHERE twh.id = :trackWorkingHoursId AND twh.adminId = :adminId")
    void deleteByAdminId(@Param("trackWorkingHoursId") Integer trackWorkingHoursId,
                           @Param("adminId") Integer adminId);

    void deleteAllByAdminId(Integer adminId);

}
