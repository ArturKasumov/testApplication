package com.arturk.service;

import com.arturk.entity.Booking;

import java.util.List;

public interface BookingService {
    void deleteByTourIdAndFullName(Integer tourId, String fullName);
    void updateBookingByTourIdAndFullName(Integer tourId, String fullName, Integer newAmountReservedPlaces);
    List<Booking> findBookingByFullName(String fullName);
    void saveBooking(Integer tourId, String fullName, Integer amountReservedPlaces);
}
