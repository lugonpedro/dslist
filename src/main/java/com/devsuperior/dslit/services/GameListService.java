package com.devsuperior.dslit.services;


import com.devsuperior.dslit.dto.GameListResponseDTO;
import com.devsuperior.dslit.entities.GameList;
import com.devsuperior.dslit.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    public GameListResponseDTO findById(Long id) {
        GameList res = repository.findById(id).orElseThrow(() -> new RuntimeException("Game List not found"));
        return new GameListResponseDTO(res);
    }

    public List<GameListResponseDTO> findAll() {
        List<GameList> res = repository.findAll();
        return res.stream().map(GameListResponseDTO::new).toList();
    }
}
