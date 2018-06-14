package com.example.admin.productcatalogmanager.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.admin.productcatalogmanager.R

class MainActivity : AppCompatActivity(), MainContract.View {

    var presenter: MainPresenter = MainPresenter()

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)
    }


}
