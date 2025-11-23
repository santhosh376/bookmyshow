package org.example.bookmyshow.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "movies")
public class Movie extends BaseModel {

    private String name;
    private String language;

    @Column(nullable = true)
    private double rating;
    private String category;
    private int duration;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", rating=" + rating +
                ", category='" + category + '\'' +
                ", duration=" + duration +
                '}';
    }
}
