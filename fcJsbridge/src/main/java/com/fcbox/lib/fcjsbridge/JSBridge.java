package com.fcbox.lib.fcjsbridge;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.fcbox.anglib.fcwebview.base.IWebview;
import com.fcbox.anglib.fcwebview.base.ValueCallback;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class JSBridge {

    /**
     * jsPlugin容器，key：js调用的方法名 value：相应的jsPlugin
     */
    private Map<String, BaseJSPlugin> jsPluginMap = new HashMap<>();

    private IWebview mWebView;

    public JSBridge(IWebview webView) {
        mWebView = webView;

        jsPluginMap.putAll(PluginManager.INSTANCE.getJSPlugins());
    }

    public View getWebView() {
        return mWebView.getWebview();
    }

    /**
     * 注册jsPlugin，所有hybrid交互必须先注册jsPlugin
     */
    public void registerJSPlugin(String jsFunction, BaseJSPlugin jsPlugin) {
        if (jsPluginMap == null) {
            jsPluginMap = new LinkedHashMap<>();
        }

        if (!TextUtils.isEmpty(jsFunction) && jsPlugin != null) {
            jsPluginMap.put(jsFunction, jsPlugin);
        } else {
            throw new UnsupportedOperationException("jsFunction or jsPlugin is not allowed to be empty.");
        }
    }

    /**
     * 获取jsPlugin
     */
    public BaseJSPlugin getJSPlugin(String plugin) {
        return jsPluginMap == null ? null : jsPluginMap.get(plugin);
    }

    public void getParamsFromWeb(final String plugin, final String id) {
        if (null == getWebView()) {
            return;
        }

        final String jsCommand = String.format(BridgeUtil.GET_PARAMS_FROM_WEB, id);

        getWebView().post(new Runnable() {

            @Override
            public void run() {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                    mWebView.evaluateJavascript(jsCommand, new ValueCallback<String>() {

                        @Override
                        public void onReceiveValue(String value) {
                            Log.e("getParamsFromWeb", value);

                            //去掉反斜杠
                            if (!TextUtils.isEmpty(value)) {
                                value = value.replace("\\", "");
                                value = value.substring(1, value.length() - 1);
                            }

                            BaseJSPlugin jsPlugin = jsPluginMap.get(plugin);
                            if (jsPlugin != null) {
                                jsPlugin.setId(id);
                                jsPlugin.setParams(value);
                                jsPlugin.setJSBridge(JSBridge.this);
                                jsPlugin.jsCallNative(id, value);
                            }
                        }
                    });
                } else {
                    mWebView.loadUrl(jsCommand);
                }
            }
        });
    }

    public void emitDataToWeb(String id, String params) {
        if (null == mWebView) {
            return;
        }

        final String jsCommand = String.format(BridgeUtil.EMIT_DATA_TO_WEB, id, params);

        getWebView().post(new Runnable() {

            @Override
            public void run() {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
                    mWebView.evaluateJavascript(jsCommand, new ValueCallback<String>() {

                        @Override
                        public void onReceiveValue(String value) {
                            Log.e("emitDataToWeb", value);
                        }
                    });
                } else {
                    mWebView.loadUrl(jsCommand);
                }
            }
        });
    }
}
