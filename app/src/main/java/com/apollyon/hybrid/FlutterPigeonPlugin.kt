package com.zero.flutter_pigeon_plugin

import android.content.Context
import android.widget.Toast
import androidx.annotation.NonNull
import com.markov.flutter_pigeon_plugin.FCNApi
import com.markov.flutter_pigeon_plugin.FMarkovToken
import com.markov.flutter_pigeon_plugin.FStateResult
import com.markov.flutter_pigeon_plugin.NCFApi
import io.flutter.embedding.engine.plugins.FlutterPlugin

/** FlutterPigeonPlugin */
class FlutterPigeonPlugin : FlutterPlugin, FCNApi {

    lateinit var nativeApi: NCFApi
    lateinit var context: Context

    override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        context = flutterPluginBinding.applicationContext
        println("FCNApi.setUp")
        // setup
        FCNApi.setUp(flutterPluginBinding.binaryMessenger, this)

        println("NCFApi")
        nativeApi = NCFApi(flutterPluginBinding.binaryMessenger)


    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        FCNApi.setUp(binding.binaryMessenger, null)
    }

    override fun getToken(token: FMarkovToken, callback: (Result<FStateResult>) -> Unit) {
    }

    fun setToken() {
        nativeApi.setToken(
            FMarkovToken(
                "3PWg1kiIMtkfc1tv2sjf-FObbOcSm_tVEi_GkS782A8.r3u5dD5dAz7LQIkyfzbzWzRUiMSPIpu_3LCjJ_pH-4M",
                "Fbxep5MzRlhxt7OsohZh0IRxp-dd_uQQrpUbH4jGuak.P9ArehA6KiqJHoxf57JhqrwwN3lpJnqZXf2rzqxZrM0"
            ), callback = {}
        )
    }
}
