package com.devsuperior.dslit.controllers;

import com.devsuperior.dslit.dto.GameListResponseDTO;
import com.devsuperior.dslit.dto.GameResponseDTO;
import com.devsuperior.dslit.services.GameListService;
import com.devsuperior.dslit.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService service;

    @Autowired
    private GameService gameService;


    @GetMapping(value = "/{id}")
    public GameListResponseDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping
    public List<GameListResponseDTO> findAll() {
        return this.service.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameResponseDTO> findByList(@PathVariable Long listId) {
        return this.gameService.findByList(listId);
    }
}
