package xyz.waiphyoag.mmhealthcare_kotlin.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import xyz.waiphyoag.mmhealthcare_kotlin.data.vo.HealthCareInfoVO

/**
 * Created by admin on 7/21/2018.
 */
@Database(entities = arrayOf(HealthCareInfoVO::class),version = 1,exportSchema = false)
        abstract class AppDatabase : RoomDatabase() {
    abstract fun healthCareInfoDAO () : HealthCareInfoDAO

    companion object {
        private val DB_Name ="MMHealth_Care.DB"
        var INSTANCE : AppDatabase?=null
        fun getInstance(context: Context):AppDatabase{
            if(INSTANCE==null)
            {
                INSTANCE=Room.databaseBuilder(context,AppDatabase::class.java, DB_Name)
                        .allowMainThreadQueries()
                        .build()
            }
            val i = INSTANCE
            return i!!
        }
    }
}