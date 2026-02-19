package com.portfolio.app.service;

import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WhatsAppBotService {

    @Value("${app.whatsapp.phone-number-id:your_phone_number_id}")
    private String phoneNumberId;

    @Value("${app.whatsapp.access-token:your_whatsapp_access_token}")
    private String accessToken;

    public Map<String, String> sendCourseWelcome(String customerPhoneNumber, String courseName) {
        // Hook this method with WhatsApp Cloud API POST /{phone-number-id}/messages
        // using RestTemplate/WebClient and include bearer token from accessToken.
        String preview = "Hi! Welcome to " + courseName + ". Payment received. We'll share your login now.";
        return Map.of(
            "status", "queued",
            "to", customerPhoneNumber,
            "previewMessage", preview,
            "provider", "whatsapp-cloud-api",
            "phoneNumberId", phoneNumberId,
            "tokenConfigured", String.valueOf(!"your_whatsapp_access_token".equals(accessToken))
        );
    }
}
