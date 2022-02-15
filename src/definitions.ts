export interface SerialportPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  makezero():Promise<void>;
  connSerialPort(options: {serialPath: string, baudRate: number, flags: number}):Promise<void>;
}
