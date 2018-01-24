package ir.oviessi.singleactivitypattern.features.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener

class HomeFragment : BaseFragment() {

    lateinit var mListener: OnHomeFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_home, container, false)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnHomeFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnHomeFragmentInteractionListener")
        }
    }

    interface OnHomeFragmentInteractionListener : FragmentInteractionListener

    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(true,R.id.navigation_home)
        mListener.setFabVisibility(true)
    }

    companion object {
        fun newInstance(): HomeFragment {
            val fragment = HomeFragment()
            return fragment
        }
    }
}
