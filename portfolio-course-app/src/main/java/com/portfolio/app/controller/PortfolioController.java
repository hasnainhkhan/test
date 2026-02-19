package com.portfolio.app.controller;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PortfolioController {

    @GetMapping("/")
    public Map<String, String> home() {
        return Map.of(
            "message", "Welcome to your portfolio + course app backend",
            "nextStep", "Configure OAuth clients, Razorpay keys, and WhatsApp Cloud API token in application.yml"
        );
    }

    @GetMapping("/portfolio")
    public Map<String, Object> portfolio() {
        return Map.of(
            "name", "Your Name",
            "headline", "Java / Spring Boot Developer",
            "course", "Spring Security + OAuth Full Course"
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of("status", "ok");
    }
}
