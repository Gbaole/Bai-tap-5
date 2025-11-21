package com.example.bttuan5.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Category implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("images")
    private String images;

    @SerializedName("description")
    private String description;

    // Constructor (Tùy chọn)
    public Category(String id, String name, String images, String description) {
        this.id = id;
        this.name = name;
        this.images = images;
        this.description = description;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImages() {
        return images;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}