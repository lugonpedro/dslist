package com.devsuperior.dslit.services;


import com.devsuperior.dslit.dto.GameListResponseDTO;
import com.devsuperior.dslit.entities.GameList;
import com.devsuperior.dslit.projections.GameMinProjection;
import com.devsuperior.dslit.repositories.GameListRepository;
import com.devsuperior.dslit.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository repository;

    @Autowired
    private GameRepository gameRepository;

    public GameListResponseDTO findById(Long id) {
        GameList res = repository.findById(id).orElseThrow(() -> new RuntimeException("Game List not found"));
        return new GameListResponseDTO(res);
    }

    public List<GameListResponseDTO> findAll() {
        List<GameList> res = repository.findAll();
        return res.stream().map(GameListResponseDTO::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            repository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
