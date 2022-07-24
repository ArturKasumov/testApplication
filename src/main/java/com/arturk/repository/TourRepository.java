package com.arturk.repository;

import com.arturk.entity.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends CrudRepository<Tour, Integer> {

    List<Tour> findAllByCountry(String country);
    List<Tour> findAllByAmountGreaterThanEqual(Integer amount);
    List<Tour> findAllByAmountIsBetween(Integer min, Integer max);
}
