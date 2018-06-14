package com.example.admin.productcatalogmanager.view.main;

import com.example.admin.productcatalogmanager.model.Category;
import com.example.admin.productcatalogmanager.utils.DatabaseManager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    DatabaseManager dbManager;
    List<Category> categories = new ArrayList<>();

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;

        dbManager = dbManager.getInstance();
        dbManager.getDbCategories().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snap : dataSnapshot.getChildren()) {
                    Category category = new Category(snap.getKey());
                    categories.add(category);
                }

                DisplayCategories();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        dbManager.getDbCategories().addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                categories.add(dataSnapshot.getValue(Category.class));
//                DisplayCategories();
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void DisplayCategories() {
        view.OnDisplayCategories(categories);
    }
}
