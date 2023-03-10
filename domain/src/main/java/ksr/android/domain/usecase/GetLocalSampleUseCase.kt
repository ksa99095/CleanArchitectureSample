package ksr.android.domain.usecase

import ksr.android.domain.model.Sample
import ksr.android.domain.repository.SampleRepository
import javax.inject.Inject

class GetLocalSampleUseCase @Inject constructor (private val repository: SampleRepository) {
    suspend fun invoke(title: String): Sample {
        return if (title.isEmpty()) {
            repository.getLocalSample()
        } else {
            repository.getLocalSample(title)
        }
    }
}