package ir.oviessi.singleactivitypattern.features.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener

class RequestArchiveFragment : BaseFragment() {

    lateinit var mListener: OnRequestArchiveFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_request_archive, container, false)
    }



    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnRequestArchiveFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnRequestArchiveFragmentInteractionListener")
        }
    }

    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(true, R.id.navigation_dashboard)
        mListener.setFabVisibility(false)

    }


    interface OnRequestArchiveFragmentInteractionListener : FragmentInteractionListener

    companion object {
        fun newInstance(): RequestArchiveFragment {
            val fragment = RequestArchiveFragment()
            return fragment
        }
    }
}