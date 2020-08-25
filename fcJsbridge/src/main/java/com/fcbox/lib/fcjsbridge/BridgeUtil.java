package com.fcbox.lib.fcjsbridge;

public class BridgeUtil {

    //fcbox://模块名xxx?_id=xxx
    public static final String FC_PROTOCOL_SCHEME = "fcbox://";
    public static final String FC_EMPTY_STR = "";
    public final static String BRIDGE_SCHEME = "fcbox";

    public final static String EMIT_DATA_TO_WEB = "javascript:FCH.emit(%s,%s)";
    public final static String GET_PARAMS_FROM_WEB = "javascript:FCH.getParams(%s)";

    public static String getModuleNameFromUrl(String url) {
        String temp = url.replace(FC_PROTOCOL_SCHEME, FC_EMPTY_STR);
        String[] moduleAndParams = temp.split("\\?");

        if (moduleAndParams.length >= 1) {
            return moduleAndParams[0];
        }

        return "";
    }

    public static String getParamDataFromUrl(String url) {
        String temp = url.replace(FC_PROTOCOL_SCHEME, FC_EMPTY_STR);
        String[] paramAndData = temp.split("=");

        if (paramAndData.length >= 2) {
            return paramAndData[1];
        }

        return "";
    }
}
