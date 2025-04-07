package com.example.game_shelf.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.game_shelf.models.Game;

@Repository
public interface GameRepository extends CrudRepository<Game, Long> {
    // Generates CRUD functions for the Game model
    public List<Game> findAllByOrderByIdDesc();
}
