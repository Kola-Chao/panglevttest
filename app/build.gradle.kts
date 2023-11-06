plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kola.panglevttest"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kola.panglevttest"
        minSdk = 24
        targetSdk = 34
        versionCode = 100
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    //设置签名文件
    signingConfigs {
        create("release") {
            storeFile = file("panglevttest.keystore")
            storePassword = "123456"
            keyAlias = "pangletest"
            keyPassword = "123456"
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.findByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    implementation("com.pangle.global:ads-sdk:+") {
//        exclude(group = "com.pangle.global", module = "crash_monitor")
//        exclude(group = "com.pangle.global", module = "global:encryptor")
//    }
//    implementation("com.applovin:applovin-sdk:+")
//    implementation("com.applovin.mediation:inmobi-adapter:+")
    //inmobi test
    implementation("com.inmobi.monetization:inmobi-ads-kotlin:10.5.9")
}