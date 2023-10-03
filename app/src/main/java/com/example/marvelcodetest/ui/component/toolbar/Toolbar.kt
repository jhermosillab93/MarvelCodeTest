package com.example.marvelcodetest.ui.component.toolbar

import android.content.Context
import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.marvelcodetest.R
import com.example.marvelcodetest.databinding.LayoutToolbarBinding
import com.example.marvelcodetest.domain.util.ImageResource
import com.example.marvelcodetest.domain.util.StringResource
import com.example.marvelcodetest.ui.model.ToolbarConfig
import com.example.marvelcodetest.ui.model.ToolbarLeftItem
import com.example.marvelcodetest.ui.util.makeInvisible
import com.example.marvelcodetest.ui.util.makeVisible

class Toolbar(private val mContext: Context): FrameLayout(mContext) {

    private lateinit var toolbarConfig: ToolbarConfig
    private var binding: LayoutToolbarBinding = LayoutToolbarBinding.inflate(LayoutInflater.from(context), this, true)

    fun setup(toolbarConfig: ToolbarConfig) {
        this.toolbarConfig = toolbarConfig
        setTitle(toolbarConfig.title?.let { mContext.getString(it) })
        setImage(toolbarConfig.imageView)
        when (toolbarConfig.leftSide) {
            is ToolbarLeftItem.Back -> setBackButton(R.string.go_back, toolbarConfig.leftSide.action)
            else -> binding.toolbarLeft.makeInvisible()
        }
    }

    private fun setTitle(title: CharSequence?) {
        title?.let {
            with(binding.toolbarTitleText){
                text = title
                isVisible = true
            }
            binding.toolbarTitleImage.makeInvisible()
        }
    }

    private fun setImage(image: ImageResource?) {
        image?.let {
            binding.toolbarTitleText.makeInvisible()
            binding.toolbarTitleImage.makeVisible()
            binding.toolbarTitleImage.setImageResource(image)
        }
    }

    private fun setBackButton(titleId: StringResource?, action: () -> Unit) {
        titleId?.let { setBackButton(mContext.getString(titleId), action) }
    }

    private fun setBackButton(title: CharSequence?, action: () -> Unit) {
        with(binding){
            toolbarLeft.makeVisible()
            toolbarLeft.setOnClickListener {
                action()
            }
            toolbarLeftText.text = title
            toolbarLeftImage.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.baseline_arrow_back))
        }

    }

}