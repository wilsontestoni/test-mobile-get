package com.example.myapp;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Curso implements Serializable {
    private int id;
    private String title;
    private String category;
    private String img;

    private String description;
    private String address;
    private int occupiedSlots;
    private int maxCapacity;


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getImg() {
        return img;
    }

    public String getDescription() { return description; }

    public String getAddress() {
        return address;
    }

    public int getOccupiedSlots() {
        return occupiedSlots;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setDescription(String description) { this.description = description; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOccupiedSlots(int occupiedSlots) {
        this.occupiedSlots = occupiedSlots;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return
                "id=" + id + ", title='" + title + '\'' +
                    ", category='" + category + '\'' +
                    ", img='" + img + '\'' +
                    ", address='" + address + '\'' +
                    ", occupiedSlots=" + occupiedSlots +
                    ", maxCapacity=" + maxCapacity
                    ;
    }
    public Curso() {}
}
