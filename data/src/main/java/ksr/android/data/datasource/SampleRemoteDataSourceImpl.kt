package ksr.android.data.datasource

import ksr.android.data.api.SampleApi
import ksr.android.data.model.SampleResponse
import javax.inject.Inject

class SampleRemoteDataSourceImpl @Inject constructor(
    private val sampleApi: SampleApi
): SampleRemoteDataSource {

    override suspend fun getSample(): SampleResponse {
        return sampleApi.getSample()
    }

}