package ir.oviessi.singleactivitypattern.features.dashboard

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.oviessi.singleactivitypattern.R
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.FragmentInteractionListener
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import ir.oviessi.singleactivitypattern.NavigationManager
import ir.oviessi.singleactivitypattern.bases.HasNavigationManager
import kotlinx.android.synthetic.main.fragment_dashboard.*


class DashboardFragment : BaseFragment(){

    lateinit var mListener: OnDashboardFragmentInteractionListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_dashboard, container, false)
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(RequestArchiveFragment.newInstance(), "Archive")
        adapter.addFragment(RequestListFragment.newInstance(), "New")
        pager.adapter = adapter
        tabs.setupWithViewPager(pager)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnDashboardFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnDashboardFragmentInteractionListener")
        }
    }


    override fun onStart() {
        super.onStart()

        mListener.setBottomNavigation(true,R.id.navigation_dashboard)
        mListener.setFabVisibility(false)

    }


    interface OnDashboardFragmentInteractionListener : FragmentInteractionListener

    companion object {
        fun newInstance(): DashboardFragment {
            val fragment = DashboardFragment()
            return fragment
        }
    }
}
