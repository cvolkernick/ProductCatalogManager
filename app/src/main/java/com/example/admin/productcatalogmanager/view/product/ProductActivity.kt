package com.example.admin.productcatalogmanager.view.product

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.admin.productcatalogmanager.R
import com.example.admin.productcatalogmanager.model.Product
import com.example.admin.productcatalogmanager.utils.DatabaseManager
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_product.*
import java.text.NumberFormat
import java.util.*

class ProductActivity : AppCompatActivity() {

    lateinit var product: Product;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        var clickedProduct = intent.getStringExtra("clickedProduct")

        Toast.makeText(this, clickedProduct, Toast.LENGTH_SHORT)

        var dbManager: DatabaseManager = DatabaseManager.getInstance()
        var productRef: DatabaseReference = dbManager.getProduct(clickedProduct)

        productRef.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError?) {
                
            }

            override fun onDataChange(snap: DataSnapshot?) {
                var product: Product = Product(
                        snap?.child("name")?.value.toString(),
                        snap?.child("category")?.value.toString(),
                        snap?.child("description")?.value.toString(),
                        snap?.child("stockQty")?.value.toString().toInt(),
                        snap?.child("price")?.value.toString().toDouble(),
                        snap?.child("imagePath")?.value.toString()
                )

                ShowDetails(product)
            }
        })
    }

    fun ShowDetails(product: Product) {
        this.tvName.text = product.name
        Glide.with(this).load(this!!.resources.getIdentifier(product.imagePath, "drawable", this!!.packageName)).into(this.ivThumbnail)
        this.tvDescription.text = product.description
        this.tvStockQty.text = "In Stock: " + product.stockQty.toString()

        var format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
        this.tvPrice.text = format.format(product.price)
    }
}
