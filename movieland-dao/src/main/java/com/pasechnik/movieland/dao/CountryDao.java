package com.pasechnik.movieland.dao;

import com.pasechnik.movieland.entity.Country;

import java.util.List;

public interface CountryDao {
    List<Country> getByMovieId(int id);
}
