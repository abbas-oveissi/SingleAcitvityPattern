package ir.oviessi.singleactivitypattern.bases

import ir.oviessi.singleactivitypattern.NavigationManager

/**
 * Created by abbas on 1/22/18.
 */
interface HasNavigationManager {
    fun provideNavigationManager():NavigationManager
}