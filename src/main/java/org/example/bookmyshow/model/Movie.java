package org.example.bookmyshow.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.List;

@Entity(name = "movies")
public class Movie {
    @Id
    private Long id;
    private String name;
    private String language;

    @Column(nullable = true)
    private double rating;
    private String category;
    private int duration;
}
