package com.devsuperior.movieflix.services.domain;

import com.devsuperior.movieflix.dto.GenreDTO;
import com.devsuperior.movieflix.mappers.GenreMapper;
import com.devsuperior.movieflix.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository repository;


    @Transactional(readOnly = true)
    public List<GenreDTO> findGenres() {
        return repository.findAll().stream().map(GenreMapper.INSTANCE::genreToGenreDTO).toList();
    }
}
