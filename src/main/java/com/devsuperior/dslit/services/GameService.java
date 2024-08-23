package com.devsuperior.dslit.services;

import com.devsuperior.dslit.dto.GameRequestDTO;
import com.devsuperior.dslit.dto.GameResponseDTO;
import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.projections.GameMinProjection;
import com.devsuperior.dslit.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

//    public GameDTO create(GameRequestDTO body) {
//        Game game = new Game(body);
//        repository.save(game);
//        return Game;
//    }

    @Transactional(readOnly = true)
    public GameResponseDTO findById(Long id) {
        Game res = repository.findById(id).orElseThrow(() -> new RuntimeException("Game not found"));
        return new GameResponseDTO(res);
    }

    @Transactional(readOnly = true)
    public List<GameResponseDTO> findAll() {
        List<Game> res = repository.findAll();
        return res.stream().map(GameResponseDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameResponseDTO> findByList(Long listId) {
        List<GameMinProjection> res = repository.searchByList(listId);
        return res.stream().map(GameResponseDTO::new).toList();
    }
}
