package ir.oviessi.singleactivitypattern.bases

import android.support.v4.app.Fragment


/**
 * Created by abbas on 1/22/18.
 */
interface FragmentInteractionListener {

    fun setToolbarTitle(title:String)

    fun setToolbarVisibility(show:Boolean)

    fun setFabVisibility(show:Boolean)

    fun setCurrentFragment(fragment: BaseFragment)

    fun setBottomNavigation(show: Boolean,menuId:Int)
}