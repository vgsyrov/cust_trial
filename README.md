Тестовый проект

Сервис успеваемости (academic-performance), отвечающий за хранение и работу с оценками студенту за занятие.
Сервис планирования учебного периода (period-planning): отвечает за работу с перечнем учебных занятий и списками участников занятий
Сервис расписания (schedule-calendar), который отвечает за работу с мероприятиями, проводящимися по занятиям и фактами посещения мероприятий
Сервис персональных данных (personal-information), в котором хранятся ФИО и другая персональная информация студентов.
Координационный сервис results-control-api-gateway, который будет предоставлять единый API для управления оценками и посещаемостью. У него нет своей БД, его работа – выполнить оркестрацию вызовов сервисов и предоставить API для frontend.

т
