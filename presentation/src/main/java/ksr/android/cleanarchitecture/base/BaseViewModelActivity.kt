package ksr.android.cleanarchitecture.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseViewModelActivity<VB : ViewDataBinding, VM : BaseViewModel>(private val layoutRes: Int) : AppCompatActivity() {

    lateinit var binding : VB
    abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutRes)

        setUI()
        setListener()
        setObserver()
        initData()
    }

    protected abstract fun initData()
    protected abstract fun setUI()
    protected abstract fun setObserver()
    protected abstract fun setListener()
}