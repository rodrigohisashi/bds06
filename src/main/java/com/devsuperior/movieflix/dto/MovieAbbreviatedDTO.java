package com.devsuperior.movieflix.dto;

import lombok.Data;

@Data
public class MovieAbbreviatedDTO {
    private Long id;
    private String title;
    private String subTitle;
    private Integer year;
    private String imgUrl;
}
