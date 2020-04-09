package com.company;

import java.sql.ResultSet;

public class AlbumController extends Controller {

    // having the methods create(String name, int artistId, int releaseYear) and findByArtist(int artistId).

    public void create(String name, int artistId, int releaseYear) {
        Database mysql = Database.getInstance();
        String command = "insert into albums value ( default , \"" + name + "\" , " + artistId + " , " + releaseYear + " )";
        mysql.append(command);
    }

    public void findByArtist(int artistId) {
        Database mysql = Database.getInstance();
        String command = "select * from albums where artist_id = " + artistId ;
        ResultSet result = mysql.query(command);
        if (result == null) {
            System.out.println("Eroare in select");
        } else {
            try {
                while (result.next()) {
                    System.out.println(result.getString(1) + " " + result.getString(2) + " " + result.getString(3));
                }
            } catch (Exception ignored) {
            }

        }
    }
}
