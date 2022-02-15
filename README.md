# serialport

ionic capacitor串口插件

## Install

```bash
npm install capacitor-serialport
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`makezero()`](#makezero)
* [`connSerialPort(...)`](#connserialport)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### makezero()

```typescript
makezero() => Promise<void>
```

--------------------


### connSerialPort(...)

```typescript
connSerialPort(options: { serialPath: string; baudRate: number; flags: number; }) => Promise<void>
```

| Param         | Type                                                                  | remark |
| ------------- | --------------------------------------------------------------------- | -------------- |
| **`options`** | <code>{ serialPath: string; baudRate: number; flags: number; }</code> | 连接串口参数：串口路径，波特率，1 |

--------------------

### 事例
```typescript
//引入
import { Serialport } from "capacitor-serialport";

//使用
Serialport.connSerialPort({serialPath: "/dev/ttyS3", baudRate: 115200, flags: 0})

//监听串口返回数据
window.addEventListener("serialportdata", (val) => {
    console.log("页面串口数据:", JSON.stringify(val))
})

```

</docgen-api>
