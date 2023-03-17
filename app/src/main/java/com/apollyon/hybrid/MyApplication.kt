// Copyright 2019 The Flutter team. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package com.apollyon.hybrid

import androidx.multidex.MultiDexApplication
import com.zero.flutter_pigeon_plugin.FlutterPigeonPlugin
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

const val ENGINE_ID = "1"

class MyApplication : MultiDexApplication() {
    val pigeonPlugin = FlutterPigeonPlugin()

    override fun onCreate() {
        super.onCreate()

        val flutterEngine = FlutterEngine(this)
        flutterEngine
            .dartExecutor
            .executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
        flutterEngine.plugins.add(pigeonPlugin)
        FlutterEngineCache.getInstance().put(ENGINE_ID, flutterEngine)
    }

    fun setToken() {
        pigeonPlugin.setToken();
    }
}
