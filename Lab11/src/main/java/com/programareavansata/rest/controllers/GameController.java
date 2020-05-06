package com.programareavansata.rest.controllers;


import com.programareavansata.rest.models.Game;
import com.programareavansata.rest.models.Move;
import com.programareavansata.rest.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api/lab11/")
public class GameController {
    @Autowired
    private GameService service;

    //create
    @RequestMapping(path = "/games", method = RequestMethod.POST)
    public ResponseEntity<Game> createOrUpdateUser() {
        Game newUser = service.createGame();
        return new ResponseEntity<Game>(newUser, new HttpHeaders(), HttpStatus.CREATED);
    }
//read

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> getUsers() {
        List<Game> games = service.getAllGame();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<List<Game>>(games, httpHeaders, HttpStatus.OK);
    }

    @RequestMapping(path = "/games/{id}", method = RequestMethod.GET)
    public ResponseEntity<Game> getUserById(@PathVariable String id) {
        Game game = service.getGameById(id);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Access-Control-Allow-Origin", "*");
        return new ResponseEntity<Game>(game, httpHeaders, HttpStatus.OK);
    }

    //update
    @RequestMapping(path = "/games/move", method = RequestMethod.PUT)
    public ResponseEntity<String> putMove(@RequestBody Move move) {
        String s = service.putMove(move);
        return new ResponseEntity<>(s, new HttpHeaders(), HttpStatus.OK);
    }

    //delete
}
