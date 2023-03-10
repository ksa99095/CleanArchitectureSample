package ksr.android.cleanarchitecture.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ksr.android.data.api.SampleApi
import ksr.android.data.database.SampleDao
import ksr.android.data.datasource.*
import ksr.android.data.utils.SharedPreference
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    /**
     * API
     */
    @Provides
    @Singleton
    fun provideSampleRemoteDataSource(sampleApi: SampleApi): SampleRemoteDataSource {
        return SampleRemoteDataSourceImpl(sampleApi)
    }

    /**
     * DB
     */
    @Provides
    @Singleton
    fun provideSampleLocalDataSource(sampleDao: SampleDao): SampleLocalDataSource {
        return SampleLocalDataSourceImpl(sampleDao)
    }

    /**
     * SharedPreference
     */
    @Singleton
    @Provides
    fun provideSharedPreferences(sharedPreference: SharedPreference): SamplePreferenceDataSource {
        return SamplePreferenceDataSourceImpl(sharedPreference)
    }
}