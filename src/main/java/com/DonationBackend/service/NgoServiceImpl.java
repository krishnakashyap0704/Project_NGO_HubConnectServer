package com.DonationBackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DonationBackend.dao.NgoDao;
import com.DonationBackend.dto.NgoRegistrationDto;
import com.DonationBackend.model.Ngo;

@Service
public class NgoServiceImpl implements NgoService {

    @Autowired
    private NgoDao ngoDao;

    @Override
    public void add(NgoRegistrationDto ngoDto) {
        Ngo ngo = new Ngo();
        BeanUtils.copyProperties(ngoDto, ngo);
        // By default, newly added NGOs are not approved
        ngo.setApproved(false);
        ngoDao.save(ngo);
    }

    @Override
    public List<Ngo> getAll() {
        return ngoDao.findAll();
    }

    @Override
    public List<Ngo> getAllApproved() {
        return ngoDao.findByIsApproved(true);
    }

    @Override
    public Ngo getById(int id) {
        Optional<Ngo> optionalNgo = ngoDao.findById(id);
        return optionalNgo.orElse(null);
    }

    @Override
    public void update(int id, Ngo ngo) {
        Optional<Ngo> optionalNgo = ngoDao.findById(id);
        if (optionalNgo.isPresent()) {
            Ngo existingNgo = optionalNgo.get();
            // Update only if the NGO is already approved
            if (existingNgo.isApproved()) {
                ngo.setNgoId(id);
                ngoDao.save(ngo);
            }
        }
    }

    @Override
    public void delete(int id) {
        Optional<Ngo> optionalNgo = ngoDao.findById(id);
        if (optionalNgo.isPresent()) {
            Ngo ngo = optionalNgo.get();
            // Delete only if the NGO is already approved
            if (ngo.isApproved()) {
                ngoDao.deleteById(id);
            }
        }
    }
    
    @Override
    public void approve(int id) {
        Optional<Ngo> optionalNgo = ngoDao.findById(id);
        if (optionalNgo.isPresent()) {
            Ngo ngo = optionalNgo.get();
            ngo.setApproved(true);
            ngoDao.save(ngo);
        }
    }
    
    @Override
    public void disApprove(int id) {
        Optional<Ngo> optionalNgo = ngoDao.findById(id);
        if (optionalNgo.isPresent()) {
            Ngo ngo = optionalNgo.get();
            ngo.setApproved(false);
            ngoDao.save(ngo);
        }
    }
}
