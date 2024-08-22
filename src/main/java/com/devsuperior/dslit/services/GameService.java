package com.devsuperior.dslit.services;

import com.devsuperior.dslit.dto.GameDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<GameDTO> findAll() {
        List<Game> res = repository.findAll();
        return res.stream().map(GameDTO::new).toList();
    }
}
