create table personal(
	persID int IDENTITY(1,1) primary key,
	fNamn nvarchar(255) not null,
	eNamn nvarchar(255) not null,
	antalArenden int not null default(0)
)
go

insert into personal(fNamn,eNamn)
values ('Richard','Johansson'),('Kent','Tatch-Dis'),('Lou','Leo')
go

create table arende(
	arendeID int IDENTITY(1,1) PRIMARY KEY,
	status nvarchar(255) not null default('Registrerad'),
	budgetTid numeric(5,2) not null default(0.00),
	tidsAtgang numeric(5,2) not null default (0.00),
	rubrik nvarchar (255) not null,
	beskrivning nvarchar(500) null,
	prio int not null default(3),
	registrerad datetime not null default(GETDATE()),
	SLA datetime not null default(DATEADD(day,2,GETDATE())),
	oppnad datetime null,
	stangd datetime null,
	losning nvarchar(500) null
)
go

insert into arende(rubrik)
values('Testärende1'),('Testärende2')

create table arendeuppgift(
	arendeuppgiftID int IDENTITY(1,1) PRIMARY KEY,
	arendeID int null,
	status nvarchar(255) not null default('Ej påbörjad'),
	budgetTid numeric(5,2) not null default(0.00),
	tidsAtgang numeric(5,2) not null default (0.00),
	arbetsuppgift nvarchar (255) not null,
	kompetenskrav nvarchar(255) not null,
	beskrivning nvarchar(500) null,
	registrerad datetime not null default(GETDATE()),
	oppnad datetime null,
	stangd datetime null,
	kommentar nvarchar(500) null
)
go

insert into arendeuppgift(arendeID,arbetsuppgift,kompetenskrav)
values(1,'Installation mjukvara','Mjukvara'),(2,'Klientinstallation OS','Operativsystem'),(2,'Installation mjukvara','Mjukvara')

