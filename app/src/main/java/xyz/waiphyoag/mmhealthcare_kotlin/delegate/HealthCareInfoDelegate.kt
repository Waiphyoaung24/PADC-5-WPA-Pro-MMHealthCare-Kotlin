package xyz.waiphyoag.mmhealthcare_kotlin.delegate

import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO

/**
 * Created by admin on 7/20/2018.
 */
interface HealthCareInfoDelegate {
    fun onTapHealthNews (healthCareInfoVO: HealthCareInfoVO)
}