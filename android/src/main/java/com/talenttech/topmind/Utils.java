package com.talenttech.topmind;

import android.support.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    static Map<String, Object> toMap(@Nullable ReadableMap readableMap) {
        if (readableMap == null) return new HashMap<>();

        ReadableMapKeySetIterator iterator = readableMap.keySetIterator();
        if (!iterator.hasNextKey()) {
            return new HashMap<>();
        }

        Map<String, Object> map = new HashMap<>();
        while (iterator.hasNextKey()) {
            String key = iterator.nextKey();
            map.put(key, toObject(readableMap, key));
        }

        return map;
    }

    private static Object toObject(@Nullable ReadableMap readableMap, String key) {
        if (readableMap == null) return null;

        Object object;
        ReadableType readableType = readableMap.getType(key);
        switch (readableType) {
            case Null:
                object = null;
                break;
            case Boolean:
                object = readableMap.getBoolean(key);
                break;
            case Number:
                double intCandidate = readableMap.getDouble(key);
                if (intCandidate == (int) intCandidate) {
                    object = (int) intCandidate;
                } else {
                    object = intCandidate;
                }
                break;
            case String:
                object = readableMap.getString(key);
                break;
            case Map:
                object = toMap(readableMap.getMap(key));
                break;
            case Array:
                object = toList(readableMap.getArray(key));
                break;
            default:
                throw new IllegalArgumentException("Could not convert object with key: " + key);
        }

        return object;
    }

    private static List<Object> toList(@Nullable ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }

        List<Object> list = new ArrayList<>(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableType readableType = readableArray.getType(i);
            switch (readableType) {
                case Null:
                    list.add(null);
                    break;
                case Boolean:
                    list.add(readableArray.getBoolean(i));
                    break;
                case Number:
                    double intCandidate = readableArray.getDouble(i);
                    if (intCandidate == (int) intCandidate) {
                        list.add((int) intCandidate);
                    } else {
                        list.add(intCandidate);
                    }
                    break;
                case String:
                    list.add(readableArray.getString(i));
                    break;
                case Map:
                    list.add(toMap(readableArray.getMap(i)));
                    break;
                case Array:
                    list = toList(readableArray.getArray(i));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object with index: " + i);
            }
        }

        return list;
    }
}
