package com.example.marvelcodetest.ui.component

import com.example.marvelcodetest.ui.base.BaseActivity
import com.example.marvelcodetest.ui.base.BaseFragment
import com.example.marvelcodetest.ui.component.toolbar.ToolbarActivity
import com.example.marvelcodetest.ui.model.ToolbarConfig

abstract class ToolBarFragment: BaseFragment() {

    abstract var toolbarConfig: ToolbarConfig

    override fun onResume() {
        super.onResume()
        updateToolbarConfig(toolbarConfig)
    }

    fun updateToolbarConfig(newValue: ToolbarConfig = toolbarConfig) {
        this.toolbarConfig = newValue
        (activity as? ToolbarActivity)?.apply {
            updateToolbarConfig(newValue)
        }
    }

    private fun getBaseActivity(): BaseActivity =
        activity as BaseActivity

    fun clickOnBack() {
        getBaseActivity().onBackPressed()
    }

}