
create table Result (
	lessionId varchar(36) not null,
	personId varchar(36) not null,
	value text,
	createdAt timestamptz,
	resultType varchar(20) CHECK (resultType IN ('LESSON_WORK', 'AUTO_ATTENDANCE'))

);

--drop index Result_UNQ_personId_lessionId;

--CREATE UNIQUE INDEX Result_UNQ_personId_lessionId ON Result (lessionId, personId);
/*
insert into Person (personId, fullName) values ('initialPersonData_1', 'Крузенштерн Иван Фёдорович');

insert into Person (personId, fullName) values ('initialPersonData_2', 'Толстой Лев Николаевич');

insert into Person (personId, fullName) values ('initialPersonData_3', 'Кныш Иван Иванович');


--предметы
insert into Lession (lessionId, lessionName)
values ('initialLesson_1', 'Астрофизика - вводный курс');
insert into Lession (lessionId, lessionName)
values ('initialLesson_2', 'Алгебра и начала анализа');
insert into Lession (lessionId, lessionName)
values ('initialLesson_3', 'Математический анализ');
insert into Lession (lessionId, lessionName)
values ('initialLesson_4', 'Алгоритмы и структуры данных');
insert into Lession (lessionId, lessionName)
values ('initialLesson_5', 'Теория вероятностей');
insert into Lession (lessionId, lessionName)
values ('initialLesson_6', 'Труд');               

--Заявленные ученики
insert into LessionParticipant(lessionId, personId)
values ('initialLesson_1', 'initialPersonData_1');
insert into LessionParticipant(lessionId, personId)
values ('initialLesson_1', 'initialPersonData_2');
insert into LessionParticipant(lessionId, personId)
values ('initialLesson_1', 'initialPersonData_3');

insert into LessionParticipant(lessionId, personId)
values ('initialLesson_2', 'initialPersonData_1');

*/

select * from Result;

insert into Result (lessionId, personId, value, createdAt, resultType) values ('initialLesson_1', 'initialPersonData_1', NULL,  timestamp '2020-01-15 09:00:00', 'AUTO_ATTENDANCE' );
insert into Result (lessionId, personId, value, createdAt, resultType) values ('initialLesson_1', 'initialPersonData_2', NULL,  timestamp '2020-01-15 09:00:00', 'AUTO_ATTENDANCE' );
insert into Result (lessionId, personId, value, createdAt, resultType) values ('initialLesson_1', 'initialPersonData_3', NULL,  timestamp '2020-01-15 09:00:00', 'AUTO_ATTENDANCE' );

insert into Result (lessionId, personId, value, createdAt, resultType) values ('initialLesson_1', 'initialPersonData_1', 'зач.',  timestamp '2020-01-15 09:15:00', 'LESSON_WORK' );

insert into Result (lessionId, personId, value, createdAt, resultType) values ('initialLesson_2', 'initialPersonData_1', NULL,  timestamp '2020-01-16 09:00:00', 'AUTO_ATTENDANCE' );
insert into Result (lessionId, personId, value, createdAt, resultType) values ('initialLesson_2', 'initialPersonData_1', '5',  timestamp '2020-01-25 09:15:00', 'LESSON_WORK' );

