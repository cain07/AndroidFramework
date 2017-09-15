package com.cain.af.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.cain.af.MainApp;


/**
 * Created by feng on 2017/8/9.
 */

public class KeyUtils {
    public static void hideKey() {
        InputMethodManager imm = (InputMethodManager) MainApp.getInstance().getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow();
    }
}
