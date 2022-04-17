package com.example.myfoodapp.models;

import androidx.recyclerview.widget.RecyclerView;

public class DailyMealModel {
    int image;
    String name;
    String discount;
    String type;
    String descript;

    public DailyMealModel(int image, String name, String discount, String type, String descript) {
        this.image = image;
        this.name = name;
        this.discount = discount;
        this.type = type;
        this.descript = descript;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }



}
