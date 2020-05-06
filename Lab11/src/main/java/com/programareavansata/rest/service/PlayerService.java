package com.programareavansata.rest.service;


import com.programareavansata.rest.models.Player;
import com.programareavansata.rest.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PlayerService {


    @Autowired
    private PlayerRepository playerRepository;

    public List<Player> getAllPlayers() {
        List<Player> players = playerRepository.findAll();
        if (players.size() > 0) {
            return players;
        } else {
            return new ArrayList<>();
        }
    }

    public Player getPlayerById(String id) {
        return playerRepository.findPlayerById(id);
    }

    public Player updatePlayerName(String id, String name) {
        Player player = playerRepository.findPlayerById(id);
        player.setName(name);
        player = playerRepository.save(player);
        return player;
    }

    public Player createPlayer(Player player) {
        player.setId(UUID.randomUUID().toString());
        player = playerRepository.save(player);
        return player;
    }

    public  void deletePlayer(String id){
        playerRepository.deleteById(id);
    }
}