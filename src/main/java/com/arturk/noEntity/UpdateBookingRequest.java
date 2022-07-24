package com.arturk.noEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateBookingRequest {
    private Integer tourId;
    private String fullName;
    private Integer newAmountReservedPlaces;
}
