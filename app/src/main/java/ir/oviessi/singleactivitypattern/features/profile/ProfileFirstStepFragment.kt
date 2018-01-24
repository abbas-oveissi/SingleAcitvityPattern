package ir.oviessi.singleactivitypattern.features.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_profile_first_step.*

class ProfileFirstStepFragment : BaseFragment() {

    lateinit var mListener: OnProfileFirstStepFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_profile_first_step, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        btnNextStep.setOnClickListener {
            getNavigationManager().open(ProfileSecondStepFragment.newInstance())
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnProfileFirstStepFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnProfileFirstStepFragmentInteractionListener")
        }
    }

    interface OnProfileFirstStepFragmentInteractionListener : FragmentInteractionListener

    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(true, R.id.navigation_profile)
        mListener.setFabVisibility(false)
    }

    companion object {
        fun newInstance(): ProfileFirstStepFragment {
            val fragment = ProfileFirstStepFragment()
            return fragment
        }
    }
}