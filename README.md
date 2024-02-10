# Валидатор данных #

### Hexlet tests and linter status:
[![Basic Functionality Check](https://github.com/DEGTEVUWU/java-project-78/actions/workflows/main.yml/badge.svg)](https://github.com/DEGTEVUWU/java-project-78/actions)
[![Actions Status](https://github.com/DEGTEVUWU/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DEGTEVUWU/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/65f41b9ca5d31da39d64/maintainability)](https://codeclimate.com/github/DEGTEVUWU/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/65f41b9ca5d31da39d64/test_coverage)](https://codeclimate.com/github/DEGTEVUWU/java-project-78/test_coverage)

## Описание ##
Валидатор данных – это бибилиотека, для проверки корректности введённых данных. 
Поддерживается валидация таких объектов:
> #### _String_ ####

> #### _Integer_ ####

>#### _Map_ ####

>#### _Вложенные схемы валидации_ ####

## Как подключить библитотеку ##

Клонируйте репозиторий к себе локально:
```
git clone git@github.com:DEGTEVUWU/java-project-78.git
cd java-project-78
make install
```

Создайте JAR-файл командой ```./gradlew jar``` . Обычно, он находится по пути ```("./build/libs")```.  
Скопируйте этот файл в свой проект. Обычно, для этого создается директория ```libs``` в корне проекта.  
Укажите эту зависимость в своем конфигурационном файле. 

- Для `Gradle-Kotlin` build system, добавьте в файл `build.gradle.kts`:
 ```
dependencies {
    implementation(files("libs/имя_файла.jar"))
}
```
- Для `Gradle-Groovy` build system, добавьте в файл `build.gradle`:
```
dependencies {
    implementation files('libs/имя_файла.jar')
}
```
- Для `Maven` build system, добавьте в файл `pom.xml` (код верен, если итоговый JAR-файл у вас называется `app-1.0-SNAPSHOT.jar` и находится в папке `libs` в корне проекта):
```
    <dependencies>
        <dependency>
            <groupId>hexlet.code</groupId> 
            <artifactId>app</artifactId> 
            <version>1.0-SNAPSHOT</version> 
            <scope>system</scope>
            <systemPath>${project.basedir}/libs/app-1.0-SNAPSHOT.jar</systemPath>  <!-- Нужно указать абсолютный путь к подключенному JAR-файлу -->
        </dependency>
    </dependencies>
```


## Как использовать библитотеку ##

- Создайте объект ``` Validator v = new Validator(); ```
- Используйте один из трех методов, чтобы создать объект для валидации определённой схемы   
```var stringValidationObject = v.string()``` - создает объект класса ```StringSchema```, который работает со строками  
```var numberValidationObject = v.number()``` - создает объект класса ```NumberSchema```, который работает с числами  
```var mapValidationObject = v.map()``` - создает объект класса ```MapSchema```, который работает с объектами типа Map 
- Для объектов разных классов, используйте разные методы в качестве "флагов" для валидации значений (__подробнее ниже__)   
- ```isValid(ваш_объект_валидации)``` - метод, одинаковый для объектов всех классов, проверяет валидность переданных данных  

#### Методы("флаги") для валидации строк ####
- ```stringValidationObject.required()``` - делает данные обязательными для заполнения, то есть пустая строка или null не могут быть переданы
- ```stringValidationObject.minLength(Integer ваше_число)``` - вводит минимальную длину переданной строки, строка должна быть равна или больше
- ```stringValidationObject.contains(String ваша_подстрока)``` - переданная подстрока должна содержаться в итоговом объекте валидации  

  #### Методы("флаги") для валидации чисел ####
- ```numberValidationObject.required()``` - делает данные обязательными для заполнения, то есть null не может быть передан
- ```numberValidationObject.positive()``` - вводит ограничение на знак числа - число должно быть только положительным
- ```numberValidationObject.range(Integer нижняя_граница, Integer верхняя_граница)``` - вводит ограничения на диапазон числа - число может находится только в пределах диапазона, в том числа на его границах

  #### Методы("флаги") для валидации объектов типа Map ####
- ```mapValidationObject.required()``` - делает данные обязательными для заполнения, то есть null не может быть передан
- ```mapValidationObject.sizeof(Integer ваш_размер)``` - вводит ограничение на размер объекта типа Map - количество пар "ключ-значение" должно совпадать с переданным значением 
- ```mapValidationObject.shape(Map<String, BaseSchema<String>> ваша_мапа_с_настроенными_схемами_проверки)``` - используется для определения свойств объекта типа Map и создания схемы для валидации их значений. В аргумент этой функции передается объект типа Map, где значениями являются объекты класса ```BaseSchema<String>```(можно сказать ```StringSchema```) -  с настроенными дополнительными проверками.Далее, при передачи в метод ```isValid()``` проверяемых объектов типа Map, будут сравниваться значения по ключам на соотвествие, заданным ранее схемам. 
Ниже пример работы данного метода
```
var v = new Validator();
var schema = v.map();

Map<String, BaseSchema<String>> schemas = new HashMap<>();   // создаем объект для наполнения схемами проверок

schemas.put("firstName", v.string().required());   // добавляем проверки
schemas.put("lastName", v.string().required().minLength(2));

Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
// валидируем
schema.isValid(human1); // true

Map<String, String> human2 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
// валидируем
schema.isValid(human2); // false
```

#### "Флаги" на объектах накапливаются ####
