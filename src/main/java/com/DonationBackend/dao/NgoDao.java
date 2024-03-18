package com.DonationBackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DonationBackend.model.Ngo;

@Repository
public interface NgoDao extends JpaRepository<Ngo, Integer> {
    List<Ngo> findByIsApproved(boolean isApproved);
}
