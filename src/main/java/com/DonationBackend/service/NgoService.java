package com.DonationBackend.service;

import com.DonationBackend.dto.NgoRegistrationDto;
import com.DonationBackend.model.Ngo;
import java.util.List;

public interface NgoService {
    void add(NgoRegistrationDto ngo);
    List<Ngo> getAll();
    List<Ngo> getAllApproved(); // New method to fetch only approved NGOs
    Ngo getById(int id);
    void update(int id, Ngo ngo);
    void delete(int id);
    void approve(int id); // New method to approve an NGO by ID
    void disApprove(int id);	// New method to Disapprove an NGO by ID
}
