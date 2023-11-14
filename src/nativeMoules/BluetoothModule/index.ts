import { NativeModules } from 'react-native'
const { RTNBluetooth } = NativeModules
interface BluetoothInterface {
  add(a: number, b: number): Promise<number>
  subtract(a: number, b: number): Promise<number>
  checkBluetoothSupport(): Promise<boolean>
  toggleBluetooth(): Promise<string>
  enableBluetooth(): Promise<string>
  getBondedPeripherals(): Promise<string[]>
  pairDevice(deviceId: string, isServer: boolean): Promise<string>
  startAcceptServer(): Promise<string>
  startDiscovery(): Promise<boolean>
  cancelDiscovery(): Promise<boolean>
  addListener: (eventType: string) => void
  removeListeners(count: number): void
}
export default RTNBluetooth as BluetoothInterface
