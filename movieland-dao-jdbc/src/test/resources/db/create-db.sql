CREATE TABLE  movie
(
   id INTEGER IDENTITY PRIMARY KEY,
	movie_name_rus VARCHAR(400),
	movie_name_native VARCHAR(400),
	release_date varchar(10),
	country_group_id INTEGER,
	genre_group_id INTEGER,
	storyline VARCHAR(40000),
	rating double precision default 0,
	price double precision default 0,
	poster VARCHAR(4000)
);
create table  genre_group
(
	id_group integer,
	id_genre integer
);
CREATE TABLE  genre
(   id  INTEGER IDENTITY PRIMARY KEY,
	genre VARCHAR(400)
);