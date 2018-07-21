package xyz.waiphyoag.mmhealthcare_kotlin.network

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Created by admin on 7/20/2018.
 */
interface HealthCareApi {
    @FormUrlEncoded
    @POST("GetHealthcareInfo.php")
    fun loadHealthInfo(
            @Field("access_token") accessToken: String): Observable<GetHealthCareInfoResponse>

}