package com.example.myfoodapp.models;

public class HomeVerModel {
    String image;
    String name;
    String timig;
    String rating;
    String price;

    public HomeVerModel(String image, String name, String timig, String rating, String price) {
        this.image = image;
        this.name = name;
        this.timig = timig;
        this.rating = rating;
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimig() {
        return timig;
    }

    public void setTimig(String timig) {
        this.timig = timig;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
