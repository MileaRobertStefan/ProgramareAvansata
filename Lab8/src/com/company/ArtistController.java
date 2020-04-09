package com.company;

import java.sql.ResultSet;

public class ArtistController extends Controller {

    public void create(String name, String country) {
        Database mysql = Database.getInstance();
        String command = "insert into artists value ( default , \"" + name + "\" ,\" " + country + "\" )";
        mysql.append(command);
    }

    public void findByName(String name) {
        Database mysql = Database.getInstance();
        String command = "select * from artists where name = '" + name + "'";
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

    ArtistController() {

    }
}
