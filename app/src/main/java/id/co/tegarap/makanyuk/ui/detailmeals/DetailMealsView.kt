package id.co.tegarap.makanyuk.ui.detailmeals

import id.co.tegarap.makanyuk.model.Seafood

interface DetailMealsView {
    fun showLoading()
    fun onResponse(list: ArrayList<Seafood>?)
    fun onError(message: String?)
    fun hideLoading()
}