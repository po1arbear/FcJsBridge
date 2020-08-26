package com.fcbox.lib.fcjsbridge;

import android.util.Log;

/**
 * 业务Plugin
 */
public class JSUiTitlePlugin extends BaseJSPlugin {

    final static String UI_NAV_SET_TITLE = "uiNavSetTitle";

    @Override
    public void jsCallNative(String id, String params) {

        Log.e("JSUiTitlePlugin", "id == " + id + " , params == " + params);

        emitDataToWeb(id, params);
    }
}