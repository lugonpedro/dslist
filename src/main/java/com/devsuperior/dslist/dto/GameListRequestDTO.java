package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;
import org.springframework.beans.BeanUtils;

public class GameListRequestDTO {
    private Long id;
    private String name;

    public GameListRequestDTO(Game entity){
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
