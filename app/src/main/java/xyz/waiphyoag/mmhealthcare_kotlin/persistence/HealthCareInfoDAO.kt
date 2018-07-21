package xyz.waiphyoag.mmhealthcare_kotlin.persistence

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO

/**
 * Created by admin on 7/21/2018.
 */
@Dao
interface HealthCareInfoDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(healthcareList: List<HealthCareInfoVO>)

    @Query("select * from health_care_info")
    fun getAllData(): LiveData<List<HealthCareInfoVO>>




}