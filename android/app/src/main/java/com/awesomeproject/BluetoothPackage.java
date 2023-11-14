package com.awesomeproject;

import androidx.annotation.Nullable;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.TurboReactPackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class BluetoothPackage implements ReactPackage {

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();

        modules.add(new BluetoothModule(reactContext));

        return modules;
    }
//    @Nullable
//    @Override
//    public NativeModule getModule(String name, ReactApplicationContext reactContext) {
//        if (name.equals(BluetoothModule.NAME)) {
//            return new BluetoothModule(reactContext);
//        } else {
//            return null;
//        }
//    }
//
//    @Override
//    public ReactModuleInfoProvider getReactModuleInfoProvider() {
//        return () -> {
//            final Map<String, ReactModuleInfo> moduleInfos = new HashMap<>();
//            moduleInfos.put(
//                    BluetoothModule.NAME,
//                    new ReactModuleInfo(
//                            BluetoothModule.NAME,
//                            BluetoothModule.NAME,
//                            false, // canOverrideExistingModule
//                            false, // needsEagerInit
//                            true, // hasConstants
//                            false, // isCxxModule
//                            true // isTurboModule
//                    ));
//            return moduleInfos;
//        };
//    }
}