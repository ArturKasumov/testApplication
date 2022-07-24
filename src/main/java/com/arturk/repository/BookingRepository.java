package com.arturk.repository;

import com.arturk.entity.Booking;
import com.arturk.entity.BookingId;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends CrudRepository<Booking, BookingId> {

    @Modifying
    @Query(nativeQuery = true, value = "insert into booking (tour_id, full_name, amount_reserved_places) values (:tourId, :fullName, :amountReservedPlaces)")
    void saveBooking(@Param("tourId") Integer tourId, @Param("fullName") String fullName, @Param("amountReservedPlaces") Integer amountReservedPlaces);

    void deleteById_TourIdAndId_FullName(Integer tourId, String fullName);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE booking SET amount_reserved_places = :newAmountReservedPlaces where tour_id = :tourId and full_name = :fullName")
    void updateBookingByTourIdAndFullName(@Param("tourId") Integer tourId, @Param("fullName") String fullName, @Param("newAmountReservedPlaces") Integer newAmountReservedPlaces);

    List<Booking> findBookingById_FullName(String fullName);

    Booking findBookingById_TourIdAndId_FullName(Integer tourId, String fullName);
}
