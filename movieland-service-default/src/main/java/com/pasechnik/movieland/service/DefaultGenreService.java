package com.pasechnik.movieland.service;


import com.pasechnik.movieland.dao.GenreDao;
import com.pasechnik.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultGenreService implements GenreService {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    private GenreDao genreDao;

    @Autowired
    public DefaultGenreService(GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> genreList = genreDao.getAll();
        logger.debug("Returned {} rows", genreList.size());
        return genreList;
    }

    @Override
    public List<Genre> getByMovieId(int id) {
        List<Genre> genreList = genreDao.getByMovieId(id);
        logger.debug("Returned {} rows", genreList.size());
        return genreList;
    }
}
