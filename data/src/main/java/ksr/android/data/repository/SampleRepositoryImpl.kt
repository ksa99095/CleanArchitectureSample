package ksr.android.data.repository

import ksr.android.data.datasource.SampleLocalDataSource
import ksr.android.data.datasource.SamplePreferenceDataSource
import ksr.android.data.datasource.SampleRemoteDataSource
import ksr.android.data.mapper.SampleMapper
import ksr.android.domain.model.Sample
import ksr.android.domain.repository.SampleRepository
import javax.inject.Inject

/**
 * Domain Layer 의 Repository Interface 구현부.
 * DataSource 를 인자로 받아 컨트롤 하여 필요한 Movie Data 를 가져옴.
 *
 * @param sampleRemoteDataSource api 에서 가져오는 Data
 * @param sampleLocalDataSource Local 에 저장 되어있는 Data
 */
class SampleRepositoryImpl @Inject constructor(
    private val sampleRemoteDataSource: SampleRemoteDataSource,
    private val sampleLocalDataSource: SampleLocalDataSource,
    private val samplePreferenceDataSource: SamplePreferenceDataSource
): SampleRepository {

    override suspend fun getRemoteSample(): Sample {
        return SampleMapper.mapperToSample(sampleRemoteDataSource.getSample())
    }



    override suspend fun getLocalSample(): Sample {
        return SampleMapper.mapperToSample(sampleLocalDataSource.getSample())
    }

    override suspend fun getLocalSample(title: String): Sample {
        return SampleMapper.mapperToSample(sampleLocalDataSource.getSample(title))
    }

    override suspend fun setLocalSample(sample: Sample) {
        sampleLocalDataSource.setSample(
            SampleMapper.mapperToSampleEntity(sample)
        )
    }



    override suspend fun getPreferenceSample(): Sample {
        return SampleMapper.mapperToSample(samplePreferenceDataSource.getSample())
    }

    override suspend fun setPreferenceSample(sample: Sample) {
        samplePreferenceDataSource.setSample(
            SampleMapper.mapperToSampleEntity(sample)
        )
    }

}