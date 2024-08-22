package com.devsuperior.dslit.controllers;

import com.devsuperior.dslit.dto.GameDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<GameDTO> findAll() {
        return this.service.findAll();
    }
}
