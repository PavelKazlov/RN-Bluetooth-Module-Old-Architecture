package com.awesomeproject;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.Map;
import java.util.HashMap;
import android.content.Context;
//import com.awesomeproject.NativeBluetoothSpec;

public class BluetoothModule extends ReactContextBaseJavaModule {

    public static String NAME = "RTNBluetooth";
    private Context context;
    final private BlcManager mRNCBluetoothManagerImpl;


    BluetoothModule(ReactApplicationContext context) {
        super(context);
        mRNCBluetoothManagerImpl = new BlcManager(context);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void add(double a, double b, Promise promise) {
        promise.resolve(a + b);
    }
    @ReactMethod
    public void subtract(double a, double b, Promise promise) {
        promise.resolve(a - b);
    }

    @ReactMethod
    public void checkBluetoothSupport(Promise promise) {
        mRNCBluetoothManagerImpl.checkBluetoothSupport(promise);
    }

    @ReactMethod
    public void toggleBluetooth(Promise promise) {
        mRNCBluetoothManagerImpl.toggleBlueTooth(promise);
    }

    @ReactMethod
    public void enableBluetooth(Promise promise) {
        mRNCBluetoothManagerImpl.enableBluetooth(promise);
    }

    @ReactMethod
    public void getBondedPeripherals(Promise promise) {
        mRNCBluetoothManagerImpl.getBondedPeripherals(promise);
    }
    @ReactMethod
    public void pairDevice(String deviceId, boolean isServer, Promise promise) {
        mRNCBluetoothManagerImpl.pairDevice(deviceId, isServer, promise);
    }
    @ReactMethod
    public void startDiscovery( Promise promise) {
        mRNCBluetoothManagerImpl.startDiscovery(promise);
    }

    @ReactMethod
    public void cancelDiscovery( Promise promise) {
        mRNCBluetoothManagerImpl.cancelDiscovery(promise);
    }
    @ReactMethod
    public void startAcceptServer( Promise promise) {
        mRNCBluetoothManagerImpl.startAcceptServer(promise);
    }

    @ReactMethod
    public void addListener(String eventType) {
        // NOOP
    }

    @ReactMethod
    public void removeListeners(double count) {
        // NOOP
    }
}