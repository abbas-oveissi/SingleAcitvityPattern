package ir.oviessi.singleactivitypattern.bases

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import ir.oviessi.singleactivitypattern.NavigationManager

/**
 * Created by abbas on 1/22/18.
 */
open class BaseFragment: Fragment() {

    private lateinit var navigationManagerInner:NavigationManager
    lateinit var fragmentInteractionInner:FragmentInteractionListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        if(parentFragment!=null && parentFragment is HasNavigationManager)
                navigationManagerInner=(parentFragment as HasNavigationManager).provideNavigationManager()
        else if (context is HasNavigationManager)
                navigationManagerInner=(context as HasNavigationManager).provideNavigationManager()
        else
            throw RuntimeException("Activity host must implement HasNavigationManager")


        if(context is Activity)
                fragmentInteractionInner=context as FragmentInteractionListener
        else
            throw RuntimeException("Activity host must implement FragmentInteractionListener")

    }


    fun getNavigationManager():NavigationManager=navigationManagerInner

    open fun onBackPressed(): Boolean= false

    override fun onStart() {
        super.onStart()

        fragmentInteractionInner.setCurrentFragment(this)
    }
}