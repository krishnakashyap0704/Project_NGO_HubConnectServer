package com.DonationBackend.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationBackend.model.Enrollment;
import com.DonationBackend.model.Event;
import com.DonationBackend.model.Volunteer;
import com.DonationBackend.dao.EnrollmentDao;


@Service
public class EnrollmentService {
	
	@Autowired
	private EnrollmentDao enrollmentRepository;
	
	@Autowired
    private VolunteerServiceImpl volunteerService;

    @Autowired
    private EventService eventService;

    public void registerForEvent(int volunteerId, int eventId) {
    	Volunteer volunteer = volunteerService.getById(volunteerId);
        Event event = eventService.getEventById(eventId);

        // Perform any additional checks or business logic here

        Enrollment enrollment = new Enrollment();
        enrollment.setVolunteer(volunteer);
        enrollment.setEvent(event);

        // Save the enrollment to the database
        // You need to implement the save method in your EnrollmentRepository
        enrollmentRepository.save(enrollment);
    }
    
    
    public void removeEnrollment(int eventId, int userId) {
    	enrollmentRepository.deleteByEventIdAndVolunteerId(eventId, userId);
    }
    

}
