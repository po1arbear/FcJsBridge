package com.fcbox.lib.fcjsbridge;

import android.util.Log;

/**
 * 通用Plugin
 */
public class JSCommPlugin extends BaseJSPlugin {

    final static String COMMON_1 = "COMMON_1";
    final static String COMMON_2 = "COMMON_2";
    final static String COMMON_3 = "COMMON_3";

    @Override
    public void jsCallNative(String id, String params) {

        Log.e("JSCommPlugin", "id == " + id + " , params == " + params);

        switch (getPlugin()) {
            case COMMON_1:
                emitDataToWeb(id, COMMON_1);
                break;
            case COMMON_2:
                emitDataToWeb(id, COMMON_2);
                break;
            case COMMON_3:
                emitDataToWeb(id, COMMON_3);
                break;
            default:
                break;
        }
    }
}