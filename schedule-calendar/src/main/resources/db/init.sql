create table Event (
	eventId varchar(36) not null,
	lessionId varchar(36) not null,
	startAt timestamptz not null
);

create table EventAttendanceFact (
	eventId varchar(36) not null,
	personId varchar(36) not null,
	attendanceFact varchar(7) null CHECK (attendanceFact IN ('PRESENT', 'ABSENT') OR attendanceFact IS NULL)
);

CREATE UNIQUE INDEX Event_UNQ_personId_lessionId ON Event (eventId);

CREATE UNIQUE INDEX EventAttendanceFact_UNQ_personId_lessionId ON EventAttendanceFact (eventId, personId);


insert into Event (eventId, lessionId, startAt) values ('initialEvent_1', 'initialLesson_1', timestamp '2020-02-15 09:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_2', 'initialLesson_2', timestamp '2020-02-15 10:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_3', 'initialLesson_3', timestamp '2020-02-15 11:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_4', 'initialLesson_4', timestamp '2020-02-15 12:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_5', 'initialLesson_5', timestamp '2020-02-15 14:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_6', 'initialLesson_6', timestamp '2020-02-15 15:00:00');

insert into Event (eventId, lessionId, startAt) values ('initialEvent_11', 'initialLesson_1', timestamp '2020-02-16 09:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_12', 'initialLesson_2', timestamp '2020-02-16 10:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_13', 'initialLesson_3', timestamp '2020-02-16 11:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_14', 'initialLesson_4', timestamp '2020-02-16 12:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_15', 'initialLesson_5', timestamp '2020-02-16 14:00:00');
insert into Event (eventId, lessionId, startAt) values ('initialEvent_16', 'initialLesson_6', timestamp '2020-02-16 15:00:00');

select * from eventattendancefact;

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_1', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_1', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_1', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_2', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_2', 'initialPersonData_2');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_3', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_3', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_3', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_4', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_4', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_4', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_5', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_5', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_5', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_6', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_6', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_6', 'initialPersonData_3');


INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_11', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_11', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_12', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_12', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_12', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_13', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_13', 'initialPersonData_2');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_14', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_14', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_15', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_15', 'initialPersonData_3');

INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_16', 'initialPersonData_1');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_16', 'initialPersonData_2');
INSERT INTO eventattendancefact (eventId, personId) values ('initialEvent_16', 'initialPersonData_3');
