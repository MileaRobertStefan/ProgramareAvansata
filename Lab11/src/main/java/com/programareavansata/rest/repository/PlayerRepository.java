package com.programareavansata.rest.repository;

import com.programareavansata.rest.models.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayerRepository extends MongoRepository<Player, String>{




    Player findPlayerById(String id);

     void deleteById(String id);
}
