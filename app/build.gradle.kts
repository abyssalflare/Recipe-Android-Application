plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.myrecipeapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myrecipeapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

//Remember, the Gradle essentially helps assemble to tools we need to build the app and to help
//build the application with those tools. These tools include these dependencies/libraries
//we include in the Gradle file. This is why the Gradle runs before our app is shown as it is
//helping us use the tools to build the app

//These dependencies are essentially libraries online which functionality we wish to use in our
//applications. There are many software engineers out there creating their own libraries to make
//the lives of our developers easier, so that we don't have to write code for common features found
//in applications

//If we wish to use these dependencies in our Kotlin files, we need to use the import keyword within
//them
dependencies {

    //Jetpack Compose ViewModel - provides the ViewModel class we can inherit from from our own
    //ViewModel class
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    //Network Call - allows us to make network calls to collect data from the internet, aka, the
    //mealDB website we are using
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    //Helps to convert JSON data response from our request to Kotlin objects we can use
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    //Image loading - allows us to load the image we get back from the JSON data response
    implementation("io.coil-kt:coil-compose:2.4.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}