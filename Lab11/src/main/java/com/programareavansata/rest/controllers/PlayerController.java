package com.programareavansata.rest.controllers;


import com.programareavansata.rest.models.Player;
import com.programareavansata.rest.service.GameService;
import com.programareavansata.rest.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/lab11")
public class PlayerController {


    @Autowired
    private PlayerService service;
    //create
    @RequestMapping(path = "/players", method = RequestMethod.POST)
    ResponseEntity<Player> createPlayer(@RequestBody Player player) {
        player = service.createPlayer(player);

        return new ResponseEntity<>(player, new HttpHeaders(), HttpStatus.CREATED);
    }
    //read
    @RequestMapping(path = "/players", method = RequestMethod.GET)
    ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = service.getAllPlayers();
        return new ResponseEntity<>(players, new HttpHeaders(), HttpStatus.OK);
    }

    @RequestMapping(path = "/players/{id}", method = RequestMethod.GET)
    ResponseEntity<Player> getPlayerById(@PathVariable String id) {
        Player players = service.getPlayerById(id);
        return new ResponseEntity<>(players, new HttpHeaders(), HttpStatus.OK);
    }
    //update
    @RequestMapping(path = "/players/{id}/{name}", method = RequestMethod.PUT)
    ResponseEntity<Player> updatePlayerName(@PathVariable String id, @PathVariable String name) {
        Player players = service.updatePlayerName(id, name);
        return new ResponseEntity<>(players, new HttpHeaders(), HttpStatus.OK);
    }
    //delete
    @RequestMapping(path = "/players/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Player> deletePlayerById(@PathVariable String id) {
        service.deletePlayer(id);
        return new ResponseEntity<>(service.getPlayerById(id), new HttpHeaders(), HttpStatus.OK);
    }


}
