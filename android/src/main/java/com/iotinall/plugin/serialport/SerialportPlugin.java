package com.iotinall.plugin.serialport;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.util.HostMask;
import com.getcapacitor.util.JSONUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@CapacitorPlugin(name = "Serialport")
public class SerialportPlugin extends Plugin {

    private Serialport implementation = new Serialport();

    private Integer testvalue = 0;

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void makezero(PluginCall call){
        implementation.makezero();
        call.resolve();
    }

    @PluginMethod
    public void connSerialPort(PluginCall call){
        Log.i("连接串口：", call.getString("serialPath") + " " + call.getInt("baudRate") + " " + call.getInt("flags"));
        implementation.connSerialPort(call.getString("serialPath"), call.getInt("baudRate"), call.getInt("flags"));
        //返回事件触发
        SerialAction.bridge = bridge;
        call.resolve();

        Map<String, String> dataMap = new HashMap<>();
        dataMap.put("data", String.valueOf(testvalue));
        bridge.triggerWindowJSEvent("serialportdata", JSON.toJSONString(dataMap));
        testvalue++;
    }

    /**
     * 发送串口数据
     * @param call
     */
    @PluginMethod
    public void sendPortMsg(PluginCall call){
        implementation.sendPortMsg(call.getString("msg"));
        call.resolve();
    }
}
