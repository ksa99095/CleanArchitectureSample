package ksr.android.cleanarchitecture.view

import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ksr.android.cleanarchitecture.R
import ksr.android.cleanarchitecture.base.BaseViewModelActivity
import ksr.android.cleanarchitecture.databinding.ActivitySampleBinding
import ksr.android.cleanarchitecture.util.FetchState
import ksr.android.domain.model.Sample

@AndroidEntryPoint
class SampleActivity: BaseViewModelActivity<ActivitySampleBinding, SampleViewModel>(R.layout.activity_sample) {
    override val viewModel: SampleViewModel by viewModels()

    override fun initData() {}
    override fun setUI() {}
    override fun setObserver() {
        viewModel.fetchState.observe(this) {
            val errorMessage = when(it) {
                FetchState.FAIL -> "Error!"
                else -> "Network Error!"
            }

            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
        viewModel.sample.observe(this) {
            if (it.title.isEmpty() || it.content.isEmpty()) {
                Toast.makeText(this, "title / content is null", Toast.LENGTH_SHORT).show()
            } else {
                binding.title.setText(it.title)
                binding.content.setText(it.content)
            }
        }
    }

    override fun setListener() {
        binding.btnGetRemote.setOnClickListener {
            viewModel.getRemoteSample()
        }

        binding.btnGetLocal.setOnClickListener {
            viewModel.getLocalSample(binding.title.text.toString())
        }

        binding.btnSetLocal.setOnClickListener {
            if (binding.title.text.isNullOrEmpty()) {
                Toast.makeText(this, "title is null", Toast.LENGTH_SHORT).show()
            } else if (binding.content.text.isNullOrEmpty()) {
                Toast.makeText(this, "content is null", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setLocalSample(
                    Sample(
                        title = binding.title.text.toString(),
                        content = binding.content.text.toString()
                    )
                )
            }
        }

        binding.btnGetPref.setOnClickListener {
            viewModel.getPrefSample()
        }

        binding.btnSetPref.setOnClickListener {

            if (binding.title.text.isNullOrEmpty()) {
                Toast.makeText(this, "title is null", Toast.LENGTH_SHORT).show()
            } else if (binding.content.text.isNullOrEmpty()) {
                Toast.makeText(this, "content is null", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setPrefSample(
                    Sample(
                        title = binding.title.text.toString(),
                        content = binding.content.text.toString()
                    )
                )
            }
        }
    }
}