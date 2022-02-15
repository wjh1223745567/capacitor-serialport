# serialport

serialport android serial port

## Install

```bash
npm install serialport
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

| Param         | Type                                                                  |
| ------------- | --------------------------------------------------------------------- |
| **`options`** | <code>{ serialPath: string; baudRate: number; flags: number; }</code> |

--------------------

</docgen-api>
