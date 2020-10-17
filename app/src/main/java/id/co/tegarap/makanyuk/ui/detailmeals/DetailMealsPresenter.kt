package id.co.tegarap.makanyuk.ui.detailmeals

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import id.co.tegarap.makanyuk.api.ResponseDetail

class DetailMealsPresenter(private val detailMealsView: DetailMealsView) {
    fun getDetail(id: String?) {
        detailMealsView.showLoading()
        AndroidNetworking.get("https://www.themealdb.com/api/json/v1/1/lookup.php?i={id}")
                .addPathParameter("id", id)
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObject(ResponseDetail::class.java, object : ParsedRequestListener<ResponseDetail> {
                    override fun onResponse(response: ResponseDetail?) {
                        response?.let {
                            detailMealsView.onResponse(it.mealsSeafood)
                        }
                        detailMealsView.hideLoading()
                    }

                    override fun onError(anError: ANError?) {
                        detailMealsView.onError(anError?.message)
                        detailMealsView.hideLoading()
                    }
                })
    }
}