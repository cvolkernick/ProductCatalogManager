package com.example.admin.productcatalogmanager.view.category

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.bumptech.glide.Glide
import com.example.admin.productcatalogmanager.R
import com.example.admin.productcatalogmanager.model.Product
import kotlinx.android.synthetic.main.activity_category.*
import java.text.NumberFormat
import java.util.*

class CategoryActivity : AppCompatActivity(), CategoryContract.View {

    var products = ArrayList<Product>()
    var presenter: CategoryPresenter = CategoryPresenter()
    var productsAdapter: ProductsAdapter = ProductsAdapter(this, products)

    override fun OnDisplayProducts(products: Iterable<Product>) {
        this.products!!.clear()
        this.products!!.addAll(products!!)
        productsAdapter.notifyDataSetChanged()
    }

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        presenter.attachView(this)

        tvClickedTextVal.text = intent.getStringExtra("categoryName")

        lvProducts.adapter = productsAdapter
        lvProducts.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this, "Click on " + products[position].name, Toast.LENGTH_SHORT).show()
        }
    }

    inner class ProductsAdapter : BaseAdapter {

        private var products = ArrayList<Product>()
        private var context: Context? = null

        constructor(context: Context, products: ArrayList<Product>) : super() {
            this.products = products
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

            val view: View?
            val vh: ViewHolder

            if (convertView == null) {
                view = layoutInflater.inflate(R.layout.product_list_item, parent, false)
                vh = ViewHolder(view)
                view.tag = vh
            } else {
                view = convertView
                vh = view.tag as ViewHolder
            }

            vh.tvName.text = products[position].name
            vh.tvDescription.text = products[position].description
            vh.tvStockQty.text = "In Stock: " + products[position].stockQty.toString()

            var format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.US)
            var currency = format.format(products[position].price)
            vh.tvPrice.text = currency.toString()

            Glide.with(context).load(context!!.resources.getIdentifier(products[position].imagePath, "drawable", context!!.packageName)).into(vh.ivThumbnail)

            return view
        }

        override fun getItem(position: Int): Any {
            return products[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return products.size
        }
    }

    private class ViewHolder(view: View?) {
        val tvName: TextView
        val tvDescription: TextView
        val tvStockQty: TextView
        val tvPrice: TextView
        val ivThumbnail: ImageView

        init {
            this.tvName = view?.findViewById(R.id.tvName) as TextView
            this.tvDescription = view?.findViewById(R.id.tvDescription) as TextView
            this.tvStockQty = view?.findViewById(R.id.tvStockQty) as TextView
            this.tvPrice = view?.findViewById(R.id.tvPrice) as TextView
            this.ivThumbnail = view?.findViewById(R.id.ivThumbnail) as ImageView
        }
    }
}
