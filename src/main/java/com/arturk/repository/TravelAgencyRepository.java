package com.arturk.repository;

import com.arturk.entity.TravelAgency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelAgencyRepository extends CrudRepository<TravelAgency, Integer> {

    TravelAgency findByName(String name);
}
