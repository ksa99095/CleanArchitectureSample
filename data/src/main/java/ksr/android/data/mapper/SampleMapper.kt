package ksr.android.data.mapper

import com.google.gson.Gson
import ksr.android.data.model.SampleEntity
import ksr.android.data.model.SampleResponse
import ksr.android.domain.model.Sample

/**
 * Data Entity to Data Model
 * Data Layer 에서는 Data Entity 로 받아서 사용하지만, Domain, Presentation Layer 에서는 Data Model 로 사용한다.
 */
object SampleMapper {

    fun mapperToSample(sampleResponse: SampleResponse): Sample {
        return Sample(
            title = sampleResponse.title,
            content = sampleResponse.content
        )
    }

    fun mapperToSample(sampleEntity: SampleEntity): Sample {
        return Sample(
            title = sampleEntity.title,
            content = sampleEntity.content
        )
    }

    fun mapperToSampleEntity(sample: Sample): SampleEntity {
        return SampleEntity(
            title = sample.title,
            content = sample.content
        )
    }

    fun mapperStringToSample(string: String): SampleEntity {
        return Gson().fromJson(string, SampleEntity::class.java)
    }

    fun mapperSampleToString(sample: SampleEntity): String {
        return Gson().toJson(sample)
    }
}