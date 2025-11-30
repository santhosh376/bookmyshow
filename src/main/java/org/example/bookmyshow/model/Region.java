package org.example.bookmyshow.model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Region extends BaseModel {
    private String name;
    private double latitude;
    private double longitude;

    @OneToMany(mappedBy = "region")
    private List<Theatre> theatresList;

}
