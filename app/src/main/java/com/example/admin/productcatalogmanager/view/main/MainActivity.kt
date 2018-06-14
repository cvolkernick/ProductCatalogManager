package com.example.admin.productcatalogmanager.view.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.example.admin.productcatalogmanager.R
import com.example.admin.productcatalogmanager.model.Category
import com.example.admin.productcatalogmanager.view.category.CategoryActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.category_list_item.*
import kotlinx.android.synthetic.main.category_list_item.view.*

class MainActivity : AppCompatActivity(), MainContract.View {

    var categories: MutableList<Category>? = ArrayList<Category>()
    var adapter: ArrayAdapter<Category>? = null
    var presenter: MainPresenter = MainPresenter()

    override fun OnDisplayCategories(categories: Iterable<Category>?) {
        this.categories!!.clear()
        this.categories!!.addAll(categories!!)
        adapter!!.notifyDataSetChanged()
    }

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        adapter = ArrayAdapter(this, R.layout.category_list_item, categories)
        lvCategories.adapter = adapter;

        lvCategories.setOnItemClickListener { adapterView, view, position, id ->
            val intent = Intent(this@MainActivity, CategoryActivity::class.java)
            intent.putExtra("categoryName", view.tvCategoryItem.text)
            startActivity(intent)
        }
    }


}
