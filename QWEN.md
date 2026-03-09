# GymPulse - Kotlin Android MVVM Template

## Project Overview

**GymPulse** is a Kotlin Android application built with **Jetpack Compose** following the **MVVM (Model-View-ViewModel)** architecture pattern. The project serves as a lightweight template for building modern Android apps with Navigation, Retrofit, and Dagger-Hilt fully configured.

### Key Technologies

| Technology | Purpose |
|------------|---------|
| **Kotlin** (2.3.10) | Primary language |
| **Jetpack Compose** | UI toolkit |
| **Dagger-Hilt** (2.59.2) | Dependency injection |
| **Retrofit** (3.0.0) | HTTP client for API calls |
| **Kotlinx Serialization** (1.10.0) | JSON serialization |
| **Room** (2.8.4) | Local database (configured, commented out) |
| **Coil** (2.7.0) | Image loading |
| **Navigation Compose** (2.9.7) | In-app navigation |
| **Gradle Version Catalog** | Dependency management |
| **detekt** (1.23.8) | Static code analysis |

### Architecture

The project follows a clean **MVVM architecture** with the following layer structure:

```
app/src/main/java/ru/app/
├── di/                 # Dagger-Hilt dependency injection modules
├── network/            # Retrofit API service definitions
├── model/              # Data classes (DTOs, responses)
├── repository/         # Repository interface and implementation
├── presentation/       # UI layer (Composables, ViewModels)
│   ├── screen/         # Composable screens
│   ├── ui/             # Theme and UI components
│   └── viewmodel/      # ViewModels
└── util/               # Utility classes (ApiState, etc.)
```

### Multi-Module Structure

The project uses a multi-module Gradle setup:

| Module | Description |
|--------|-------------|
| `:app` | Main application module |
| `:core` | Core utilities module |
| `:core:database` | Database module (Room) |
| `:feature:training_list` | Feature module for training list functionality |

## Building and Running

### Prerequisites

- **Android Studio** (latest stable version recommended)
- **JDK 17** (configured in `gradle.properties`)
- **Android SDK** (API 24+ for minSdk, API 36 for compileSdk)

### Setup

1. **Clone the repository:**
   ```bash
   git clone <repository-url>
   cd GymPulse
   ```

2. **Configure local properties (optional):**
   Create a `local.properties` file in the project root to set custom API base URL:
   ```properties
   BASE_URL=https://dummyjson.com/
   ```

3. **Sync Gradle:**
   Open the project in Android Studio and let it sync, or run:
   ```bash
   ./gradlew sync
   ```

### Build Commands

| Command | Description |
|---------|-------------|
| `./gradlew assembleDebug` | Build debug APK |
| `./gradlew assembleRelease` | Build release APK |
| `./gradlew detekt` | Run detekt static analysis |
| `./gradlew test` | Run unit tests |
| `./gradlew connectedAndroidTest` | Run instrumented tests |
| `./gradlew clean` | Clean build artifacts |

### Running on Device/Emulator

1. Connect an Android device or start an emulator (API 24+)
2. Run from Android Studio or execute:
   ```bash
   ./gradlew installDebug
   ```

## Development Conventions

### Code Style

- **Kotlin coding style:** Official (configured in `gradle.properties`)
- **Max line length:** 120 characters (detekt configuration)
- **JVM target:** Java 17

### Static Analysis

The project uses **detekt** for code smell detection with a custom configuration at `config/detekt/detekt.yml`. Key rules include:

- Cyclomatic complexity limit: 15
- Long method threshold: 60 lines
- Long parameter list threshold: 8 (functions), 7 (constructors)
- Too many functions threshold: 11

Run detekt before committing:
```bash
./gradlew detekt
```

### Testing

- **Unit tests:** Located in `app/src/test/java/`
- **Instrumented tests:** Located in `app/src/androidTest/java/`
- **Test frameworks:** JUnit, Espresso, AndroidX Test

### Dependency Management

All dependencies are managed via **Gradle Version Catalog** in `gradle/libs.versions.toml`. This ensures:
- Single source of truth for dependency versions
- Type-safe dependency declarations
- Easy version updates

### CI/CD

GitHub Actions workflow (`.github/workflows/build_apk.yml`) runs on every push to `main`:

1. **detekt** code smell analysis
2. **Unit tests**
3. **Debug APK build**

Artifacts are uploaded for each run.

### Dependabot

Dependabot is configured for **daily** dependency updates (`.github/dependabot.yml`). It monitors the Gradle dependencies and creates pull requests for updates.

## Project-Specific Notes

### Package Naming

The project uses `ru.app` as the default package name. **TODOs** are placed throughout the codebase to remind developers to:
- Change the package name
- Update the application ID
- Configure API endpoints
- Set up proper API response models

### Feature Modules

- **`feature:training_list`**: Placeholder feature module for training list functionality
- **`core:database`**: Database module with Room configured (dependencies commented out, ready to enable)

### Theme

The app uses a custom Material 3 theme defined in `presentation/ui/theme/`.

## Common Tasks

### Adding a New API Endpoint

1. Add the function to `ApiService.kt`
2. Create the response model in `model/`
3. Add repository method in `Repository.kt` and `RepositoryImpl.kt`
4. Create ViewModel in `presentation/viewmodel/`
5. Create Composable screen in `presentation/screen/`

### Adding a New Feature Module

1. Create a new module under `feature/`
2. Add module to `settings.gradle.kts`
3. Configure `build.gradle.kts` for the module
4. Add dependencies via `libs.versions.toml`

### Enabling Room Database

Uncomment the Room dependencies in `core/database/build.gradle.kts`:
```kotlin
implementation(libs.androidx.room.runtime)
implementation(libs.androidx.room.ktx)
ksp(libs.androidx.room.compiler)
implementation(libs.hilt.android)
ksp(libs.hilt.compiler)
```

## License

Distributed under the **MIT License**. See `LICENSE` file for details.

## Contributing

- Feel free to open issues for bugs or improvements
- Submit pull requests with changes
- Ensure detekt checks pass and tests pass before submitting
