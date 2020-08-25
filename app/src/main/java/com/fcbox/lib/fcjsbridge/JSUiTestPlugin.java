package com.fcbox.lib.fcjsbridge;

import android.util.Log;

/**
 * 业务相关的jsApi
 */
public class JSUiTestPlugin extends BaseJSPlugin {

    @Override
    public void jsCallNative(String id, String params) {

        Log.e("JSUiTestPlugin", "id == " + id + " , params == " + params);

        emitDataToWeb(id, "222222");
    }
}