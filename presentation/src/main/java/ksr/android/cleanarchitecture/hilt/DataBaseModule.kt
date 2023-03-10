package ksr.android.cleanarchitecture.hilt

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ksr.android.data.database.SampleDao
import ksr.android.data.database.SampleDatabase
import ksr.android.data.utils.SharedPreference
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        @ApplicationContext context: Context
    ): SampleDatabase = Room
        .databaseBuilder(context, SampleDatabase::class.java, "sample.db")
        .build()

    @Provides
    @Singleton
    fun provideSampleDao(sampleDatabase: SampleDatabase): SampleDao = sampleDatabase.sampleDao()

    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreference {
        return SharedPreference(context)
    }

}