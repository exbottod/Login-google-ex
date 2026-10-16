plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")  // untuk Firebase (opsional)
}

android {
    namespace = "com.example.loginapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.loginapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    // Compose
    implementation(platform("androidx.compose:compose-bom:2024.09.03"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-extended")
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.6")

    // Credential Manager (Google Sign-In baru)
    implementation("androidx.credentials:credentials:1.3.0")
    implementation("androidx.credentials:credentials-play-services-auth:1.3.0")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    // DataStore untuk simpan session
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // Coil untuk load avatar
    implementation("io.coil-kt:coil-compose:2.7.0")
}
