package xyz.waiphyoag.mmhealthcare_kotlin.activities

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.customtabs.CustomTabsIntent
import android.support.v7.widget.LinearLayoutManager
import xyz.waiphyoag.mmhealthcare_kotlin.R
import kotlinx.android.synthetic.main.activity_main.*
import xyz.waiphyoag.mmhealthcare_kotlin.adapters.HealthCareNewsAdapter
import xyz.waiphyoag.mmhealthcare_kotlin.data.model.HealthCareModel
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO
import xyz.waiphyoag.mmhealthcare_kotlin.delegate.HealthCareInfoDelegate
import xyz.waiphyoag.mmhealthcare_kotlin.mvp.presenters.HealthCareHomeScreenPresenter
import xyz.waiphyoag.mmhealthcare_kotlin.mvp.views.HealthCareHomeScreenView


class MainActivity : BaseActivity(), HealthCareHomeScreenView {
    override fun onTapScreenUrl(url: String) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }

    private lateinit var mHealthInfoAdapter: HealthCareNewsAdapter
    private var mPresenter: HealthCareHomeScreenPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mPresenter = ViewModelProviders.of(this).get(HealthCareHomeScreenPresenter::class.java)
        mPresenter!!.initPresenter(this, this)

        mHealthInfoAdapter = HealthCareNewsAdapter(applicationContext, mPresenter!!)
        rvHealthCare.layoutManager = LinearLayoutManager(applicationContext)
        rvHealthCare.adapter = mHealthInfoAdapter



        mPresenter!!.getHealthCareLD().observe(this, Observer<List<HealthCareInfoVO>>
        { response ->  displayheathCareInfo(response!!) })

    }

    private fun displayheathCareInfo(healthCareInfo: List<HealthCareInfoVO>) {
        mHealthInfoAdapter.appendNewData(healthCareInfo)
    }
}
