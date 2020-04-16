package app;

import entity.Albums;
import entity.Artist;
import repo.AlbumRepository;
import repo.ArtistRepository;

public class AlbumManager {
    public static Albums albumSet(int id, String name, int year) {
        Albums album = new Albums();
        album.setArtistId(id);
        album.setName(name);
        album.setReleseYear(year);
        return album;
    }

    public static Artist artistSet(String name, String contry) {
        Artist artist = new Artist();
        artist.setName(name);
        artist.setCountry(contry);
        return artist;
    }

    public static void init() {
        try {
            AlbumRepository albumRepository = new AlbumRepository();
            ArtistRepository artistRepository = new ArtistRepository();

            artistRepository.create(artistSet("Florin Salam", "Romania"));
            artistRepository.create(artistSet("Smiley ", "Romania"));
            artistRepository.create(artistSet("EMINEM", "USA"));
            artistRepository.create(artistSet("Maître Gims", "Republica Democrată Congo"));


            albumRepository.create(albumSet(1, "Nebunia lui Salam", 2005));
            albumRepository.create(albumSet(1, "Lacrimi de iubire", 2007));
            albumRepository.create(albumSet(1, "Cu Buzunarul Gol Ajung Acasa Matol ", 2006));

            albumRepository.create(albumSet(2, "În lipsa mea", 2007));
            albumRepository.create(albumSet(2, "Plec pe marte", 2010));
            albumRepository.create(albumSet(2, "In statie la Lizeanu (Domnisoara Domnisoara)", 2016));

            albumRepository.create(albumSet(3, "The Real Slim Shady", 2000));
            albumRepository.create(albumSet(3, "Mockingbird", 2005));
            albumRepository.create(albumSet(3, "Godzilla", 2020));

            albumRepository.create(albumSet(4, "Miami Vice", 2019));
            albumRepository.create(albumSet(4, "Mi Gna", 2019));
            albumRepository.create(albumSet(4, "Naif", 2019));
        } catch (Exception ignored) {};
    }

    public static void main(String[] args) {
        AlbumRepository albumRepository = new AlbumRepository();
        ArtistRepository artistRepository = new ArtistRepository();
     //   init();
        var rez = albumRepository.findByArtist(artistSet("Florin Salam", ""));
        System.out.println(rez);
        rez = albumRepository.findByArtist(artistSet("EMINEM", ""));
        System.out.println(rez);
        // artistRepository.create(artistSet("",""));
        // albumRepository.create(albumSet(1,"",1066));

    }
}
