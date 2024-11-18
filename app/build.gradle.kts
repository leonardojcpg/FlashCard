// build.gradle (Módulo - app)

plugins {
    alias(libs.plugins.android.application)
    id ("com.google.gms.google-services")
}

android {
    namespace = "App.FlashCardStudy"
    compileSdk = 34

    defaultConfig {
        applicationId = "app.FlashCardStudy"
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
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Dependências do Firebase
    implementation(platform("com.google.firebase:firebase-bom:33.5.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth:21.1.0")
    implementation("com.google.firebase:firebase-firestore:24.0.0")
    implementation("com.google.firebase:firebase-messaging:23.1.0")
    implementation ("com.google.firebase:firebase-storage")
    implementation ("com.google.firebase:firebase-database")

    // Outras dependências
    implementation("com.squareup.picasso:picasso:2.71828")
    implementation("com.google.android.gms:play-services-auth:20.0.1")
    implementation("com.google.android.flexbox:flexbox:3.0.0")
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.15.1")
}
