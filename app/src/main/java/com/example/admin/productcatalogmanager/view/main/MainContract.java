package com.example.admin.productcatalogmanager.view.main;

import com.example.admin.productcatalogmanager.model.Category;
import com.example.admin.productcatalogmanager.utils.base.BasePresenter;
import com.example.admin.productcatalogmanager.utils.base.BaseView;

import java.util.List;

public interface MainContract {

    interface View extends BaseView {
        void OnDisplayCategories(Iterable<Category> categories);
    }

    interface Presenter extends BasePresenter<View> {
        void DisplayCategories();
    }
}
