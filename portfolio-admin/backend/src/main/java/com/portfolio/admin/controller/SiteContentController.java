package com.portfolio.admin.controller;

import com.portfolio.admin.model.SiteContent;
import com.portfolio.admin.service.SiteContentService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/content")
@CrossOrigin(origins = "http://localhost:5173")
public class SiteContentController {

    private final SiteContentService service;

    public SiteContentController(SiteContentService service) {
        this.service = service;
    }

    @GetMapping
    public SiteContent getContent() {
        return service.getOrCreate();
    }

    @PutMapping
    public SiteContent updateContent(@RequestBody SiteContent content) {
        return service.updateAll(content);
    }

    @PutMapping("/theme")
    public SiteContent updateTheme(@RequestBody Map<String, String> payload) {
        return service.updateTheme(payload.get("themePrimaryColor"));
    }
}
