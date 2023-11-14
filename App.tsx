/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import { BondedDeviceSectionList } from '@/components'
import RTNBluetooth from '@/nativeMoules/BluetoothModule'
import React, { useState } from 'react'
import { Button, SafeAreaView, StatusBar, StyleSheet, Text, useColorScheme, View } from 'react-native'

import { Colors } from 'react-native/Libraries/NewAppScreen'

interface BondedDeviceItem {
  deviceName: string
  deviceId: string
}

function App(): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark'
  const [isFetchingBondedDevice, setIsFetchingBondedDevice] = useState(false)
  const [isServer, setIsServer] = useState(false)
  const [bondedDevices, setBondedDevicesData] = useState<BondedDeviceItem[]>([])

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  }

  const handleToggleBluetooth = async () => {
    const res = await RTNBluetooth?.toggleBluetooth()
    console.log({ res })
  }

  const getBondedDevices = async () => {
    setIsFetchingBondedDevice(true)
    const devices = await RTNBluetooth?.getBondedPeripherals()
    console.log({ devices })
    if (devices?.length) {
      const data: BondedDeviceItem[] = devices?.map((item) => {
        const list = item.split('#')
        return {
          deviceName: list[0],
          deviceId: list[1],
        }
      })
      setBondedDevicesData(data)
      setIsFetchingBondedDevice(false)
    }
  }

  const startDiscovery = async () => {
    const res = await RTNBluetooth?.startDiscovery()
    console.log({ res })
  }
  const cancelDiscovery = async () => {
    const res = await RTNBluetooth?.cancelDiscovery()
    console.log({ res })
  }
  const startAcceptServer = async () => {
    const res = await RTNBluetooth?.startAcceptServer()
    console.log({ res })
  }

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={backgroundStyle.backgroundColor}
      />

      {/* <Header /> */}
      <View
        style={{
          backgroundColor: isDarkMode ? Colors.black : Colors.white,
        }}
      >
        <View style={styles.btnWrapper} />
        <Button title='toggle Bluetooth' onPress={handleToggleBluetooth} />

        <View style={styles.btnWrapper} />
        <Button title='Get bonded devices' onPress={getBondedDevices} />

        <View style={styles.btnWrapper} />
        <Button title='start discovery' onPress={startDiscovery} />

        <View style={styles.btnWrapper} />
        <Button title='cancel discovery' onPress={cancelDiscovery} />

        <View style={styles.btnWrapper} />
        <Button title='Act as Server' onPress={() => setIsServer(true)} />

        <View style={styles.btnWrapper} />
        <Button title='Start Server' onPress={startAcceptServer} />

        {isFetchingBondedDevice ? (
          <View>
            <Text>loading bonded devices data...</Text>
          </View>
        ) : (
          <BondedDeviceSectionList bondedDevices={bondedDevices} isServer={isServer} />
        )}
      </View>
    </SafeAreaView>
  )
}

const styles = StyleSheet.create({
  sectionContainer: {
    marginTop: 32,
    paddingHorizontal: 24,
  },
  sectionTitle: {
    fontSize: 24,
    fontWeight: '600',
  },
  sectionDescription: {
    marginTop: 8,
    fontSize: 18,
    fontWeight: '400',
  },
  highlight: {
    fontWeight: '700',
  },
  btnWrapper: {
    marginTop: 20,
  },
})

export default App
