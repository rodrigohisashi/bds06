package com.devsuperior.movieflix.services.domain;

import com.devsuperior.movieflix.dto.MovieAbbreviatedDTO;
import com.devsuperior.movieflix.dto.MovieAllDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.mappers.MovieMapper;
import com.devsuperior.movieflix.mappers.ReviewMapper;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Transactional(readOnly = true)
    public MovieAllDetailsDTO findById(Long id) {
        return MovieMapper.INSTANCE.movieToMovieDTO( repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity not found")));
    }

    @Transactional(readOnly = true)
    public List<ReviewDTO> findReviews(Long id) {
        List<Review> obj = reviewRepository.findByMovie_Id(id);
        return obj.stream().map(ReviewMapper.INSTANCE::reviewToReviewDTO).toList();
    }

    @Transactional(readOnly = true)
    public Page<MovieAbbreviatedDTO> findAllMovies(Pageable pageable, Long idGenre) {
        Page<Movie> obj = repository.findByGenre_Id(idGenre, pageable);
        return obj.map(MovieMapper.INSTANCE::movieAbbreviatedToMovieDTO);
    }



}
