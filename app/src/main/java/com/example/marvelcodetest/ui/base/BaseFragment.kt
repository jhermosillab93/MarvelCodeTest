package com.example.marvelcodetest.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.marvelcodetest.R
import dagger.android.support.DaggerAppCompatDialogFragment

abstract class BaseFragment: DaggerAppCompatDialogFragment() {

    protected abstract val viewBinding: ViewBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.setBackgroundColor(resources.getColor(R.color.main_background))
        view.layoutParams.apply {
            height = ViewGroup.LayoutParams.MATCH_PARENT
        }
        view.isClickable = true
    }

    open fun showLoading() {
        (activity as? BaseActivity)?.showLoading()
    }

    open fun hideLoading() {
        (activity as? BaseActivity)?.hideLoading()
    }

}