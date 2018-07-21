package xyz.waiphyoag.mmhealthcare_kotlin.data.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.util.Log
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import xyz.waiphyoag.mmhealthcare_kotlin.MMHealthCareApp
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO
import xyz.waiphyoag.mmhealthcare_kotlin.network.GetHealthCareInfoResponse
import xyz.waiphyoag.mmhealthcare_kotlin.utils.AppConstants

/**
 * Created by admin on 7/21/2018.
 */
class HealthCareModel(context: Context) : BaseModel(context) {
    companion object {
        private var INSTANT: HealthCareModel? = null
        fun getInstance(context: Context): HealthCareModel {
            if (INSTANT == null) {
                INSTANT = HealthCareModel(context)
            }
            val i = INSTANT
            return i!!
        }
    }
    fun initNewsAppModel(context : Context) {
        INSTANT = HealthCareModel(context)
    }




    fun startLoadingData(loadhealthnewsLD: MutableLiveData<List<HealthCareInfoVO>>, mErrorLD: MutableLiveData<String>) {
        theApi.loadHealthInfo(AppConstants.ACCESS_TOKEN)
                .subscribeOn(io.reactivex.schedulers.Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<GetHealthCareInfoResponse> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onError(e: Throwable) {
                        mErrorLD.value = e.message
                    }

                    override fun onNext(getHealthCareInfoResponse: GetHealthCareInfoResponse) {
                        if (getHealthCareInfoResponse.healthCareInfo != null) {
                            persistData(getHealthCareInfoResponse.healthCareInfo!!)
                            loadhealthnewsLD.value = getHealthCareInfoResponse.healthCareInfo
                        }

                    }

                    override fun onComplete() {
                    }

                })
    }

    private fun persistData(list: List<HealthCareInfoVO>) {
        mAppDatabase.clearAllTables()
        mAppDatabase.healthCareInfoDAO().insertAll(list)
        Log.d("GG","data size = "+list.size)
    }

    fun getAllHeathInfoLD(): LiveData<List<HealthCareInfoVO>> {
        return mAppDatabase.healthCareInfoDAO().getAllData()
    }
}