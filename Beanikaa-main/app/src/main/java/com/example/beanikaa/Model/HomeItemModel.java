package com.example.beanikaa.Model;

public class HomeItemModel {
    private String image;
    private String addresstxt;
    private Double starttxt;
    private String inf;//(++200)

    public HomeItemModel(String image, String addresstxt, Double starttxt, String inf) {
        this.image = image;
        this.addresstxt = addresstxt;
        this.starttxt = starttxt;
        this.inf = inf;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddresstxt() {
        return addresstxt;
    }

    public void setAddresstxt(String addresstxt) {
        this.addresstxt = addresstxt;
    }

    public Double getStarttxt() {
        return starttxt;
    }

    public void setStarttxt(Double starttxt) {
        this.starttxt = starttxt;
    }

    public String getInf() {
        return inf;
    }

    public void setInf(String inf) {
        this.inf = inf;
    }
}
