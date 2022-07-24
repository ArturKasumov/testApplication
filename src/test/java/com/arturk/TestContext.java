package com.arturk;

import com.arturk.entity.Tour;
import com.arturk.entity.TravelAgency;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class TestContext {

    @Setter(AccessLevel.NONE)
    private Map<String, TravelAgency> travelAgencyCache = new HashMap<>();

    @Setter(AccessLevel.NONE)
    private Map<String, Tour> tourCache = new HashMap<>();
}
