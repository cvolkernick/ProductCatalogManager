package com.example.admin.productcatalogmanager.view.category;

import com.example.admin.productcatalogmanager.model.Product;
import com.example.admin.productcatalogmanager.utils.base.BasePresenter;
import com.example.admin.productcatalogmanager.utils.base.BaseView;

public interface CategoryContract {

    interface View extends BaseView {
        void OnDisplayProducts(Iterable<Product> products);
    }

    interface Presenter extends BasePresenter<View> {
        void DisplayProducts();
    }
}
