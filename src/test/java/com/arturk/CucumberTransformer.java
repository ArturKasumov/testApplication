package com.arturk;

import com.arturk.dto.BookingDto;
import com.arturk.dto.TourDto;
import com.arturk.dto.TravelAgencyDto;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CucumberTransformer {

    @DataTableType
    public TravelAgencyDto travelAgencyDto(Map<String, String> row){
        return new TravelAgencyDto(
                row.get("id") == null ? null : Integer.valueOf(row.get("id")),
                row.get("name"),
                row.get("description")
        );
    }

    @DataTableType
    public TourDto tourDto(Map<String, String> row){
        return new TourDto(
                row.get("id") == null ? null : Integer.valueOf(row.get("id")),
                row.get("name"),
                row.get("country"),
                Integer.valueOf(row.get("amount"))
        );
    }

    @DataTableType
    public BookingDto bookingDto(Map<String, String> row){
        return new BookingDto(
                row.get("fullName"),
                Integer.valueOf(row.get("amountReservedPlaces"))
        );
    }
}
