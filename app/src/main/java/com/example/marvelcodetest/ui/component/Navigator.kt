package com.example.marvelcodetest.ui.component

import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import com.example.marvelcodetest.R
import com.example.marvelcodetest.ui.base.BaseActivity
import com.example.marvelcodetest.ui.base.BaseFragment
import com.example.marvelcodetest.ui.main.CharactersMainActivity

fun BaseActivity.showFragment(frameLayout: FrameLayout, fragment: BaseFragment) {
    supportFragmentManager.removeFragments()
    val fragmentTag = javaClass.canonicalName
    supportFragmentManager.beginTransaction()
        .replace(frameLayout.id, fragment, fragmentTag)
        .commitAllowingStateLoss()
}

private fun FragmentManager.removeFragments() {
    val count = backStackEntryCount
    for (i in 0 until count) {
        popBackStackImmediate(getBackStackEntryAt(i).name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}

fun BaseActivity.addFragment(frameLayout: FrameLayout, fragment: BaseFragment) {
    supportFragmentManager
        .beginTransaction()
        .setCustomAnimations(
            R.anim.slide_in_right,
            R.anim.slide_out_left,
            R.anim.slide_in_left,
            R.anim.slide_out_right)
        .add(frameLayout.id, fragment)
        .addToBackStack(fragment.javaClass.name)
        .commitAllowingStateLoss()
}
fun CharactersMainActivity.addFragment(fragment: BaseFragment) {
    addFragment(viewBinding.containerView, fragment)
}