package com.arturk.service;

import com.arturk.entity.Tour;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<Tour> findAllByCountry(String country);
    List<Tour> findAllByAmountGreaterThanEqual(Integer amount);
    List<Tour> findAllByAmountIsBetween(Integer min, Integer max);
    Optional<Tour> findById(Integer tourId);
    Tour save(Tour tour);
}
