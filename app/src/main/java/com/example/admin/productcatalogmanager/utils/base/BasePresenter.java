package com.example.admin.productcatalogmanager.utils.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();
}
