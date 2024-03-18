package com.DonationBackend.cntr;  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.DonationBackend.dto.NgoRegistrationDto;
import com.DonationBackend.model.*;
import com.DonationBackend.service.*;

@RestController
@CrossOrigin
public class NgoRestController {
    
    @Autowired
    private NgoService ngoService;
    
    // Add a new NGO
    @PostMapping("/ngoRegistrationForm")
    public void addNgo(@RequestBody NgoRegistrationDto ngo) {
        ngoService.add(ngo);
    }
    
    // Get all approved NGOs
    @GetMapping("/approvedNgoRegisteredList")
    public List<Ngo> getAllApprovedNgos() {
        return ngoService.getAllApproved();
    }
    
    // Get all NGOs (including pending and approved)
    @GetMapping("/allNgoRegisteredList")
    public List<Ngo> getAllNgos() {
        return ngoService.getAll();
    }
    
    // Get NGO by ID
    @GetMapping("/ngo/{id}")
    public Ngo getNgoById(@PathVariable int id) {
        return ngoService.getById(id);
    }
    
    // Approve NGO by ID
    @PutMapping("/approveNgo/{id}")
    public void approveNgo(@PathVariable int id) {
        ngoService.approve(id);
    }
    
    // Disapprove NGO by ID
    @PutMapping("/disApproveNgo/{id}")
    public void disApproveNgo(@PathVariable int id) {
        ngoService.disApprove(id);
    }
    
    // Update NGO
    @PutMapping("/ngoDetailsUpdate/{id}")
    public void updateNgo(@PathVariable int id, @RequestBody Ngo ngo) {
        ngoService.update(id, ngo);
    }
    
    // Delete NGO
    @DeleteMapping("/ngoDelete/{id}")
    public void deleteNgo(@PathVariable int id) {
        ngoService.delete(id);
    }
}
