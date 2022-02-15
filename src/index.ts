import { registerPlugin } from '@capacitor/core';

import type { SerialportPlugin } from './definitions';

const Serialport = registerPlugin<SerialportPlugin>('Serialport', {
  web: () => import('./web').then(m => new m.SerialportWeb()),
});

export * from './definitions';
export { Serialport };
