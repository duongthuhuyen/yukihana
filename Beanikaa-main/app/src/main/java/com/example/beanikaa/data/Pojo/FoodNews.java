package com.example.beanikaa.data.Pojo;

import java.util.Date;

public class FoodNews {
    private int id;
    private String thumbnal;
    private String foodName;
    private int idRestaurant;
    private int vote;
    private int status;
    private double price;
    private int sale;
    private Date dateFrom;
    private Date dateTo;
    private String category;
    private int idCategory;
    private int priority;

    public FoodNews(int id, String thumbnal, String foodName, int idRestaurant, int vote, int status, double price, int sale, String category, int idCategory, int priority) {
        this.id = id;
        this.thumbnal = thumbnal;
        this.foodName = foodName;
        this.idRestaurant = idRestaurant;
        this.vote = vote;
        this.status = status;
        this.price = price;
        this.sale = sale;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.category = category;
        this.idCategory = idCategory;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnal() {
        return thumbnal;
    }

    public void setThumbnal(String thumbnal) {
        this.thumbnal = thumbnal;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
