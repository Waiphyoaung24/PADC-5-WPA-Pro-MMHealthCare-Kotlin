package xyz.waiphyoag.mmhealthcare_kotlin.data.vo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by admin on 7/20/2018.
 */
class AuthorVO {
    @SerializedName("author-id")
    @Expose
    var authorId: Int? = null

    @SerializedName("author-name")
    @Expose
    var authorName: String? = null

    @Expose
    @SerializedName("author-picture")
    var authorPicture: String? = null
}