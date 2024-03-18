package com.DonationBackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.*;

@Repository
public interface EventDao extends JpaRepository<Event, Integer>{
	
	@Query(value = "SELECT e.* FROM events e " +
            "JOIN enrollments en ON e.id = en.event_id " +
            "WHERE en.volunteer_id = :volunteerId", nativeQuery = true)
	List<Event> findAllByVolunteerId(int volunteerId);

}
