package id.co.tegarap.makanyuk.ui.main

import id.co.tegarap.makanyuk.model.Meals

interface MainView {
    fun showLoading()
    fun onResponse(list: ArrayList<Meals>?)
    fun onError(message: String?)
    fun hideLoading()
}