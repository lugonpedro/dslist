package com.devsuperior.dslit.controllers;

import com.devsuperior.dslit.dto.GameListResponseDTO;
import com.devsuperior.dslit.services.GameListService;
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


    @GetMapping(value = "/{id}")
    public GameListResponseDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @GetMapping
    public List<GameListResponseDTO> findAll() {
        return this.service.findAll();
    }
}
