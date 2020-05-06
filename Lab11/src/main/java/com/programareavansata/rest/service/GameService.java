package com.programareavansata.rest.service;


import com.programareavansata.rest.helpers.Gomoku;
import com.programareavansata.rest.models.Game;
import com.programareavansata.rest.models.Move;
import com.programareavansata.rest.models.Player;
import com.programareavansata.rest.models.Row;
import com.programareavansata.rest.repository.GameRepository;
import com.programareavansata.rest.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;

    public Game createGame() {

        List<Row> board = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            board.add(new Row());
        }
        Game game = new Game();

        game.setId(UUID.randomUUID().toString());
        game.setBoard(board);
        game.setLastMoveBy("admin");
        game.setTurn(1);

        game = gameRepository.save(game);
        return game;
    }

    public List<Game> getAllGame() {
        List<Game> games = gameRepository.findAll();
        if (games.size() > 0) {
            return games;
        } else {
            return new ArrayList<Game>();
        }
    }

    public Game getGameById(String id) {
        Game game = gameRepository.findGameById(id);
        return game;
    }


    public String putMove(Move move) {

        Game game = gameRepository.findGameById(move.getGameId());
        Player player = playerRepository.findPlayerById(move.getPlayerId());
        if (game == null) {
            return "INVALID GAME ID";
        }
        if (player == null) {
            return "INVALID PLAYER ID";
        }
        Gomoku gomoku = new Gomoku(game);
        if (gomoku.gameDone()) {
            return "Player " + game.getLastMoveBy() + " won the game!";
        }
        if (player.getName().equals(game.getLastMoveBy())) {
            return "the other player did not move";
        }
        gomoku.setPlayer(game.getTurn());
        if (!gomoku.setPiece(move.getX(), move.getY())) {
            return "invalid move";
        }
        game = gomoku.getGame();
        game.setLastMoveBy(player.getName());
        game.setTurn(gomoku.getPlayer());

        gameRepository.save(game);
        return gomoku.print();
    }


}
