package ksr.android.cleanarchitecture.view

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import ksr.android.cleanarchitecture.base.BaseViewModel
import ksr.android.domain.model.Sample
import ksr.android.domain.usecase.*
import javax.inject.Inject

@HiltViewModel
class SampleViewModel @Inject constructor (
    private val getRemoteSampleUseCase: GetRemoteSampleUseCase,
    private val getLocalSampleUseCase: GetLocalSampleUseCase,
    private val setLocalSampleUseCase: SetLocalSampleUseCase,
    private val getPreferenceSampleUseCase: GetPreferenceSampleUseCase,
    private val setPreferenceSampleUseCase: SetPreferenceSampleUseCase
): BaseViewModel() {

    val sample = MutableLiveData<Sample>()
    val setState = MutableLiveData<Boolean>()

    fun getRemoteSample() {
        launchViewModelScope {
            sample.postValue(getRemoteSampleUseCase.invoke())
        }
    }

    fun getLocalSample(title: String) {
        launchViewModelScope {
            sample.postValue(getLocalSampleUseCase.invoke(title))
        }
    }

    fun setLocalSample(sample: Sample) {
        launchViewModelScope {
            setLocalSampleUseCase.invoke(sample)
        }
    }

    fun getPrefSample() {
        launchViewModelScope {
            sample.postValue(getPreferenceSampleUseCase.invoke())
        }
    }

    fun setPrefSample(sample: Sample) {
        launchViewModelScope {
            setPreferenceSampleUseCase.invoke(sample)
        }
    }

}