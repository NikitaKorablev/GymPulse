![Language](https://img.shields.io/github/languages/top/NikitaKorablev/kotlin-android-mvvm-template?color=B125EA&logo=kotlin&style=social)&nbsp;&nbsp;
[![Owner](https://img.shields.io/badge/by-NikitaKorablev-brightgreen?logo=github&style=social)](https://github.com/NikitaKorablev)&nbsp;&nbsp;

# GymPulse — Kotlin Android MVVM Template

Android-приложение на **Kotlin** с использованием **Jetpack Compose**, **MVVM-архитектуры**, **многомодульной структуры** и полной настройкой **Dagger-Hilt**, **Retrofit** и **Navigation Compose**.

> Основано на шаблоне [kotlin-android-mvvm-template](https://github.com/its-me-debk007/kotlin-android-mvvm-template) от [its-me-debk007](https://github.com/its-me-debk007).

![Language](https://img.shields.io/github/languages/top/its-me-debk007/kotlin-android-mvvm-template?color=B125EA&logo=kotlin&style=social)&nbsp;&nbsp;
[![Owner](https://img.shields.io/badge/by-its--me--debk007-brightgreen?logo=github&style=social)](https://github.com/its-me-debk007)&nbsp;&nbsp;
![License](https://img.shields.io/github/license/its-me-debk007/kotlin-android-mvvm-template.svg?style=social)

> *"Каждая строка кода должна быть написана один раз и только один раз." — Рон Джеффрис*

## Возможности 🎨

- Полностью на **Jetpack Compose**
- **Navigation Compose** для навигации
- **Retrofit 3.0.0** с настройкой для работы с API (пример вызова включён)
- **MVVM-архитектура** с чистой структурой слоёв
- **Многомодульная структура** (app, core, feature)
- **Kotlin 2.3.10** + **Kotlin DSL**
- **Gradle Version Catalog** для управления зависимостями
- **Dagger-Hilt 2.59.2** для внедрения зависимостей
- **Kotlinx Serialization 1.10.0** для работы с JSON
- **Coil 2.7.0** для загрузки изображений
- **Room 2.8.4** (настроен, готов к использованию)
- **detekt** для статического анализа кода — настроен для Jetpack Compose
- **Dependabot** (ежедневные обновления зависимостей)
- **GitHub Actions CI/CD** — запускает detekt, unit-тесты, собирает и загружает APK


## Начало работы 👣
### Требования

- **Android Studio** (последняя стабильная версия)
- **JDK 17**
- **Android SDK** (minSdk 24, compileSdk 36)

### Сборка и запуск

| Команда | Описание |
|---------|----------|
| `./gradlew assembleDebug` | Сборка debug APK |
| `./gradlew assembleRelease` | Сборка release APK |
| `./gradlew detekt` | Запуск статического анализа |
| `./gradlew test` | Запуск unit-тестов |
| `./gradlew clean` | Очистка артефактов сборки |

Для запуска на устройстве/эмуляторе (API 24+):
```bash
./gradlew installDebug
```


## Структура проекта 🗺️📐🛠️

Проект использует **многомодульную архитектуру**:

### Модули

| Модуль | Описание |
|--------|----------|
| `:app` | Главный модуль приложения (UI, ViewModels, навигация) |
| `:core:data` | Слой данных — реализации репозиториев, DI |
| `:core:domain` | Слой бизнес-логики — модели домена, интерфейсы репозиториев |
| `:core:database` | Слой базы данных — Room, DAO, entities, DI |
| `:feature:training_list` | Фича-модуль — список тренировок (в разработке) |

### Пакеты модуля `app`

```
app/src/main/java/ru/app/
├── di/                 # Модули Dagger-Hilt
├── network/            # API-сервисы (Retrofit)
├── model/              # Data classes (DTO)
├── repository/         # Интерфейс и реализация репозитория
├── presentation/       # UI-слой (Compose, ViewModels)
│   ├── screen/         # Экраны приложения
│   ├── ui/theme/       # Тема и стили
│   └── viewmodel/      # ViewModels
├── util/               # Утилиты (ApiState и др.)
├── MainActivity.kt     # Главная Activity
└── MyApplication.kt    # Application класс с @HiltAndroidApp
```

### Конвенции кода

- **Стиль Kotlin:** официальный (настроен в `gradle.properties`)
- **Максимальная длина строки:** 120 символов
- **JVM target:** Java 17
- **detekt:** настроен с лимитами сложности (CyclomaticComplexMethod: 15, LongMethod: 60 строк)

Запуск detekt перед коммитом:
```bash
./gradlew detekt
```

## CI/CD 🚀

GitHub Actions workflow (`.github/workflows/build_apk.yml`) запускается при каждом пуше в `main`:

1. **detekt** — статический анализ кода
2. **Unit-тесты** — запуск всех unit-тестов
3. **Сборка Debug APK** — создание и загрузка артефакта

Отчёты и APK загружаются как артефакты.

## Вклад в проект 🤝

Приветствуется любая помощь! Открывайте issues с багами или предложениями, отправляйте pull request'ы.

Перед отправкой убедитесь, что:
```bash
./gradlew detekt && ./gradlew test
```
проходят без ошибок.

## Лицензия

Распространяется под лицензией **MIT**. Подробнее в файле `LICENSE`.

#### 🌟 Если проект оказался полезен — поставьте звезду! Ваша поддержка помогает проекту развиваться. 🚀
