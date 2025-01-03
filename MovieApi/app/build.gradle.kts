plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

}

android {
    namespace = "com.example.movieapi"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.movieapi"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
}

dependencies {
// ViewModel
    implementation(libs.lifecycle.version)
    // ViewModel utilities for Compose
    implementation(libs.local.compose)
    // LiveData
    implementation(libs.local.livedata)
    // Saved state module for ViewModel
    implementation(libs.savestate.viewmodel)
    implementation(libs.coroutine.version)

    implementation(libs.retrofit.dependency)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.okhttp)
    implementation(libs.httplogging.dependency)
    implementation(libs.piccaso)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}