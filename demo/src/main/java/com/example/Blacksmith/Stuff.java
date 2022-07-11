package com.example.Blacksmith;

public class Stuff {
    
    private String title;
    private String material;

    public Stuff(String title, String material){
        this.title = title;
        this.material = material;
    }

    public String getTitle() {
        return title;
    }

    public String getMaterial() {
        return material;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
