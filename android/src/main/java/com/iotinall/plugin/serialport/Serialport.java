package com.iotinall.plugin.serialport;

import android.util.Log;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Serialport {

    public static SerialController serial = null;

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }

    /**
     * 称归零
     */
    public void makezero() {
        Log.i("makezero", "调用称归零1");
    }

    /**
     * 连接串口
     * @param serialPath
     * @param baudRate
     * @param flags
     */
    public void connSerialPort(String serialPath, Integer baudRate, Integer flags){
        serial = new SerialController();
        List<String> list = serial.getAllSerialPortPath();
        Log.i("查看列表串口", JSON.toJSONString(list));
        serial.openSerialPort(serialPath, baudRate, flags);
    }
}
