
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