package ir.oviessi.singleactivitypattern.bases

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import ir.oviessi.singleactivitypattern.NavigationManager
import android.R.attr.fragment


/**
 * Created by abbas on 1/22/18.
 */
open class BaseFragment : Fragment() {

    private lateinit var navigationManagerInner: NavigationManager
    lateinit var fragmentInteractionInner: FragmentInteractionListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)



        navigationManagerInner = findNavigationManager()


        if (context is Activity)
            fragmentInteractionInner = context as FragmentInteractionListener
        else
            throw RuntimeException("Activity host must implement FragmentInteractionListener")

    }

    fun findNavigationManager(): NavigationManager {
        var parentFrag: Fragment? = BaseFragment@ this
        while (true) {
            parentFrag = parentFrag?.parentFragment

            if (parentFrag == null)
                break

            if (parentFrag is HasNavigationManager) {
                return parentFrag as NavigationManager
            }
        }

        if (context is HasNavigationManager)
            return (context as HasNavigationManager).provideNavigationManager()

        throw IllegalArgumentException("No NavigationManager was found")
    }

    fun getNavigationManager(): NavigationManager = navigationManagerInner

    open fun onBackPressed(): Boolean = false

    override fun onStart() {
        super.onStart()

        fragmentInteractionInner.setCurrentFragment(this)
    }
}