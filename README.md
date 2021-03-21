Демонстрационный проект: "Backend REST API"
==============================

Запуск проекта:<br/>

       `start_trial.sh`

Swagger doc UI:<br/>

        http://localhost:8080/swagger-ui/<br/>

Сервис выборки списка оценок и посещения:<br/>
       http://localhost:8080/eventResults/{id}<br/>
, где id - это требуемое событие.

В тестовых данных возможные значния:<br/>
   initialEvent_1 - initialEvent_6<br/>
   initialEvent_11 - initialEvent_16<br/>


Сервис простановки автобалла: http://localhost:8080/auto-attendance/body<br/>
Параметры передаются в теле запроса в виде:<br/>
{<br/>
  "attendanceFact": "string" - значение П/Н - присутствовал/отсутствовал<br/>
  "eventId": "string",       - ID мероприятия http://localhost:8086/list<br/>
  "personId": "string"       - ID физического лица http://localhost:8083/list<br/>
}<br/>



Сервис успеваемости (academic-performance): отвечает за хранение и работу с оценками студенту за занятие.<br/>

Сервис планирования учебного периода (period-planning): отвечает за работу с перечнем учебных занятий и списками участников занятий.<br/>

Сервис расписания (schedule-calendar), который отвечает за работу с мероприятиями, проводящимися по занятиям и фактами посещения мероприятий.<br/>

Сервис персональных данных (personal-information), в котором хранятся ФИО и другая персональная информация студентов.<br/>

Координационный сервис results-control-api-gateway, который будет предоставлять единый API для управления оценками и посещаемостью. У него нет своей БД, его работа – выполнить оркестрацию вызовов сервисов и предоставить API для frontend.<br/>

