import { WebPlugin } from '@capacitor/core';

import type { SerialportPlugin } from './definitions';

export class SerialportWeb extends WebPlugin implements SerialportPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
  async makezero(): Promise<void> {
    console.log("称已归零")
  }
  async connSerialPort(options: {serialPath: string, baudRate: number, flags: number}): Promise<void> {
    console.log("页面连接串口调用", JSON.stringify(options))
  }
  async sendPortMsg(options: {msg: string}): Promise<void>{
    console.log("页面发送串口指令", JSON.stringify(options))
  }
}
