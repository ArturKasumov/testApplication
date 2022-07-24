package com.arturk.controller;

import com.arturk.entity.Booking;
import com.arturk.noEntity.UpdateBookingRequest;
import com.arturk.service.BookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/booking")
public class BookingController {
    private final Logger log = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    private BookingService bookingService;

    @RequestMapping(value = "/delete/{id}/{fullName}", method = RequestMethod.POST)
    public void deleteByTourIdAndFullName(@PathVariable("id") Integer tourId, @PathVariable("fullName") String fullName) {
        bookingService.deleteByTourIdAndFullName(tourId, fullName);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateBookingByTourIdAndFullName(@RequestBody UpdateBookingRequest request) {
        log.info("updating booking");
        bookingService.updateBookingByTourIdAndFullName(request.getTourId(), request.getFullName(), request.getNewAmountReservedPlaces());
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public List<Booking> findBookingByFullName(@RequestParam String fullName) {
        return bookingService.findBookingByFullName(fullName);
    }

    @RequestMapping(value = "/save/{tourId}/{fullName}/{amountReservedPlaces}", method = RequestMethod.POST)
    public void saveBooking(@PathVariable Integer tourId, @PathVariable String fullName, @PathVariable Integer amountReservedPlaces){
        bookingService.saveBooking(tourId, fullName, amountReservedPlaces);
    }

    @RequestMapping(value = "/text", method = RequestMethod.GET)
    @ResponseBody
    public String text(){
        return "Hello, it is booking";
    }
}
