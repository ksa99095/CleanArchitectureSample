package ksr.android.data.utils

import android.content.Context
import android.content.SharedPreferences
import ksr.android.data.mapper.SampleMapper
import ksr.android.data.model.SampleEntity

class SharedPreference(context: Context) {
    private val preference: SharedPreferences = context.getSharedPreferences(SAMPLE, Context.MODE_PRIVATE)

    fun getSample(): SampleEntity {
        val sampleString = preference.getString(SAMPLE, "")

        return if (sampleString.isNullOrEmpty())
            SampleEntity("", "")
        else
            SampleMapper.mapperStringToSample(sampleString)
    }

    fun setSample(sample: SampleEntity) {
        val editor = preference.edit()
        editor.putString(SAMPLE, SampleMapper.mapperSampleToString(sample))
        editor.apply()
    }

    companion object {
        const val SAMPLE = "SAMPLE"
    }
}