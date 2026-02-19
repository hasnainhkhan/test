package com.portfolio.app.controller;

import com.portfolio.app.service.RazorpayService;
import com.portfolio.app.service.WhatsAppBotService;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/course")
public class CourseSalesController {

    private final RazorpayService razorpayService;
    private final WhatsAppBotService whatsAppBotService;

    public CourseSalesController(RazorpayService razorpayService, WhatsAppBotService whatsAppBotService) {
        this.razorpayService = razorpayService;
        this.whatsAppBotService = whatsAppBotService;
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody Map<String, String> request) {
        try {
            String receiptId = request.getOrDefault("receiptId", "course-receipt-1");
            int amount = Integer.parseInt(request.getOrDefault("amount", "99900"));
            return ResponseEntity.ok(razorpayService.createCourseOrder(amount, receiptId));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Map.of("error", exception.getMessage()));
        }
    }

    @PostMapping("/notify")
    public ResponseEntity<?> sendSalesMessage(@RequestBody Map<String, String> request) {
        String phone = request.getOrDefault("phone", "");
        String course = request.getOrDefault("course", "Your Course");
        return ResponseEntity.ok(whatsAppBotService.sendCourseWelcome(phone, course));
    }
}
