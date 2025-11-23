package org.example.bookmyshow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    @Column(name = "seat_number")
    private int number;
    private char rowNum;
    private int colNum;

    @Enumerated
    private SeatType seatType;

    @ManyToOne
    private Screen screen;
}
