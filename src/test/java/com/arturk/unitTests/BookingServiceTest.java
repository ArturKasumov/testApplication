package com.arturk.unitTests;

import com.arturk.entity.Tour;
import com.arturk.repository.BookingRepository;
import com.arturk.repository.TourRepository;
import com.arturk.service.BookingService;
import com.arturk.service.TourService;
import com.arturk.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest{

    @Mock
    private BookingRepository bookingRepository;
    @Mock
    private TourService tourService;

    @InjectMocks
    private final BookingService bookingService = new BookingServiceImpl();

    @Test
    public void testSaveBookingService(){
        //given
        Tour tour = new Tour();
        tour.setId(1);
        tour.setAmount(20);
        tour.setName("BestTours");
        //when
        Mockito.when(bookingRepository.findBookingById_TourIdAndId_FullName(anyInt(), anyString())).thenReturn(null);
        Mockito.when(tourService.findById(anyInt())).thenReturn(Optional.of(tour));
        bookingService.saveBooking(1, "Test", 3);
        //then
        Assertions.assertEquals(17, tour.getAmount());
        Mockito.verify(bookingRepository, times(1)).saveBooking(1, "Test", 3);
    }
}
