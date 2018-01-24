package ir.oviessi.singleactivitypattern

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import ir.oviessi.singleactivitypattern.bases.BaseFragment
import ir.oviessi.singleactivitypattern.bases.HasNavigationManager
import ir.oviessi.singleactivitypattern.features.dashboard.DashboardFragment
import ir.oviessi.singleactivitypattern.features.dashboard.RequestArchiveFragment
import ir.oviessi.singleactivitypattern.features.dashboard.RequestListFragment
import ir.oviessi.singleactivitypattern.features.home.HomeFragment
import ir.oviessi.singleactivitypattern.features.notification.NotificationDetailFragment
import ir.oviessi.singleactivitypattern.features.notification.NotificationFragment
import ir.oviessi.singleactivitypattern.features.profile.ProfileFirstStepFragment
import ir.oviessi.singleactivitypattern.features.profile.ProfileFragment
import ir.oviessi.singleactivitypattern.features.profile.ProfileSecondStepFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() ,HasNavigationManager
        , HomeFragment.OnHomeFragmentInteractionListener
        , NotificationFragment.OnNotificationFragmentInteractionListener
        , NotificationDetailFragment.OnNotificationDetailFragmentInteractionListener
        , DashboardFragment.OnDashboardFragmentInteractionListener
        , RequestListFragment.OnRequestListFragmentInteractionListener
        , RequestArchiveFragment.OnRequestArchiveFragmentInteractionListener
        , ProfileFragment.OnProfileFragmentInteractionListener
        , ProfileFirstStepFragment.OnProfileFirstStepFragmentInteractionListener
        , ProfileSecondStepFragment.OnProfileSecondStepFragmentInteractionListener {


    lateinit var mNavigationManager:NavigationManager
    var mCurrentFragment:BaseFragment?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        mNavigationManager= NavigationManager(supportFragmentManager,R.id.container)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if(savedInstanceState==null)
        {
            mNavigationManager.openAsRoot(HomeFragment.newInstance())
            navigation.menu.getItem(0).isChecked
        }

    }

    override fun provideNavigationManager(): NavigationManager =mNavigationManager

    override fun setToolbarTitle(title: String) {
        toolbar.title=title
    }

    override fun setCurrentFragment(fragment: BaseFragment) {
        mCurrentFragment=fragment
    }

    override fun setToolbarVisibility(show: Boolean) {
        toolbar.visibility= if (show) View.VISIBLE else View.GONE
    }

    override fun setFabVisibility(show: Boolean) {
        fab.visibility= if (show) View.VISIBLE else View.GONE
    }

    override fun setBottomNavigation(show: Boolean, menuId: Int) {
        if (show)
        {
            navigation.visibility=View.VISIBLE

            when (menuId)
            {
                R.id.navigation_home-> navigation.menu.getItem(0).isChecked = true
                R.id.navigation_dashboard-> navigation.menu.getItem(1).isChecked = true
                R.id.navigation_notifications-> navigation.menu.getItem(2).isChecked = true
                R.id.navigation_profile-> navigation.menu.getItem(3).isChecked = true
            }

        }
        else
            navigation.visibility=View.GONE
    }

    override fun onBackPressed() {
        if(mCurrentFragment == null || !mCurrentFragment!!.onBackPressed())
            super.onBackPressed()
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mNavigationManager.open(HomeFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mNavigationManager.open(DashboardFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mNavigationManager.open(NotificationFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                mNavigationManager.open(ProfileFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }


}
