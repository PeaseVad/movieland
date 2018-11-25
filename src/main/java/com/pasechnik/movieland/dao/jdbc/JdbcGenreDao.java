package com.pasechnik.movieland.dao.jdbc;

import com.pasechnik.movieland.dao.GenreDao;
import com.pasechnik.movieland.dao.jdbc.mapper.GenreRowMapper;
import com.pasechnik.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("jdbcGenreDao")
public class JdbcGenreDao implements GenreDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final GenreRowMapper GENRE_ROW_MAPPER = new GenreRowMapper();
    private JdbcTemplate jdbcTemplate;
    private String getAllGenresSQL;

    @Override
    public List<Genre> getAll() {
        logger.debug("GetAll from JdbcGenreDao");
        return jdbcTemplate.query(getAllGenresSQL,GENRE_ROW_MAPPER);
    }

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setGetAllGenresSQL(String getAllGenresSQL) {
        this.getAllGenresSQL = getAllGenresSQL;
    }
}
