create table Result (
	lessionId varchar(36) not null,
	personId varchar(36) not null,
	value text,
	createdAd timestamptz,
	resultType varchar(20) CHECK (resultType IN ('LESSON_WORK', 'AUTO_ATTENDANCE'))

);

CREATE UNIQUE INDEX Result_UNQ_personId_lessionId ON Result (lessionId, personId);