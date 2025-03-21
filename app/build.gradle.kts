plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")

}

android {
    namespace = "com.shruti.intenttask"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.shruti.intenttask"
        minSdk = 26
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
    buildFeatures.viewBinding = true
}

dependencies {
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    implementation("androidx.navigation:navigation-common-ktx:2.8.5")
    implementation("androidx.navigation:navigation-fragment-ktx:2.8.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.5")
    // gif
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.22")
    // lottie animation
    implementation ("com.airbnb.android:lottie:3.4.2")
    // room database
    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    // location
    implementation ("com.google.android.gms:play-services-maps:19.0.0")
    implementation ("com.google.android.gms:play-services-location:21.3.0")
    implementation ("com.google.android.libraries.places:places:3.5.0")
}