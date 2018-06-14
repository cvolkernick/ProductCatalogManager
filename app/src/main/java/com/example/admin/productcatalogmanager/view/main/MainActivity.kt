package com.example.admin.productcatalogmanager.view.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.admin.productcatalogmanager.R
import com.example.admin.productcatalogmanager.model.Category
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.category_list_item.*

class MainActivity : AppCompatActivity(), MainContract.View {

    var categories: MutableList<Category>? = ArrayList<Category>()
    var adapter: ArrayAdapter<Category>? = null

    override fun OnDisplayCategories(categories: Iterable<Category>?) {
        this.categories!!.clear()
        this.categories!!.addAll(categories!!)
        adapter!!.notifyDataSetChanged()
    }

    var presenter: MainPresenter = MainPresenter()

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        adapter = ArrayAdapter(this, R.layout.category_list_item, categories)
        lvCategories.adapter = adapter;
    }


}
