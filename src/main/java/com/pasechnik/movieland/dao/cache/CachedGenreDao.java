package com.pasechnik.movieland.dao.cache;

import com.pasechnik.movieland.dao.GenreDao;
import com.pasechnik.movieland.entity.Genre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class CachedGenreDao implements GenreDao {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private volatile List<Genre> cache;
    private GenreDao genreDao;

    @Autowired
    public CachedGenreDao(@Qualifier("jdbcGenreDao") GenreDao genreDao) {
        this.genreDao = genreDao;
    }

    @Override
    public List<Genre> getAll() {
        return new ArrayList<>(cache);
    }

    @PostConstruct
    @Scheduled(initialDelayString = "${schedule.initial_delay_time}", fixedDelayString = "${schedule.fixed_delay_time}")
    private void refreshCache() {
        cache = genreDao.getAll();
        logger.debug("Refresh for cache was completed, size {} rows", cache.size());
    }
}
