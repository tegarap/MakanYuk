package id.co.tegarap.makanyuk.ui.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.widget.ImageView
import android.widget.Toast
import com.smarteist.autoimageslider.SliderView
import id.co.tegarap.makanyuk.R
import id.co.tegarap.makanyuk.adapter.AdapterMeals
import id.co.tegarap.makanyuk.api.ApiConfig
import id.co.tegarap.makanyuk.model.Meals
import id.co.tegarap.makanyuk.ui.detailmeals.DetailMealsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var mainPresenter: MainPresenter
    private lateinit var adapterMeals: AdapterMeals
    private val listMeals: MutableList<Meals> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ApiConfig.getApi(this)
        mainPresenter = MainPresenter(this)
        setSliderImage()

        swipeRefresh.post {
            loadData()
        }

        swipeRefresh.setOnRefreshListener {
            loadData()
        }
    }

    private fun loadData() {
        mainPresenter.getSeafood()
        adapterMeals = AdapterMeals(this, listMeals) {
            val intent = Intent(this, DetailMealsActivity::class.java)
            intent.putExtra("idMeal", it.idMeal)
            startActivity(intent)
        }
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = adapterMeals
    }

    override fun showLoading() {
        swipeRefresh.isRefreshing = true
    }

    override fun onResponse(list: ArrayList<Meals>?) {
        listMeals.clear()
        list?.let {
            listMeals.addAll(list)
        }
        adapterMeals.notifyDataSetChanged()
    }

    override fun onError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideLoading() {
        swipeRefresh.isRefreshing = false
    }

    private fun setSliderImage() {
        for (i in 0..3) {
            val sliderView = SliderView(this)
            when (i) {
                0 -> {
                    sliderView.imageUrl = "https://www.themealdb.com/images/media/meals/1548772327.jpg"
                }

                1 -> {
                    sliderView.imageUrl = "https://www.themealdb.com/images/media/meals/uvuyxu1503067369.jpg"
                }

                2 -> {
                    sliderView.imageUrl = "https://www.themealdb.com/images/media/meals/1520084413.jpg"
                }

                3 -> {
                    sliderView.imageUrl = "https://www.themealdb.com/images/media/meals/ysxwuq1487323065.jpg"
                }
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP)

            imageSlider.addSliderView(sliderView)
        }
    }
}
