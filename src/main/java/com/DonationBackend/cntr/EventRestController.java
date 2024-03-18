package com.DonationBackend.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DonationBackend.dto.EnrollmentDto;
import com.DonationBackend.model.Event;
import com.DonationBackend.service.EnrollmentService;
import com.DonationBackend.service.EventService;

@RestController
@CrossOrigin
public class EventRestController {
	
	@Autowired
	private EventService eventService;
	
	
	@Autowired
    private EnrollmentService enrollmentService;
	
	@GetMapping("/events")
	public List<Event> fetchAll(){
		List<Event> list = eventService.getEvents();
		return list;
	}
	

    @PostMapping("/register-event")
    public ResponseEntity<String> registerForEvent(@RequestBody EnrollmentDto enrollmentDTO) {
        try {
            enrollmentService.registerForEvent(enrollmentDTO.getVolunteerId(), enrollmentDTO.getEventId());
            return ResponseEntity.ok("User registered for the event successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error registering for the event: " + e.getMessage());
        }
    }
	
    @PostMapping("/create-event")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        try {
            eventService.createEvent(event);
            return ResponseEntity.ok("Event Created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating the event: " + e.getMessage());
        }
    }
    
    @GetMapping("/show-events/{id}")
    public List<Event> fetchbyId(@PathVariable int id){
    	List<Event> list = eventService.findEvents(id);
    	return list;
    }
    
    @DeleteMapping("withdraw-events/{eventId}/{volunteerId}")
    public ResponseEntity<String> deleteEventUser(@PathVariable("eventId") int eventId, @PathVariable("volunteerId") int volunteerId) {
        enrollmentService.removeEnrollment(eventId,volunteerId);
        return ResponseEntity.ok("Records deleted successfully");
    }
    
    @DeleteMapping("delete-events/{eventId}")
    public ResponseEntity<String> deleteEvent(@PathVariable("eventId") int eventId) {
        eventService.deleteEventById(eventId);
        return ResponseEntity.ok("Records deleted successfully");
    }
    
}
