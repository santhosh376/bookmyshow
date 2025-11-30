package org.example.bookmyshow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Theatre extends BaseModel{
    private String address;
    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;
}
