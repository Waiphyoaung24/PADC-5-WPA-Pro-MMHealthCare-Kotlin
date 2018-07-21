package xyz.waiphyoag.mmhealthcare_kotlin.data.vo

import android.arch.persistence.room.Embedded
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

/**
 * Created by admin on 7/20/2018.
 */

@Entity(tableName = "health_care_info")
class HealthCareInfoVO {

    @Expose
    @NonNull
    @PrimaryKey
    @SerializedName("id")
    var id: Int? = null

    @Expose
    @SerializedName("title")
    var title: String? = null

    @SerializedName("image")
    @Expose
    var image: String? = null

    @Expose
    @SerializedName("author")
    @Embedded
    var author: AuthorVO? = null//

    @Expose
    @SerializedName("short-description")
    var shortDesc: String? = null

    @Expose
    @SerializedName("published-date")
    var publishDate: String? = null

    @Expose
    @SerializedName("complete-url")
    var completeUrl: String? = null

}