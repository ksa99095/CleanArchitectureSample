package ksr.android.data.datasource

import ksr.android.data.database.SampleDao
import ksr.android.data.model.SampleEntity
import javax.inject.Inject

class SampleLocalDataSourceImpl @Inject constructor(
    private val sampleDao: SampleDao
): SampleLocalDataSource {

    override suspend fun getSample(): SampleEntity {
        return sampleDao.getSample()
    }

    override suspend fun getSample(title: String): SampleEntity {
        return sampleDao.getSample(title)
    }

    override suspend fun setSample(sampleEntity: SampleEntity) {
        return sampleDao.insert(sampleEntity)
    }

}