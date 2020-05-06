package com.programareavansata.rest.repository;

import com.programareavansata.rest.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface GameRepository extends MongoRepository<Game, String> {
    Game findGameById(String id);


}
