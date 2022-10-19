package com.devsuperior.movieflix.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ReviewDTO {

    private Long id;
    @NotBlank(message = "Não é permitido texto vazio na avaliação!")
    private String text;
    private UserDTO user;
    private Long movieId;

}
