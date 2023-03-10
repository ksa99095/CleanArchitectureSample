package ksr.android.data.datasource

import ksr.android.data.model.SampleEntity

interface SampleLocalDataSource {

    suspend fun getSample(): SampleEntity
    suspend fun getSample(title: String): SampleEntity
    suspend fun setSample(sampleEntity: SampleEntity)

}