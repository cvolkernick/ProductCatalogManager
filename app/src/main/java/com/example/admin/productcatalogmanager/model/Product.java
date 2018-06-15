package com.example.admin.productcatalogmanager.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Product implements Parcelable {

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.category);
        dest.writeString(this.description);
        dest.writeInt(this.stockQty);
        dest.writeDouble(this.price);
        dest.writeString(this.imagePath);
    }

    protected Product(Parcel in) {
        this.name = in.readString();
        this.category = in.readString();
        this.description = in.readString();
        this.stockQty = in.readInt();
        this.price = in.readDouble();
        this.imagePath = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}
