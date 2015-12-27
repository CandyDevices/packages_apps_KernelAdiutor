/*
 * Copyright (C) 2015 Willi Ye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.grarak.kerneladiutor.utils.kernel;

import android.content.Context;

import com.grarak.kerneladiutor.R;
import com.grarak.kerneladiutor.utils.Constants;
import com.grarak.kerneladiutor.utils.Utils;
import com.grarak.kerneladiutor.utils.root.Control;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by willi on 02.01.15.
 */
public class Wake implements Constants {

    public static void setDt2w(int value, Context context) {
        Control.runCommand(String.valueOf(value), DT2W, Control.CommandType.GENERIC, context);
    }

    public static int getDt2wValue() {
        return Utils.stringToInt(Utils.readFile(DT2W));
    }

    public static List<String> getDt2wMenu(Context context) {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.disabled));
        list.add(context.getString(R.string.dt2wmenu));
        list.add(context.getString(R.string.dt2whome));
        list.add(context.getString(R.string.dt2wback));
        list.add(context.getString(R.string.dt2wsearch));
        return list;
    }

    public static boolean hasDt2w() {
        return Utils.existFile(DT2W);
    }

    public static void setDt2s(int value, Context context) {
        Control.runCommand(String.valueOf(value), DT2S, Control.CommandType.GENERIC, context);
    }

    public static int getDt2sValue() {
        return Utils.stringToInt(Utils.readFile(DT2S));
    }

    public static List<String> getDt2sMenu(Context context) {
        List<String> list = new ArrayList<>();
        list.add(context.getString(R.string.disabled));
        list.add(context.getString(R.string.dt2wmenu));
        list.add(context.getString(R.string.dt2whome));
        list.add(context.getString(R.string.dt2wback));
        list.add(context.getString(R.string.dt2wsearch));
        return list;
    }

    public static boolean hasDt2s() {
        return Utils.existFile(DT2S);
    }

    public static void activateS2w(boolean active, Context context) {
        Control.runCommand(active ? "1" : "0", S2W, Control.CommandType.GENERIC, context);
    }

    public static boolean isS2wActive() {
        return Utils.readFile(S2W).equals("1");
    }

    public static boolean hasS2w() {
        return Utils.existFile(S2W);
    }

    public static void activateS2s(boolean active, Context context) {
        Control.runCommand(active ? "1" : "0", S2S, Control.CommandType.GENERIC, context);
    }

    public static boolean isS2sActive() {
        return Utils.readFile(S2S).equals("1");
    }

    public static boolean hasS2s() {
        return Utils.existFile(S2S);
    }

    public static void activateLenient(boolean active, Context context) {
        Control.runCommand(active ? "1" : "0", LENIENT, Control.CommandType.GENERIC, context);
    }

    public static boolean isLenientActive() {
        return Utils.readFile(LENIENT).equals("1");
    }

    public static boolean hasLenient() {
        return Utils.existFile(LENIENT);
    }

    public static boolean hasWake() {
        return Utils.existFile(WAKE);
    }

}
