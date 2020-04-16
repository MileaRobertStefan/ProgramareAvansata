package entity;

import javax.persistence.*;

@Entity
@Table(name = "albums")
@NamedQueries({
@NamedQuery(name="Albums.findByName",
        query="SELECT a FROM Albums a where name = :name") ,
@NamedQuery(name="Albums.findByArtist",
        query="SELECT al FROM Albums al  where al.artistId = :id ")
})
public class Albums {
    @Id
    @GeneratedValue(generator = "incrementor")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "artist_id")
    private int artistId;
    @Column(name = "release_year")
    private int releseYear;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public int getReleseYear() {
        return releseYear;
    }

    public void setReleseYear(int releseYear) {
        this.releseYear = releseYear;
    }

    @Override
    public String toString() {
        return "Albums{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", artistId=" + artistId +
                ", releseYear=" + releseYear +
                '}';
    }
}
