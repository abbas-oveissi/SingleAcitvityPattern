package ir.oviessi.singleactivitypattern.features.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener

class ProfileSecondStepFragment : BaseFragment() {

    lateinit var mListener: OnProfileSecondStepFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_profile_second_step, container, false)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnProfileSecondStepFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnProfileSecondStepFragmentInteractionListener")
        }
    }

    override fun onBackPressed(): Boolean {
        return getNavigationManager().navigateBack()
    }

    interface OnProfileSecondStepFragmentInteractionListener : FragmentInteractionListener

    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(true, R.id.navigation_profile)
        mListener.setFabVisibility(false)
    }

    companion object {
        fun newInstance(): ProfileSecondStepFragment {
            val fragment = ProfileSecondStepFragment()
            return fragment
        }
    }
}