package ksr.android.data.model

import com.google.gson.annotations.SerializedName

/**
 * api return 값의 형태
 */
data class SampleResponse(
    @SerializedName("title") val title: String,
    @SerializedName("content") val content: String
)