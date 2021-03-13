
create table Lession (
	lessionId varchar(36) not null,
	lessionName text not null
);


CREATE UNIQUE INDEX Lession_UNQ_lessionId ON Lession (lessionId);

create table LessionParticipant (
	lessionId varchar(36) not null,
	personId varchar(36) not null
);


CREATE UNIQUE INDEX LessionParticipant_UNQ_lessionId_personId ON LessionParticipant (lessionId, personId);

--предметы
insert into Lession (lessionId, lessionName) values ('initialLesson_1', 'Астрофизика - вводный курс');
insert into Lession (lessionId, lessionName) values ('initialLesson_2', 'Алгебра и начала анализа');
insert into Lession (lessionId, lessionName) values ('initialLesson_3', 'Математический анализ');
insert into Lession (lessionId, lessionName) values ('initialLesson_4', 'Алгоритмы и структуры данных');
insert into Lession (lessionId, lessionName) values ('initialLesson_5', 'Теория вероятностей');
insert into Lession (lessionId, lessionName) values ('initialLesson_6', 'Труд');

--Заявленные ученики
insert into LessionParticipant(lessionId, personId) values('initialLesson_1', 'initialPersonData_1');
insert into LessionParticipant(lessionId, personId) values('initialLesson_1', 'initialPersonData_2');
insert into LessionParticipant(lessionId, personId) values('initialLesson_1', 'initialPersonData_3');

insert into LessionParticipant(lessionId, personId) values('initialLesson_2', 'initialPersonData_1');

insert into LessionParticipant(lessionId, personId) values('initialLesson_6', 'initialPersonData_1');
insert into LessionParticipant(lessionId, personId) values('initialLesson_6', 'initialPersonData_2');
insert into LessionParticipant(lessionId, personId) values('initialLesson_6', 'initialPersonData_3');