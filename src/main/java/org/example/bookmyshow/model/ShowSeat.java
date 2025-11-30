package org.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShowSeat extends BaseModel{

    @ManyToOne
    private Show show;

    @ManyToOne
    private Seat seat;

    private double price;

    @Enumerated
    private ShowSeatStatus showSeatStatus;

}
