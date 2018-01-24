package ir.oviessi.singleactivitypattern.features.notification

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_notification_detail.*


class NotificationDetailFragment : BaseFragment() {

    private var notificationId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            notificationId = arguments.getString(ARG_PARAM1)
        }
    }

    lateinit var mListener: OnNotificationDetailFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_notification_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        tvTitle.text="Notification ID = $notificationId"
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnNotificationDetailFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnNotificationDetailInteractionListener")
        }
    }

    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(false,-1)
        mListener.setFabVisibility(false)

    }

    override fun onBackPressed():Boolean
    {
        if(swReadNotification.isChecked)
        {
            swReadNotification.isChecked=false
            return true
        }
        return false
    }


    interface OnNotificationDetailFragmentInteractionListener : FragmentInteractionListener

    companion object {
        private val ARG_PARAM1 = "notification_id"

        fun newInstance(param1: String): NotificationDetailFragment {
            val fragment = NotificationDetailFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            fragment.arguments = args
            return fragment
        }
    }
}
