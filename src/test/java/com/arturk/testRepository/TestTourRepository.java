package com.arturk.testRepository;

import com.arturk.entity.Tour;
import com.arturk.repository.TourRepository;

public interface TestTourRepository extends TourRepository {

    Tour findByName(String name);
}
