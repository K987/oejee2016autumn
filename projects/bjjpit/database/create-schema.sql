CREATE TABLE People(
	people_id INTEGER NOT NULL,
	name varchar(20),
	age INTEGER,
	gender varchar(10),
	rank varchar(20),
	weight INTEGER,
	height INTEGER,
	wins INTEGER,
	losses INTEGER,
	fav_gi varchar(15),
	CONSTRAINT ppl_id PRIMARY KEY (people_id),
	CONSTRAINT favourite_gi_fk FOREIGN KEY (fav_gi) REFERENCES Gi (gi_name)
);
CREATE TABLE Trainingcamp(
	camp_id INTEGER NOT NULL,
	camp_name varchar(25),
	camp_place varchar(40),
	camp_date DATE,
	camp_instructor varchar(20),
	camp_cost NUMBER(5,2),
	CONSTRAINT cmp_id PRIMARY KEY (camp_id),
);
CREATE TABLE Competition(
	competition_id INTEGER NOT NULL,
	competition_name varchar(25),
	competition_place varchar(25),
	competition_date DATE,
	competition_cost(4,2),
	CONSTRAINT cmpttn_id PRIMARY KEY (competition_id)
);
CREATE TABLE Gi(
	gi_id INTEGER NOT NULL,
	gi_name varchar (20),
	gi_origin varchar(15),
	CONSTRAINT g_id PRIMARY KEY (gi_id)
);

