package repo;

import entity.Albums;
import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;


public class ArtistRepository {
    public void create(Artist a) {
        PersistenceUtil util = PersistenceUtil.getInstance();
        EntityManager entityManager = util.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(a);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public Artist findById(int id) {
        PersistenceUtil util = PersistenceUtil.getInstance();
        EntityManager entityManager = util.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        Artist artist = entityManager.find(Artist.class, id);
        if (artist == null) {
            throw new EntityNotFoundException("Can't find Artist for ID " + id);
        }
        return artist;

    }

    public List<Artist> findByName(String name) {
        PersistenceUtil util = PersistenceUtil.getInstance();
        EntityManager entityManager = util.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<Artist> query = entityManager.createNamedQuery("Artist.findByName", Artist.class);
        query.setParameter("name", name);
        return query.getResultList();

    }
}
