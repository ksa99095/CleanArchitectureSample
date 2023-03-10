package ksr.android.domain.repository

import ksr.android.domain.model.Sample

interface SampleRepository {

    suspend fun getRemoteSample(): Sample

    suspend fun getLocalSample(): Sample
    suspend fun getLocalSample(title: String): Sample
    suspend fun setLocalSample(sample: Sample)

    suspend fun getPreferenceSample(): Sample
    suspend fun setPreferenceSample(sample: Sample)

}