package com.DonationBackend.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.*;

import javax.transaction.Transactional;

@Repository
public interface EnrollmentDao extends JpaRepository<Enrollment, Integer> {
	
	@Transactional
    @Modifying
	@Query(value = "delete from enrollments where event_id = ?1 AND volunteer_id = ?2", nativeQuery = true)
	public void deleteByEventIdAndVolunteerId(int eventId, int volunteerId);
	
	
}
