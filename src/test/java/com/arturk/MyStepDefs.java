package com.arturk;

import com.arturk.dto.BookingDto;
import com.arturk.dto.TourDto;
import com.arturk.dto.TravelAgencyDto;
import com.arturk.entity.Booking;
import com.arturk.entity.BookingId;
import com.arturk.entity.Tour;
import com.arturk.entity.TravelAgency;
import com.arturk.repository.BookingRepository;
import com.arturk.repository.TravelAgencyRepository;
import com.arturk.service.BookingService;
import com.arturk.testRepository.TestTourRepository;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
public class MyStepDefs {

    @Autowired
    private TravelAgencyRepository travelAgencyRepository;
    @Autowired
    private TestTourRepository tourRepository;
    @Autowired
    private BookingService bookingService;

    @When("travelAgency {} exists")
    public void travelAgencyExists(String key, TravelAgencyDto travelAgencyDto) {
        TravelAgency travelAgency = new TravelAgency();
        travelAgency.setName(travelAgencyDto.getName());
        travelAgency.setDescription(travelAgencyDto.getDescription());
        IntegrationTestHelper.getTestContext().getTravelAgencyCache().put(key, travelAgency);
    }

    @Then("travelAgency is in database")
    public void tourAgencyIsInDatabase(TravelAgencyDto travelAgencyDto) {
        TravelAgency travelAgency = travelAgencyRepository.findByName(travelAgencyDto.getName());
        assertNotNull(travelAgency);
        assertEquals(travelAgency.getName(), travelAgencyDto.getName());
        assertEquals(travelAgency.getDescription(), travelAgencyDto.getDescription());
    }

    @And("tour {} with travelAgency {} exists")
    public void tourExists(String keyTour, String keyTravelAgency, TourDto tourDto) {
        Tour tour = new Tour();
        tour.setCountry(tourDto.getCountry());
        tour.setName(tourDto.getName());
        tour.setAmount(tourDto.getAmount());
        tour.setTravelAgency(IntegrationTestHelper.getTestContext().getTravelAgencyCache().get(keyTravelAgency));
        tourRepository.save(tour);
        IntegrationTestHelper.getTestContext().getTourCache().put(keyTour, tour);
    }

    @And("tour is in database")
    @Transactional
    public void tourIsInDatabase(TourDto tourDto) {
        Tour tour = tourRepository.findByName(tourDto.getName());
        assertNotNull(tour);
        assertEquals(tour.getName(), tourDto.getName());
        assertEquals(tour.getCountry(), tourDto.getCountry());
        assertEquals(tour.getAmount(), tourDto.getAmount());
    }

    @And("booking exists with tour {}")
    public void bookingExistsWithTour(String keyTour, BookingDto bookingDto) {
        Tour tour = IntegrationTestHelper.getTestContext().getTourCache().get(keyTour);
        bookingService.saveBooking(tour.getId(), bookingDto.getFullName(), bookingDto.getAmountReservedPlaces());
    }
}