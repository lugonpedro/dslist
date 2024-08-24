package com.devsuperior.dslist.controllers;

import com.devsuperior.dslist.dto.GameResponseDTO;
import com.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

//    public GameDTO create() {
//        this.service.
//    }

    @GetMapping(value = "/{id}")
    public GameResponseDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping
    public List<GameResponseDTO> findAll() {
        return this.service.findAll();
    }
}
