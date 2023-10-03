package com.example.marvelcodetest.ui.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * For Actvities, allows declarations like
 * ```
 * val myViewModel = viewModelProvider(myViewModelFactory)
 * ```
 */
inline fun <reified VM: ViewModel> FragmentActivity.viewModelProvider(
    provider: ViewModelProvider.Factory,
) =
    ViewModelProvider(this, provider)[VM::class.java]

/**
 * For Fragments, allows declarations like
 * ```
 * val myViewModel = viewModelProvider(myViewModelFactory)
 * ```
 */
inline fun <reified VM: ViewModel> Fragment.viewModelProvider(
    provider: ViewModelProvider.Factory,
) =
    ViewModelProvider(this, provider)[VM::class.java]
