package com.fcbox.lib.fcjsbridge;

import android.util.Log;

import com.google.gson.Gson;

/**
 * 业务相关的jsApi
 */
public class JSUiTitlePlugin extends BaseJSPlugin {

    @Override
    public void jsCallNative(String id, String params) {

        Log.e("JSUiTitlePlugin", "id == " + id + " , params == " + params);

        String data = new Gson().toJson("{\"status\":0,\"msg\":\"success\",\"data\":\"20200703\"}");

        emitDataToWeb(id, data);
    }
}