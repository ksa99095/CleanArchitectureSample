package ksr.android.data.api

import ksr.android.data.model.SampleResponse
import retrofit2.http.GET

interface SampleApi {

    @GET("/getSample")
    suspend fun getSample(): SampleResponse

}