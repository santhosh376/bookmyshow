package org.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "movie_show")
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Screen screen;

    private Date startTime;
    private Date endTime;

}
