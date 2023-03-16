#Стек
- Java
- TestNG
- Rest Assured

***
#Первый запуск тестов
1. Установить SDK
2. Установить Maven
3. Запусть тесты командой
- _**mvn -Papi clean test**_ 
- для запуска конкретного класса _*mvn test -Dtest=classname*_
- для запуска конкретного .xml mvn clean test -P api -Dsurefire.suiteXmlFiles=ssl1.xml
