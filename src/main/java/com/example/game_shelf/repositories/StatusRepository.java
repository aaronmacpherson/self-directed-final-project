package com.example.game_shelf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.game_shelf.models.Status;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
    // Generates CRUD functions for the Status model
}
