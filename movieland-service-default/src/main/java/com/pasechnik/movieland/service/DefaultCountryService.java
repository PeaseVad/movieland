package com.pasechnik.movieland.service;


import com.pasechnik.movieland.dao.CountryDao;
import com.pasechnik.movieland.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultCountryService implements CountryService {

    private CountryDao countryDao;

    @Autowired
    public DefaultCountryService(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public List<Country> getByMovieId(int id) {
        return countryDao.getByMovieId(id);
    }
}
