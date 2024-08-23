package com.devsuperior.dslit.dto;

import com.devsuperior.dslit.entities.GameList;
import org.springframework.beans.BeanUtils;

public class GameListResponseDTO {
    private Long id;
    private String name;

    public GameListResponseDTO(GameList entity){
        BeanUtils.copyProperties(entity, this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
