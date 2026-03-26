package com.portfolio.admin.service;

import com.portfolio.admin.model.SiteContent;
import com.portfolio.admin.repository.SiteContentRepository;
import org.springframework.stereotype.Service;

@Service
public class SiteContentService {

    private final SiteContentRepository repository;

    public SiteContentService(SiteContentRepository repository) {
        this.repository = repository;
    }

    public SiteContent getOrCreate() {
        return repository.findById(1L).orElseGet(() -> {
            SiteContent content = new SiteContent();
            content.setNavTitle("My Portfolio");
            content.setHeroTitle("Hi, I am Hasnain");
            content.setHeroDescription("I build clean and modern web experiences.");
            content.setThemePrimaryColor("#6c63ff");
            return repository.save(content);
        });
    }

    public SiteContent updateAll(SiteContent incoming) {
        SiteContent existing = getOrCreate();
        existing.setNavTitle(incoming.getNavTitle());
        existing.setHeroTitle(incoming.getHeroTitle());
        existing.setHeroDescription(incoming.getHeroDescription());
        existing.setThemePrimaryColor(incoming.getThemePrimaryColor());
        return repository.save(existing);
    }

    public SiteContent updateTheme(String color) {
        SiteContent existing = getOrCreate();
        existing.setThemePrimaryColor(color);
        return repository.save(existing);
    }
}
