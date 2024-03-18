package com.DonationBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationBackend.model.*;
import com.DonationBackend.dao.EventDao;

@Service
public class EventService {
	
	@Autowired
	private EventDao eventRepository;
	
	
	public List<Event> getEvents(){
		return eventRepository.findAll();
	}
	
	public Event getEventById(int id) {
		return eventRepository.findById(id).get();
	}
	
	public List<Event> findEvents(int id){
    	List<Event> list = eventRepository.findAllByVolunteerId(id);
    	return list;
    }

	public void createEvent(Event event) {
		// TODO Auto-generated method stub
		eventRepository.save(event);
		
	}
	
	public void deleteEventById(int id) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            eventRepository.delete(event);
        } else {
            throw new IllegalArgumentException("Event with ID " + id + " not found");
        }
    }
}

	
