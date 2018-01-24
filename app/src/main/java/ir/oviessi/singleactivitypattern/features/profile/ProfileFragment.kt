package ir.oviessi.singleactivitypattern.features.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.oviessi.singleactivitypattern.NavigationManager
import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener
import ir.oviessi.singleactivitypattern.bases.HasNavigationManager

class ProfileFragment : BaseFragment(),HasNavigationManager {

    lateinit var mListener: OnProfileFragmentInteractionListener

    lateinit var mNavigationManager:NavigationManager



    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var v= inflater!!.inflate(R.layout.fragment_profile, container, false)

        mNavigationManager.openAsRoot(ProfileFirstStepFragment.newInstance())

        return v
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnProfileFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnProfileFragmentInteractionListener")
        }

        mNavigationManager= NavigationManager(childFragmentManager,R.id.container)
    }

    interface OnProfileFragmentInteractionListener : FragmentInteractionListener

    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(true, R.id.navigation_profile)
        mListener.setFabVisibility(false)
    }

    override fun provideNavigationManager(): NavigationManager =mNavigationManager


    companion object {
        fun newInstance(): ProfileFragment {
            val fragment = ProfileFragment()
            return fragment
        }
    }
}