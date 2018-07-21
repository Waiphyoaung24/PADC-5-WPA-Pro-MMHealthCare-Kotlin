package xyz.waiphyoag.mmhealthcare_kotlin.adapters

import android.content.Context
import android.view.ViewGroup
import xyz.waiphyoag.mmhealthcare_kotlin.R
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO
import xyz.waiphyoag.mmhealthcare_kotlin.delegate.HealthCareInfoDelegate
import xyz.waiphyoag.mmhealthcare_kotlin.viewholders.BaseViewHolder
import xyz.waiphyoag.mmhealthcare_kotlin.viewholders.ItemHealthCareNewsViewHolder

/**
 * Created by admin on 7/20/2018.
 */

class HealthCareNewsAdapter(context: Context,
                            private val mHealthCareInfoDelegate: HealthCareInfoDelegate) : BaseRecyclerAdapter<ItemHealthCareNewsViewHolder, HealthCareInfoVO>(context) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<HealthCareInfoVO> {
        val newsItemView = mLayoutInflator.inflate(R.layout.item_health_care_news, parent, false)
        return ItemHealthCareNewsViewHolder(newsItemView, mHealthCareInfoDelegate)
    }



}