CREATE TABLE  movie
(
   id INTEGER IDENTITY PRIMARY KEY,
	movie_name_rus VARCHAR(400),
	movie_name_native VARCHAR(400),
	release_date varchar(10),
	storyline VARCHAR(40000),
	rating double precision default 0,
	price double precision default 0,
	poster VARCHAR(4000)
);

create table movie_genre
(
	movie_id integer,
	id_genre integer
)
;

CREATE TABLE  genre
(   id  INTEGER IDENTITY PRIMARY KEY,
	genre VARCHAR(400)
);

create table review
(
	id INTEGER IDENTITY PRIMARY KEY,
	movie_id integer,
	reviewer_id integer,
	review_text varchar(5000)
)
;

create table users
(
	id INTEGER IDENTITY PRIMARY KEY,
	user_name varchar(50),
	user_email varchar(50),
	password varchar(50),
	sole varchar(50),
	user_role varchar(10)
)
;

create table country
(
	id INTEGER IDENTITY PRIMARY KEY,
	name varchar(30)
)
;
create table movie_country
(
	movie_id integer,
	country_id integer
)
;





