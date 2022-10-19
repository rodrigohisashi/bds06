package com.devsuperior.movieflix.dto;

import lombok.Data;

@Data
public class MovieAllDetailsDTO extends MovieAbbreviatedDTO {

    private String synopsis;
    private GenreDTO genre;
}
