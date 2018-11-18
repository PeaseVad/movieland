DROP TABLE movie IF EXISTS;
CREATE TABLE  movie
(
	id  INTEGER IDENTITY PRIMARY KEY,
	movie_name_rus VARCHAR(400),
	movie_name_native VARCHAR(400),
	release_date VARCHAR(400) ,
	rating double precision default 0,
	price double precision default 0,
	poster varchar(4000)
)
;

