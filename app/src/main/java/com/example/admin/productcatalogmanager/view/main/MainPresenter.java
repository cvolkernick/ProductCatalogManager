package com.example.admin.productcatalogmanager.view.main;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    DatabaseReference db;

    public void ConfigDB() {
        db = FirebaseDatabase.getInstance().getReference("ProductCatalog");
    }

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
