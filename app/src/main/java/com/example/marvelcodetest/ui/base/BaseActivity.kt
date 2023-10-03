package com.example.marvelcodetest.ui.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.marvelcodetest.ui.component.Loading
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity: DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected abstract val viewBinding: ViewBinding

    //private var modal: BaseMessage? = null
    private lateinit var loading: Loading
    var removeLoseFocusEvent = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loading = Loading(this)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        setContentView(viewBinding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        onCreate(savedInstanceState)
    }


    override fun onPause() {
        super.onPause()
        loading.hide()
    }

    override fun onDestroy() {
        hideLoading()
        super.onDestroy()
    }

    fun showLoading() {
        if (!isFinishing)
            loading.show()
    }

    fun hideLoading() {
        if (!isFinishing)
            loading.hide()
    }

    /*fun showModal(baseMessage: BaseMessage) {
        hideModal()
        modal = baseMessage
        modal?.show()
    }

    fun hideModal() {
        modal?.hide()
    }*/

}