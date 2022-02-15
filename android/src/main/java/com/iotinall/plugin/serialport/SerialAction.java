package com.iotinall.plugin.serialport;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.getcapacitor.Bridge;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SerialAction implements SerialController.OnSerialListener {

    public static Bridge bridge = null;

    public static String lastMsg = "";

    @Override
    public void onReceivedData(byte[] data, int size) {
        String str = new String(data, StandardCharsets.UTF_8).trim();
        lastMsg += str;
        if(str.endsWith("}")){
            Log.i("接收到完整串口数据：", lastMsg);
            Map<String, String> dataMap = new HashMap<>();
            dataMap.put("data", lastMsg);
            bridge.triggerWindowJSEvent("serialportdata", JSON.toJSONString(dataMap));
            lastMsg = "";
        }else{
            Log.i("收到部分串口数据}结尾", str);
        }
    }

    @Override
    public void onSerialOpenSuccess() {
        Log.i("串口工具", "连接成功");
    }

    @Override
    public void onSerialOpenException(Exception e) {
        Log.e("串口异常：", Objects.requireNonNull(e.getMessage()));
    }
}
