package com.pasechnik.movieland.service;

import com.pasechnik.movieland.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getByMovieId(int id);
}
