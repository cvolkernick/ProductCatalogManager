package com.example.admin.productcatalogmanager.view.category;

import android.view.Display;

import com.example.admin.productcatalogmanager.model.Product;
import com.example.admin.productcatalogmanager.utils.DatabaseManager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class CategoryPresenter implements CategoryContract.Presenter {

    CategoryContract.View view;
    DatabaseManager dbManager;
    List<Product> products = new ArrayList<>();

    @Override
    public void attachView(CategoryContract.View view) {
        this.view = view;

        dbManager = dbManager.getInstance();
        dbManager.getDbProducts().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snap : dataSnapshot.getChildren()) {
                    Product product = new Product(
                            snap.child("name").getValue().toString(),
                            snap.child("category").getValue().toString(),
                            snap.child("description").getValue().toString(),
                            Integer.parseInt(snap.child("stockQty").getValue().toString()),
                            Double.parseDouble(snap.child("price").getValue().toString()),
                            snap.child("imagePath").getValue().toString()
                    );

                    products.add(product);
                }

                DisplayProducts();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void DisplayProducts() {
        view.OnDisplayProducts(products);
    }
}
