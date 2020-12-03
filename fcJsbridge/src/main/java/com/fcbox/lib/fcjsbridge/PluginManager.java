package com.fcbox.lib.fcjsbridge;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public enum PluginManager {

  INSTANCE;

  private Map<String, BaseJSPlugin> jsPluginMap;

  public Map<String, BaseJSPlugin> getJSPlugins() {
    return jsPluginMap;
  }

  public void registerJSPlugin(String jsFunction, BaseJSPlugin jsPlugin) {
    if (jsPluginMap == null) {
      jsPluginMap = new HashMap<>();
    }

    if (!TextUtils.isEmpty(jsFunction) && jsPlugin != null) {
      jsPluginMap.put(jsFunction, jsPlugin);
    }
  }

  public void registerJSPlugin(Map<String, BaseJSPlugin> jSPlugins) {
    if (jsPluginMap == null) {
      jsPluginMap = new HashMap<>();
    }

    if (jSPlugins != null) {
      jsPluginMap.putAll(jSPlugins);
    }
  }

  public void unregisterJSPlugin(String jsFunction) {
    if (jsPluginMap != null && jsFunction != null) {
      jsPluginMap.remove(jsFunction);
    }
  }
}
