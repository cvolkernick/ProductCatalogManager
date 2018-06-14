package com.example.admin.productcatalogmanager.utils;

import com.example.admin.productcatalogmanager.model.Category;
import com.example.admin.productcatalogmanager.model.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseManager {

    private static DatabaseManager instance = null;
    FirebaseDatabase db;
    DatabaseReference dbCategories;
    DatabaseReference dbProducts;

    private DatabaseManager(){
        db = FirebaseDatabase.getInstance();

        dbCategories = db.getReference("categories");
        dbProducts = db.getReference("products");

        Product p = new Product("Serving Tray", "Kitchen Supply", "A tray to serve food items on", 25, 24.99, "~/servingTray.png");
        addProduct(p);
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }

        return instance;
    }

    public void addCategory(String categoryName) {
        dbCategories.child(categoryName).setValue(new Category(categoryName));
    }

    public DatabaseReference getCategory(String categoryName) {
        return dbCategories.child(categoryName);
    }

    public void setCategory(String oldCategory, String newCategory) {
        dbCategories.child(oldCategory).setValue(null);
        addCategory(newCategory);
    }

    public void deleteCategory(String categoryName) {
        dbCategories.child(categoryName).setValue(null);
    }

    public void addProduct(Product product) {
        dbProducts.child(product.getName()).setValue(product);
    }

    public DatabaseReference getProduct(String productName) {
        return dbProducts.child(productName);
    }

    public void setProduct(Product product) {
        dbProducts.child(product.getName()).setValue(product);
    }

    public void deleteProduct(String productName) {
        dbProducts.child(productName).setValue(null);
    }
}
