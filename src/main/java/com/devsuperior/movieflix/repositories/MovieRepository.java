package com.devsuperior.movieflix.repositories;

import com.devsuperior.movieflix.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("select m from Movie m where (:id IS NULL or m.genre.id = :id) ORDER BY m.title")
    Page<Movie> findByGenre_Id( Long id, Pageable pageable);


}
