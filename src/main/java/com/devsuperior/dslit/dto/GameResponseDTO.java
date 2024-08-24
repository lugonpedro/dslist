package com.devsuperior.dslit.dto;

import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.projections.GameMinProjection;

public class GameResponseDTO {
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String description;

    public GameResponseDTO(Game entity){
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        description = entity.getDescription();
    }

    public GameResponseDTO(GameMinProjection projection){
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        description = projection.getDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }
}
