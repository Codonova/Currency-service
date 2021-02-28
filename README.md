# Сервис мониторинга валюты     

## Описание    

## Сборка

```sh
gradlew clean build
```

## Конфигурация

Все настройки по умолчанию находятся в файлах:
- `src/main/resources/application.properties`  

Для локальной разработки создать конфигурационный файл `src/main/resources/application-local.properties`  
   (пример файла можно взять из `env/application-local-sample.properties`).
   
_Примечание_

* Файл `src/main/resources/application-local.properties` явно добавлен в `.gitignore`, его не нужно сохранять в
репозиторий разработки
* Перечень всех доступных параметров [common-application-properties](https://docs.spring.io/spring-boot/docs/2.1.1.RELEASE/reference/htmlsingle/#common-application-properties)

## Профили запуска
 
### **local** - локальная разработка
 
IDEA:

1. В IDEA создать `Edit configuration -> Spring Boot`.
2. В поле **Main class:**  установить `Application`.
3. В поле **VM Options** задать `-Dspring.profiles.active=local`, либо **Program arguments** задать `--spring.profiles.active=local`,     
   либо **Enviroment variables** задать `SPRING_PROFILES_ACTIVE=local`.
4. В поле **Use classpath module** `выбрать currency-service_main`.
5. Запустить приложение через интерфейс IDEA.
     
Консоль:     

```
gradlew bootRun -Dspring.profiles.active=local  
```

_Примечание_

В файле `application-local.properties` можно переопределить любой параметр, установленный по молчанию в файле
`src/main/resources/application.properties`.
   
## Описание структуры

* **env** - настройка окружения запуска приложения 
* **src/main/resources/application.properties** - настройка сервиса по умолчанию   