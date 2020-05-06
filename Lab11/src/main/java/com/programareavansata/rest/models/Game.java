package com.programareavansata.rest.models;


import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Id;
import java.util.List;

@Embeddable
@Document(collection = "Game")
public class Game {
    @Id
    String id;
    @ElementCollection
    List<Row> board;
    String lastMoveBy ;
    Integer turn;

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    public String getLastMoveBy() {
        return lastMoveBy;
    }

    public void setLastMoveBy(String lastMoveBy) {
        this.lastMoveBy = lastMoveBy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Row> getBoard() {
        return board;
    }

    public void setBoard(List<Row> board) {
        this.board = board;
    }
}
