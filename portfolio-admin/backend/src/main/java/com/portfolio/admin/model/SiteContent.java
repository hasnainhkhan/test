package com.portfolio.admin.model;

import jakarta.persistence.*;

@Entity
@Table(name = "site_content")
public class SiteContent {

    @Id
    private Long id = 1L;

    private String navTitle;
    private String heroTitle;

    @Column(length = 3000)
    private String heroDescription;

    private String themePrimaryColor;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNavTitle() { return navTitle; }
    public void setNavTitle(String navTitle) { this.navTitle = navTitle; }
    public String getHeroTitle() { return heroTitle; }
    public void setHeroTitle(String heroTitle) { this.heroTitle = heroTitle; }
    public String getHeroDescription() { return heroDescription; }
    public void setHeroDescription(String heroDescription) { this.heroDescription = heroDescription; }
    public String getThemePrimaryColor() { return themePrimaryColor; }
    public void setThemePrimaryColor(String themePrimaryColor) { this.themePrimaryColor = themePrimaryColor; }
}
