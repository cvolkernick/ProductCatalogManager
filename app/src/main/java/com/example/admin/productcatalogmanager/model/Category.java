package com.example.admin.productcatalogmanager.model;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private String name;
    private List<Product> products;

    public Category() {}

    public Category(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    @Override
    public String toString() {
        return name;
    }
}
