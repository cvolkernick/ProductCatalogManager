package com.example.admin.productcatalogmanager.model;

public class Product {

    private String name;

    private String category;
    private String description;
    private int stockQty;
    private double price;
    private String imagePath;
    public Product(){ }

    public Product(String name, String category, String description, int stockQty, double price, String imagePath) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.stockQty = stockQty;
        this.price = price;
        this.imagePath = imagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStockQty() {
        return stockQty;
    }

    public void setStockQty(int stockQty) {
        this.stockQty = stockQty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
