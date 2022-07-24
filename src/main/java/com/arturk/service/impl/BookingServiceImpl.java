package com.arturk.service.impl;

import com.arturk.entity.Booking;
import com.arturk.entity.Tour;
import com.arturk.repository.BookingRepository;
import com.arturk.service.BookingService;
import com.arturk.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TourService tourService;

    @Override
    @Transactional
    public void deleteByTourIdAndFullName(Integer tourId, String fullName) {
        bookingRepository.deleteById_TourIdAndId_FullName(tourId, fullName);
    }

    @Override
    @Transactional
    public void updateBookingByTourIdAndFullName(Integer tourId, String fullName, Integer newAmountReservedPlaces) {
        bookingRepository.updateBookingByTourIdAndFullName(tourId, fullName, newAmountReservedPlaces);
    }

    @Override
    public List<Booking> findBookingByFullName(String fullName) {
        return bookingRepository.findBookingById_FullName(fullName);
    }

    @Override
    @Transactional
    public void saveBooking(Integer tourId, String fullName, Integer amountReservedPlaces){
        Booking booking = bookingRepository.findBookingById_TourIdAndId_FullName(tourId, fullName);
        Optional<Tour> tourOptional = tourService.findById(tourId);
        if(tourOptional.isPresent() && booking == null) {
            Tour tour = tourOptional.get();
            tour.setAmount(tour.getAmount() - amountReservedPlaces);
            tourService.save(tour);
            bookingRepository.saveBooking(tourId, fullName, amountReservedPlaces);
        } else {
            throw new RuntimeException("Booking already exists or Tour does not exists");
        }
    }
}


