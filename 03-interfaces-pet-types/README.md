# 03. Интерфейсы: травоядные и всеядные

Консольная программа, которая читает список питомцев и выводит сначала травоядных, а затем всеядных.

## Задача

Пользователь вводит количество питомцев, а затем для каждого: тип (`dog`, `cat`, `hamster` или `guinea`), имя и возраст. Программа создаёт объекты и выводит их двумя группами:
1. травоядные (хомяк, морская свинка), у каждого выводится, сколько он может отдыхать;
2. всеядные (собака, кошка), у каждого выводится, на кого он может охотиться.

Обработка некорректного ввода:
- неподдерживаемый тип: `Incorrect input. Unsupported pet type`
- возраст не больше нуля: `Incorrect input. Age <= 0`
- вместо числа введён текст: `Could not parse a number. Please, try again`

## Что показывает модуль

- интерфейсы `Herbivore` и `Omnivore` с разным набором методов;
- класс, который наследует родителя и реализует интерфейс одновременно (`extends Animal implements Omnivore`);
- проверка типа через `instanceof`;
- выражение `switch` для создания объекта по типу;
- общий список `List<Animal>`, который делится на группы по интерфейсам.

## Запуск

Из корня репозитория:

```bash
./gradlew :03-interfaces-pet-types:run
```

## Пример

Ввод:

```
4
dog Rex 5
hamster Hammy 1
cat Tom 3
guinea Piggy 2
```

Вывод:

```
Hamster name = Hammy, age = 1. I can chill for 8 hours
GuineaPig name = Piggy, age = 2. I can chill for 12 hours
Dog name = Rex, age = 5. I can hunt for robbers
Cat name = Tom, age = 3. I can hunt for mice
```
