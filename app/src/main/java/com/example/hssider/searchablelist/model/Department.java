package com.example.hssider.searchablelist.model;

import java.util.Date;

/**
 * Created by hssider on 12/10/15.
 */
public class Department {
    private String name;
    private String capital;
    private float extension;
    private int population;
    private Date foundation;
    private String imgPath;

    public Department() {
    }

    public Department(String name, String capital, float extension, int population, Date foundation, String imgPath) {
        this.name = name;
        this.capital = capital;
        this.extension = extension;
        this.population = population;
        this.foundation = foundation;
        this.imgPath = imgPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public float getExtension() {
        return extension;
    }

    public void setExtension(float extension) {
        this.extension = extension;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Date getFoundation() {
        return foundation;
    }

    public void setFoundation(Date foundation) {
        this.foundation = foundation;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}
