# # Android Saba Idea Task

 **Introduction**   
The application uses Clean Architecture and Respository Pattern on Core Layer and Mvvm on Presentation Layer.

The application is written entirely in Kotlin.

Android Jetpack is used as an Architecture glue including but not limited to ViewModel, LiveData, Lifecycles, Room. See a complete list in "Libraries used" section.

The application does network HTTP requests via Retrofit, OkHttp and GSON. Loaded data is saved to SQL based database Room, which serves as single source of truth and support offline mode.

Kotlin Coroutines manage background threads with simplified code and reducing needs for callbacks.


Dagger Hilt is used for dependency injection.

 ## Libraries Used
-   Foundation - Components for core system capabilities, Kotlin extensions.
    -   AppCompat - Degrade gracefully on older versions of Android.
    -   Android KTX - Write more concise, idiomatic Kotlin code.
    -   Architecture - A collection of libraries that help you design robust, testable, and maintainable apps. Start with classes for managing your UI component lifecycle and handling data persistence.
    -   Lifecycles - Create a UI that automatically responds to lifecycle events.
    -   LiveData - Build data objects that notify views when the underlying database changes.
    -   Room - SQLite database with in-app objects and compile-time checks.
    -   ViewModel - Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.
 


