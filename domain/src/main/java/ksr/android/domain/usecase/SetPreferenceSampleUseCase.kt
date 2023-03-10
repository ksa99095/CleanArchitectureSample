package ksr.android.domain.usecase

import ksr.android.domain.model.Sample
import ksr.android.domain.repository.SampleRepository
import javax.inject.Inject

class SetPreferenceSampleUseCase @Inject constructor (private val repository: SampleRepository) {
    suspend fun invoke(sample: Sample) {
        repository.setPreferenceSample(sample)
    }
}