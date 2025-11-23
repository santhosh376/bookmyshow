package org.example.bookmyshow.repository;

import org.example.bookmyshow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findMovieByName(String name);

    Optional<Movie> findMovieByNameAndCategory(String name, String category);

    @Query("SELECT m from movies m where m.id = 1")
    List<Movie> findRandomMovie();
}
