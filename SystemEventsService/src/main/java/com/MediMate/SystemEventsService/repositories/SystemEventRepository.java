package com.MediMate.SystemEventsService.repositories;

import com.MediMate.SystemEventsService.models.SystemEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemEventRepository extends JpaRepository<SystemEvent,Integer> {
}
