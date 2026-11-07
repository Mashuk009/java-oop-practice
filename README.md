# Java OOP Practice

[![CI](https://github.com/Mashuk009/java-oop-practice/actions/workflows/ci.yml/badge.svg)](https://github.com/Mashuk009/java-oop-practice/actions/workflows/ci.yml)

Шесть небольших консольных программ на Java, в которых по шагам разбираются основы объектно-ориентированного программирования. Все задачи построены вокруг одной предметной области (домашние питомцы), поэтому видно, как один и тот же код усложняется от модуля к модулю.

Репозиторий организован как многомодульный Gradle-проект: каждая задача лежит в отдельном модуле и запускается независимо.

## Модули

| Модуль | Описание | Темы |
|---|---|---|
| [01-inheritance-basics](01-inheritance-basics) | Ввод питомцев и вывод списка | Абстрактный класс, наследование, инкапсуляция |
| [02-polymorphism-feeding](02-polymorphism-feeding) | Расчёт нормы корма для кошек и собак | Абстрактные методы, полиморфизм, юнит-тесты |
| [03-interfaces-pet-types](03-interfaces-pet-types) | Деление питомцев на травоядных и всеядных | Интерфейсы, `instanceof`, `switch`-выражение |
| [04-immutability-recursion](04-immutability-recursion) | Увеличение возраста у питомцев старше 10 лет | Неизменяемые объекты, рекурсия, Stream API, юнит-тесты |
| [05-multithreading-walks](05-multithreading-walks) | Одновременные прогулки питомцев | Потоки, `join`, замер времени |
| [06-custom-iterator](06-custom-iterator) | Обход списка питомцев собственным итератором | Обобщённые интерфейсы, паттерн «Итератор», юнит-тесты |

В каждом модуле есть свой README с условием задачи и примером работы.

## Технологии

- Java 21
- Gradle (Kotlin DSL), многомодульная сборка
- JUnit 6 для юнит-тестов (модули 02, 04 и 06)

## Быстрый старт

Нужен установленный JDK 21.

```bash
git clone https://github.com/mashuk009/java-oop-practice.git
cd java-oop-practice
./gradlew build
```

В Windows (без WSL) вместо `./gradlew` используйте `gradlew.bat`.

## Запуск модуля

Программы читают данные из консоли. Формат ввода описан в README каждого модуля.

```bash
./gradlew :01-inheritance-basics:run
```

Замените имя модуля на нужное, например `:03-interfaces-pet-types:run`.

## Тесты

Все тесты:

```bash
./gradlew test
```

Тесты одного модуля:

```bash
./gradlew :02-polymorphism-feeding:test
```

## Структура проекта

```
java-oop-practice/
├── build.gradle.kts          # общие настройки всех модулей
├── settings.gradle.kts       # список модулей
├── gradlew, gradlew.bat      # Gradle Wrapper
├── 01-inheritance-basics/
│   ├── build.gradle.kts
│   ├── README.md
│   └── src/main/java/io/github/mashuk009/oop/inheritance/
├── 02-polymorphism-feeding/
│   └── ...
└── ...
```

## Автор

GitHub: [mashuk009](https://github.com/mashuk009)


