package com.cain.af.utils;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.IdRes;

import java.util.List;

/**
 * FragmentUtil
 */
public class FragmentUtil {

    /**
     * @param fragmentManager   fragmentManager
     * @param fragmentTypeClass fragmentTypeClass
     * @return 是否找到fragment
     */
    public static boolean hasFragment(FragmentManager fragmentManager, Class<?> fragmentTypeClass) {
        return fragmentManager.findFragmentByTag(fragmentTypeClass.getName()) != null;
    }

    /**
     * @param fragmentManager fragmentManager
     * @param containerViewId id
     * @param fragment        fragment
     */
    public static void add(FragmentManager fragmentManager, @IdRes int containerViewId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(containerViewId, fragment, fragment.getClass().getName())
                .commit();
    }

    /**
     * @param fragmentManager fm
     * @param containerViewId id
     * @param fragment        fragment
     */
    public static void replacePlug(FragmentManager fragmentManager, @IdRes int containerViewId, Fragment fragment) {
        fragmentManager.beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(containerViewId, fragment, fragment.getClass().getName())
                .commit();
    }

    /**
     * @param fragmentManager fm
     * @param containerViewId id
     * @param oldFragment     oldfragment
     * @param fragment        fragment
     */
    public static void switchPage(FragmentManager fragmentManager, @IdRes int containerViewId, Fragment oldFragment, Fragment fragment) {
        if (fragment.isAdded()) {
            fragmentManager.beginTransaction()
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .hide(oldFragment)
                    .show(fragment)
                    .commit();
        } else {
            fragmentManager.beginTransaction()
//                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .hide(oldFragment)
                    .add(containerViewId, fragment, fragment.getClass().getName())
                    .commit();
        }
    }

    /**
     * @param fragmentManager fm
     * @param containerViewId id
     * @param fragment        fragment
     */
    public static void showFragment(FragmentManager fragmentManager, @IdRes int containerViewId, Fragment fragment) {
        fragmentManager.beginTransaction()
                //.setCustomAnimations(R.animator.fragment_in, R.animator.fragment_out, R.animator.fragment_pop_in, R.animator.fragment_pop_out)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack(null)
                .replace(containerViewId, fragment, fragment.getClass().getName())
                .commit();
    }

    /**
     * @param fragmentManager fm
     * @param containerViewId id
     * @param fragment        fragment
     * @param name            name
     */
    public static void showFragmentWithName(FragmentManager fragmentManager, @IdRes int containerViewId, Fragment fragment, String name) {
        fragmentManager.beginTransaction()
                .addToBackStack(name)
                .replace(containerViewId, fragment, fragment.getClass().getName())
                .commit();
    }

    /**
     * @param fragmentManager fm
     * @param name            name
     */
    public static void popFragmentWithName(FragmentManager fragmentManager, String name) {
        fragmentManager.popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    /**
     * @param fragmentManager fm
     * @param containerViewId id
     * @param fragment        fragment
     * @param s               s
     */
    public static void showFragment(FragmentManager fragmentManager, @IdRes int containerViewId, Fragment fragment, String s) {
        fragmentManager.beginTransaction().addToBackStack(null).replace(containerViewId, fragment, s).commit();
    }

    /**
     * @param fragmentManager fm
     * @param tag             tag
     * @return getFragment
     */
    public static Fragment getFragment(FragmentManager fragmentManager, String tag) {
        return fragmentManager.findFragmentByTag(tag);
    }

}
