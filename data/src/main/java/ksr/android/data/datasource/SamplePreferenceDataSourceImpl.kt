package ksr.android.data.datasource

import ksr.android.data.model.SampleEntity
import ksr.android.data.utils.SharedPreference
import javax.inject.Inject

class SamplePreferenceDataSourceImpl @Inject constructor(
    private val sharedPreference: SharedPreference
): SamplePreferenceDataSource {

    override suspend fun getSample(): SampleEntity {
        return sharedPreference.getSample()
    }

    override suspend fun setSample(sampleEntity: SampleEntity) {
        sharedPreference.setSample(sampleEntity)
    }
}