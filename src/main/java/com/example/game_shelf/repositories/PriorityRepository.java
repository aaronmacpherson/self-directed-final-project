package com.example.game_shelf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.game_shelf.models.Priority;

@Repository
public interface PriorityRepository extends CrudRepository<Priority, Long> {
    // Generates CRUD functions for the Priority model
}
