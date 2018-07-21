package xyz.waiphyoag.mmhealthcare_kotlin.mvp.presenters

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.content.Context
import xyz.waiphyoag.mmhealthcare_kotlin.data.model.HealthCareModel
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO
import xyz.waiphyoag.mmhealthcare_kotlin.delegate.HealthCareInfoDelegate
import xyz.waiphyoag.mmhealthcare_kotlin.mvp.views.HealthCareHomeScreenView

/**
 * Created by admin on 7/21/2018.
 */
class  HealthCareHomeScreenPresenter : BasePresenter<HealthCareHomeScreenView>(),HealthCareInfoDelegate {



    override fun onTapHealthNews(healthCareInfoVO: HealthCareInfoVO) {
        mView.onTapScreenUrl(healthCareInfoVO.completeUrl!!)
    }
    private lateinit var mHealthCareLD : MutableLiveData<List<HealthCareInfoVO>>
    private lateinit var mErrorLD : MutableLiveData<String>

    override fun initPresenter(mView: HealthCareHomeScreenView, context: Context) {
        super.initPresenter(mView, context)
        mHealthCareLD= MutableLiveData()
        mErrorLD= MutableLiveData()
        HealthCareModel.getInstance(context).startLoadingData(mHealthCareLD,mErrorLD)
    }
    fun getHealthCareLD() : LiveData<List<HealthCareInfoVO>>{
        return HealthCareModel.getInstance(context).getAllHeathInfoLD()
    }
}