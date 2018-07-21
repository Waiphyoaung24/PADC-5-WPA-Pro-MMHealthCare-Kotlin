package xyz.waiphyoag.mmhealthcare_kotlin.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO

/**
 * Created by admin on 7/20/2018.
 */
class GetHealthCareInfoResponse {
    @SerializedName("code")
    @Expose
    var code: Int? = null

    @SerializedName("message")
    @Expose
    var message: String? = null

    @SerializedName("healthcare-info")
    @Expose
    var healthCareInfo: List<HealthCareInfoVO>? = null



}