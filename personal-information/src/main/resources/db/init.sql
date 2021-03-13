create table Person (
	personId varchar(36) not null,
	fullName text

);

CREATE UNIQUE INDEX Person_UNQ_personId ON Person (personId);

insert into Person (personId, fullName) values ('initialPersonData_1', 'Крузенштерн Иван Фёдорович');

insert into Person (personId, fullName) values ('initialPersonData_2', 'Толстой Лев Николаевич');

insert into Person (personId, fullName) values ('initialPersonData_3', 'Кныш Иван Иванович');