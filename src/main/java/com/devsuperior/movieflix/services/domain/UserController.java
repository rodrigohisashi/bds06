package com.devsuperior.movieflix.services.domain;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.services.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/profile")
    public ResponseEntity<UserDTO> getMyProfile() {
        return(ResponseEntity.ok().body(service.getMyProfile()));

    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Void> findById(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }
}
