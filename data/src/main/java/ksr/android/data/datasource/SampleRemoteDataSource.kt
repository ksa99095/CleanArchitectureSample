package ksr.android.data.datasource

import ksr.android.data.model.SampleResponse

interface SampleRemoteDataSource {

    suspend fun getSample(): SampleResponse

}