package com.portfolio.app.service;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService {

    @Value("${app.razorpay.key-id:demo_key}")
    private String keyId;

    @Value("${app.razorpay.key-secret:demo_secret}")
    private String keySecret;

    public Map<String, Object> createCourseOrder(int amountInPaise, String receiptId) throws Exception {
        RazorpayClient client = new RazorpayClient(keyId, keySecret);
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", amountInPaise);
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", receiptId);
        orderRequest.put("payment_capture", 1);

        Order order = client.orders.create(orderRequest);
        return Map.of(
            "id", order.get("id"),
            "status", order.get("status"),
            "amount", order.get("amount")
        );
    }
}
