package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Controller.setName("dba");
        Controller.setPassword("mysql");
        Controller.setUrl("jdbc:mysql://localhost:3306/musicalbums");

        Database mysql = Database.getInstance();
        ArtistController artistController = new ArtistController();
        AlbumController albumController = new AlbumController();

        artistController.create("Eminem", "USA");
        artistController.create("Florin Salam", "Romania");
        artistController.create("Ion de la Campina", "Romania");
        artistController.findByName("Florin Salam");


        artistController.create("Milea Robert","Spanaia");
        albumController.create("Cantec de sesiune",7,2020);
        albumController.create("Bella ciao", 1, 1940);
        albumController.findByArtist(1);
    }
}
