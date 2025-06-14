plugins {
    alias(libs.plugins.android.application)



}

android {
    namespace = "com.example.fitnessapp11"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fitnessapp11"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}


dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


        // Core
        implementation ("androidx.appcompat:appcompat:1.6.1")
        implementation ("com.google.android.material:material:1.11.0")

        // Room Database
        implementation ("androidx.room:room-runtime:2.6.1")
        annotationProcessor ("androidx.room:room-compiler:2.6.1")

        // Retrofit
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

        // ViewModel & LiveData
        implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
        implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")

        // Navigation Component
        implementation ("androidx.navigation:navigation-fragment:2.7.6")
        implementation ("androidx.navigation:navigation-ui:2.7.6")
    implementation ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")

        // Glide for images
        implementation ("com.github.bumptech.glide:glide:4.16.0")

        // MPAndroidChart
        implementation ("com.github.PhilJay:MPAndroidChart:v3.1.0")

    //classpath ("com.android.tools.build:gradle:8.1.4") // Use latest stable version
    //classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.6")

    }
