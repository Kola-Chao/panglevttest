package com.kola.panglevttest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.inmobi.sdk.InMobiSdk
import com.inmobi.sdk.SdkInitializationListener
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        initMax()
        initInmobi()
    }

//    private fun initMax() {
//        // Make sure to set the mediation provider value to "max" to ensure proper functionality
//        AppLovinSdk.getInstance(this).mediationProvider = "max"
//        AppLovinSdk.getInstance(this).initializeSdk {
//            // AppLovin SDK is initialized, start loading ads
//            Log.d("MainActivity", "AppLovin SDK Initialization Success")
//            initInmobi()
//        }
//    }

    private fun initInmobi() {
        val consentObject = JSONObject()
        try {
            // Provide correct consent value to sdk which is obtained by User
            consentObject.put(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE, true)
            // Provide 0 if GDPR is not applicable and 1 if applicable
            consentObject.put("gdpr", "0")
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        InMobiSdk.init(
            this,
            "f3dd21d0cfb442559e75d10e967492c6",
            consentObject,
            object : SdkInitializationListener {
                override fun onInitializationComplete(error: java.lang.Error?) {
                    if (error == null) {
                        Log.d("MainActivity", "InMobi SDK Initialization Success")
                    } else {
                        Log.d("MainActivity", "InMobi SDK Initialization failed: " + error.message)
                    }
                }
            })
    }
}