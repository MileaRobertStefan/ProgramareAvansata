package repo;

import entity.Albums;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.TypedQuery;
import java.util.List;

public class AlbumRepository {

    public void create(Albums a) {
        PersistenceUtil util = PersistenceUtil.getInstance();
        EntityManager entityManager = util.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(a);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public Albums findById(int id) {
        PersistenceUtil util = PersistenceUtil.getInstance();
        EntityManager entityManager = util.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Albums artist = entityManager.find(Albums.class, id);
        if (artist == null) {
            throw new EntityNotFoundException("Can't find Artist for ID " + id);
        }
        return artist;

    }

    public List<Albums> findByName(String name) {
        PersistenceUtil util = PersistenceUtil.getInstance();
        EntityManager entityManager = util.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Albums> query = entityManager.createNamedQuery("Albums.findByName", Albums.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Albums> findByArtist(Artist artist) {
        ArtistRepository artistRepository = new ArtistRepository();
        var rez = artistRepository.findByName(artist.getName());
        if (rez.size() > 0) {
            PersistenceUtil util = PersistenceUtil.getInstance();
            EntityManager entityManager = util.getEntityManagerFactory().createEntityManager();
            entityManager.getTransaction().begin();
            TypedQuery<Albums> query = entityManager.createNamedQuery("Albums.findByArtist", Albums.class);
            query.setParameter("id",rez.get(0).getId());
            return  query.getResultList();
        } else {
            return null;
        }
    }
}
