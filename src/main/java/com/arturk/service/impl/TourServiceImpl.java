package com.arturk.service.impl;

import com.arturk.entity.Tour;
import com.arturk.repository.TourRepository;
import com.arturk.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TourServiceImpl implements TourService {

    @Autowired
    private TourRepository tourRepository;

    @Override
    public List<Tour> findAllByCountry(String country) {
        return tourRepository.findAllByCountry(country);
    }

    @Override
    public List<Tour> findAllByAmountGreaterThanEqual(Integer amount) {
        return tourRepository.findAllByAmountGreaterThanEqual(amount);
    }

    @Override
    public List<Tour> findAllByAmountIsBetween(Integer min, Integer max) {
        return tourRepository.findAllByAmountIsBetween(min, max);
    }

    public Optional<Tour> findById(Integer id) {
        return tourRepository.findById(id);
    }

    @Override
    public Tour save(Tour tour) {
        return tourRepository.save(tour);
    }

}
