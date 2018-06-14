package com.example.admin.productcatalogmanager.utils;

import android.util.Log;
import android.widget.Toast;

import com.example.admin.productcatalogmanager.model.Category;
import com.example.admin.productcatalogmanager.model.Product;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    private static DatabaseManager instance = null;
    FirebaseDatabase db;
    DatabaseReference dbCategories;
    DatabaseReference dbProducts;

    private DatabaseManager(){
        db = FirebaseDatabase.getInstance();

        dbCategories = db.getReference("categories");
        dbProducts = db.getReference("products");
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
}
