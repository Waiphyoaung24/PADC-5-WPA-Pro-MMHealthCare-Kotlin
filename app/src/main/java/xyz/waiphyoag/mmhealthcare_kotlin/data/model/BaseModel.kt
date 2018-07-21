package xyz.waiphyoag.mmhealthcare_kotlin.data.model

import android.arch.lifecycle.ViewModel
import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.waiphyoag.mmhealthcare_kotlin.network.HealthCareApi
import xyz.waiphyoag.mmhealthcare_kotlin.persistence.AppDatabase
import java.util.concurrent.TimeUnit

/**
 * Created by admin on 7/21/2018.
 */
abstract class BaseModel constructor(context: Context) {
    protected var theApi: HealthCareApi
    protected var mAppDatabase : AppDatabase

    init {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-5/mm-healthcare/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        theApi = retrofit.create(HealthCareApi::class.java)
        mAppDatabase= AppDatabase.getInstance(context)
    }


}