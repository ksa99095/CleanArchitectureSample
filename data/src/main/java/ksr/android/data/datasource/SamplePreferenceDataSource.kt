package ksr.android.data.datasource

import ksr.android.data.model.SampleEntity

interface SamplePreferenceDataSource {

    suspend fun getSample(): SampleEntity
    suspend fun setSample(sampleEntity: SampleEntity)

}