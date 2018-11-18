CREATE TABLE IF NOT EXISTS movie
(
	id  INTEGER IDENTITY PRIMARY KEY,
	movie_name_rus VARCHAR(400),
	movie_name_native VARCHAR(400),
	release_date INTEGER ,
	country VARCHAR(50),
	rating double precision default 0,
	price double precision default 0,
	poster varchar(4000)
)
;

