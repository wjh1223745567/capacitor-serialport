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

    @Override
    public void onReceivedData(byte[] data, int size) {
        String str = new String(data, StandardCharsets.UTF_8).trim();
        Log.i("接收到串口数据：", str);
        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("data", str);
        bridge.triggerWindowJSEvent("serialportdata", JSON.toJSONString(dataMap));
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
