package com.DonationBackend.dao;
import com.DonationBackend.model.RazorpayOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RazorpayOrderDao extends JpaRepository<RazorpayOrder, Long> {
    // You can add custom query methods here if needed
}
