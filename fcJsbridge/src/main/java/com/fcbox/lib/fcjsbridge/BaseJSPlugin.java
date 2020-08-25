package com.fcbox.lib.fcjsbridge;

import android.content.Context;
import android.view.View;

public abstract class BaseJSPlugin {

    private JSBridge jSBridge;

    private String id;

    private String params;

    public JSBridge getJSBridge() {
        return jSBridge;
    }

    public void setJSBridge(JSBridge jSBridge) {
        this.jSBridge = jSBridge;
    }

    public String getId() {
        return id == null ? "" : id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParams() {
        return params == null ? "" : params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public View getWebView() {
        if (jSBridge != null) {
            return jSBridge.getWebView();
        }
        return null;
    }

    public Context getContext() {
        View view = getWebView();
        if (view != null) {
            return view.getContext();
        }
        return null;
    }

    public void emitDataToWeb(String id, String params) {
        jSBridge.emitDataToWeb(id, params);
    }

    public abstract void jsCallNative(String id, String params);
}
