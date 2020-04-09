package com.company;

public abstract class Controller {
    static private String name;
    static private String password;
    static private String url;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Controller.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        Controller.password = password;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        Controller.url = url;
    }
}
