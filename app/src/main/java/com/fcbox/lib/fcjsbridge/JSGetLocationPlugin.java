package com.fcbox.lib.fcjsbridge;

import android.util.Log;

import com.google.gson.Gson;

/**
 * 业务相关的jsApi
 */
public class JSGetLocationPlugin extends BaseJSPlugin {

    @Override
    public void jsCallNative(String id, String params) {

        Log.e("JSGetLocationPlugin", "id == " + id + " , params == " + params);

        String data = new Gson().toJson("{\"status\":0,\"msg\":\"success\",\"data\":\"经纬度\"}");

        emitDataToWeb(id, data);
    }
}