package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {
    private static PersistenceUtil singleton = null;

    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("org.hibernate.MusicAlbumsPU.jpa");

    }


    public static PersistenceUtil getInstance() {
        if (singleton == null)
            singleton = new PersistenceUtil();
        return singleton;
    }

    private PersistenceUtil() {
    }
}
