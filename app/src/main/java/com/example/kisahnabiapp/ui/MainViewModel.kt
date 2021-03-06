package com.example.kisahnabiapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisahnabiapp.data.KisahResponse
import com.example.kisahnabiapp.data.network.ApiClient
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {
    val kisahResponse = MutableLiveData<List<KisahResponse>>()
    val isLoading = MutableLiveData<Boolean>()
    val isError = MutableLiveData<Throwable>()

    fun getKisahNabi(responHandle: (List<KisahResponse>) -> Unit, errorHandler: (Throwable) -> Unit){
        ApiClient.getApiService().getKisahNabi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                responHandle(it)
            }, {
                errorHandler(it)
            })
    }

    fun getData() {
        isLoading.value = true

        getKisahNabi({
            kisahResponse.value = it
            isLoading.value = false
        }, {
            isLoading.value = false
            isError.value = it

        })
    }

}