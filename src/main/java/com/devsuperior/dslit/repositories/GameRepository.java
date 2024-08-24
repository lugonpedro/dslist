package com.devsuperior.dslit.repositories;

import com.devsuperior.dslit.entities.Game;
import com.devsuperior.dslit.projections.GameMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    @Query(nativeQuery = true, value = """
		SELECT games.id, games.title, games.game_year AS gameYear, games.img_url AS imgUrl,
		games.description, belonging.position
		FROM games
		INNER JOIN belonging ON games.id = belonging.game_id
		WHERE belonging.list_id = :listId
		ORDER BY belonging.position
		""")
    List<GameMinProjection> searchByList(Long listId);
}
