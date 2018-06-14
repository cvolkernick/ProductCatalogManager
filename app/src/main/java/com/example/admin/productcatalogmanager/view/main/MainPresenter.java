package com.example.admin.productcatalogmanager.view.main;

import com.example.admin.productcatalogmanager.utils.DatabaseManager;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainPresenter implements MainContract.Presenter {

    MainContract.View view;
    DatabaseManager dbManager;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;

        dbManager = dbManager.getInstance();
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
