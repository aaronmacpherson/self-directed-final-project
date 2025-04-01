package com.example.game_shelf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.game_shelf.models.Platform;

@Repository
public interface PlatformRepository extends CrudRepository<Platform, Long> {
    // Generates CRUD functions for the Platform model
}
