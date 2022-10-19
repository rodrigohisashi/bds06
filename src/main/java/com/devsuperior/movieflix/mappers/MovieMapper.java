package com.devsuperior.movieflix.mappers;

import com.devsuperior.movieflix.dto.MovieAbbreviatedDTO;
import com.devsuperior.movieflix.dto.MovieAllDetailsDTO;
import com.devsuperior.movieflix.entities.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovieMapper {

    MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    MovieAllDetailsDTO movieToMovieDTO(Movie movie);

    MovieAbbreviatedDTO movieAbbreviatedToMovieDTO(Movie movie);


}
