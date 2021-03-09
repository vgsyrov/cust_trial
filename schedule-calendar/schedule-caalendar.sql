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

CREATE UNIQUE INDEX Event_UNQ_personId_lessionId ON Event (eventId, lessionId);

CREATE UNIQUE INDEX EventAttendanceFact_UNQ_personId_lessionId ON EventAttendanceFact (eventId, personId);