package org.example.bookmyshow.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Builder
public class BookTicketResponseDto {
    private Long bookingId;
    private double amount;
    private List<Integer> seatNumbers;
    private String theatreName;
}

