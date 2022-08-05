# ProductListApplication
Описание проекта

ProductListApplication - это учебный проект на Spring Boot. БД - PostgreSQL. <br> Взаимодействие приложения с БД через Spring Data JPA / Hibernate. 
<br> Подключен `Liquibase` для удобства контроля версий БД.
<br> Маппинг сущностей выполняется через `MapStruct`.
<br> Валидация на spring-boot-starter-validation.
<br> В проекте также используется `Lombok` для упрощения процесса разработки и снижения количества кода.
<br> Настройки приложения в файле `src/main/resources/application.yaml`.
<br> Ключевые места бизнес-логики покрыты тестами.
Порт приложения: 8080.

Приложение упаковано в докер-контейнер. 
При запуске контейнера БД заполняется тестовыми данными (`src/main/resources/db/changelog/2022/08/data.sql`), можно выполнять запросы.

Подключен `Swagger`, подробная документация по эндпоинтам:
http://localhost:8080/swagger-ui/

Также можно открыть в файле `swagger.json` в корне проекта

Скрипты для запуска приложения и БД:
```
docker network create my-network
docker run --network=my-network --name postgres -e POSTGRES_DB=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -p 5435:5432 -d postgres
docker run --network=my-network --rm -p 8080:8080 -e DATABASE_URL=postgresql://postgres:5432/postgres alex90bar/product-list:latest

```



Список эндпоинтов:

| Endpoint       |  Description   |  JSON Body    |
| :---          |           ---:   | ---: |
| http://localhost:8080/api/list  | Получение всех существующих List, включая список всех Product по каждому List, и суммарное количество kcal по каждому List, запрос GET в формате JSON:  |  Не требуется  |
| http://localhost:8080/api/list  | Создание нового List в БД, проверяет на наличие по названию, запрос POST в формате JSON: | ```{  "name": "Закуски"}```      |
| http://localhost:8080/api/product | Получение всех существующих продукт, запрос GET в формате JSON: | Не требуется |
| http://localhost:8080/api/product  |  Создание нового Product в БД, проверяет на наличие по названию, запрос POST в формате JSON:  |```{ "description": "Урожай - лето 2022, Воронежская область. Нежный, рассыпчатый", "kcal": 148, "name": "Картофель молодой"}``` |
| http://localhost:8080/api/product  |  Помещает выбранный Product в существующий List, проверяет на наличие по названию, проверяет на наличие в List, запрос PUT в формате JSON:  |```{ "listName": "Закуски", "productName": "Картофель молодой" }``` |
