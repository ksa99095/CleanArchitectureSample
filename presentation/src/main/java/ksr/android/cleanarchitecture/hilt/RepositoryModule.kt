package ksr.android.cleanarchitecture.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ksr.android.data.datasource.SampleLocalDataSource
import ksr.android.data.datasource.SamplePreferenceDataSource
import ksr.android.data.datasource.SampleRemoteDataSource
import ksr.android.data.repository.SampleRepositoryImpl
import ksr.android.domain.repository.SampleRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideSampleRepository(
        sampleRemoteDatasource: SampleRemoteDataSource,
        sampleLocalDatasource: SampleLocalDataSource,
        samplePreferenceDataSource: SamplePreferenceDataSource
    ): SampleRepository {
        return SampleRepositoryImpl(sampleRemoteDatasource, sampleLocalDatasource, samplePreferenceDataSource)
    }
}