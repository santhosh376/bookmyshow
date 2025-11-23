package org.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Booking extends BaseModel {

    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> showSeatList;

    private Date bookedAt;

    @ManyToOne
    private Show show;

    private double amount;

}
