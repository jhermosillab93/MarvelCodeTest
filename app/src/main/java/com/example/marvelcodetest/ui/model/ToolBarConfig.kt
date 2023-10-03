package com.example.marvelcodetest.ui.model

import com.example.marvelcodetest.domain.util.ImageResource
import com.example.marvelcodetest.domain.util.StringResource


data class ToolbarConfig(var title: StringResource? = null, var imageView: ImageResource? = null, val leftSide: ToolbarLeftItem? = null)

sealed class ToolbarLeftItem {
    //We could add options to our toolbar adding more classes here
    class Back(val action: () -> Unit) : ToolbarLeftItem()
}