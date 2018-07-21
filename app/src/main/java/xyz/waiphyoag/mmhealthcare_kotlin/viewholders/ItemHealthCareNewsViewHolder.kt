package xyz.waiphyoag.mmhealthcare_kotlin.viewholders

import android.view.View
import com.bumptech.glide.Glide
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO
import xyz.waiphyoag.mmhealthcare_kotlin.delegate.HealthCareInfoDelegate
import kotlinx.android.synthetic.main.item_health_care_news.*
import kotlinx.android.synthetic.main.item_health_care_news.view.*

/**
 * Created by admin on 7/20/2018.
 */
class ItemHealthCareNewsViewHolder (itemView:View,private val mHealthCareInfoDelegate: HealthCareInfoDelegate) : BaseViewHolder<HealthCareInfoVO>(itemView){
    override fun onClick(p0: View?) {
        mHealthCareInfoDelegate.onTapHealthNews(this.mData!!)
    }

    override fun setData(data: HealthCareInfoVO) {
        mData = data
        itemView.tv_news_date.text=data.publishDate

        Glide.with(itemView.iv_news_image.context)
                .load(data.image)
                .into(itemView.iv_news_image)
    }
}