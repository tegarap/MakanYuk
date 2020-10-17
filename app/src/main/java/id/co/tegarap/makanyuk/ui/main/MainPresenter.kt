package id.co.tegarap.makanyuk.ui.main

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.co.tegarap.makanyuk.api.ResponseSeafood

class MainPresenter(private val mainView: MainView) {
    fun getSeafood() {
        mainView.showLoading()
            AndroidNetworking.get("https://www.themealdb.com/api/json/v1/1/filter.php?c=Seafood")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(ResponseSeafood::class.java, object : ParsedRequestListener<ResponseSeafood> {
                    override fun onResponse(response: ResponseSeafood?) {
                        println("berhasil")
                        response?.let {
                            mainView.onResponse(it.meals)
                        }
                        mainView.hideLoading()
                    }

                    override fun onError(anError: ANError?) {
                        mainView.onError(anError?.message)
                        println("gagal")
                    }

                })
    }
}