package com.DonationBackend.cntr;

import com.DonationBackend.dao.RazorpayOrderDao;
import com.DonationBackend.model.RazorpayOrder;
import com.razorpay.*;

import java.math.BigDecimal;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class PaymentRestController {

	@Autowired
    private RazorpayOrderDao razorpayOrderDao;
	
    @Value("${razorpay.key}")
    private String razorpayKey;

    @Value("${razorpay.secret}")
    private String razorpaySecret;

    @PostMapping("/createOrder")
    @ResponseBody
    public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException {
        try {
            System.out.println(data);

            int amount = Integer.parseInt(data.get("amount").toString());

            RazorpayClient client = new RazorpayClient(razorpayKey, razorpaySecret);

            JSONObject options = new JSONObject();
            options.put("amount", amount * 100); // Amount should be provided instead of fees
            options.put("currency", "INR");
            options.put("receipt", "txn_" + System.currentTimeMillis()); // Generating a unique receipt ID
            
            Order order = client.Orders.create(options); // Use uppercase Orders instead of orders
            
         // Save order details into the database
            BigDecimal amountBD = BigDecimal.valueOf(amount);
            RazorpayOrder razorpayOrder = new RazorpayOrder();
            razorpayOrder.setAmount(amountBD);
            razorpayOrder.setCurrency("INR");
            razorpayOrder.setReceipt(options.getString("receipt"));
            razorpayOrderDao.save(razorpayOrder);
            
            return order.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create order";
        }
    }

}
