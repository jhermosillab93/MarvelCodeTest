package com.example.marvelcodetest.ui.component.toolbar

import android.os.Bundle
import android.view.ViewGroup
import com.example.marvelcodetest.R
import com.example.marvelcodetest.ui.base.BaseActivity
import com.example.marvelcodetest.ui.main.CharactersMainActivity
import com.example.marvelcodetest.ui.model.ToolbarConfig
import com.example.marvelcodetest.ui.util.viewModelProvider

abstract class ToolbarActivity: BaseActivity() {

    abstract var toolbarConfig: ToolbarConfig

    private lateinit var viewModel: ToolbarViewModel
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = viewModelProvider(viewModelFactory)

        toolbar = Toolbar(this)
        updateToolbarConfig(toolbarConfig)
    }

    override fun onStart() {
        super.onStart()
        if (toolbar.parent == null) {
                with(findViewById<ViewGroup>(android.R.id.content)) {
                    addView(toolbar, 1)
                    getChildAt(0).setPadding(0,
                        resources.getDimension(R.dimen.toolbar_screen_margin_top).toInt(),
                        0,
                        0)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (this is CharactersMainActivity) {
            toolbar.apply {
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT
                requestLayout()
            }
        }
    }

    fun updateToolbarConfig(newValue: ToolbarConfig) {
        this.toolbarConfig = newValue
        toolbar.setup(toolbarConfig)
    }

}