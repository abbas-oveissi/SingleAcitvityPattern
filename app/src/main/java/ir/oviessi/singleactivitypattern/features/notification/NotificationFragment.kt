package ir.oviessi.singleactivitypattern.features.notification

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_notification.*

class NotificationFragment : BaseFragment() {

    lateinit var mListener: OnNotificationFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_notification, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        btnShowDetail.setOnClickListener {
            getNavigationManager().open(NotificationDetailFragment.newInstance("212"))
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnNotificationFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnNotificationFragmentInteractionListener")
        }
    }


    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(true,R.id.navigation_notifications)
        mListener.setFabVisibility(false)

    }


    interface OnNotificationFragmentInteractionListener : FragmentInteractionListener

    companion object {
        fun newInstance(): NotificationFragment {
            val fragment = NotificationFragment()
            return fragment
        }
    }
}
