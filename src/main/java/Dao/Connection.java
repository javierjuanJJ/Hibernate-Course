package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static EntityManagerFactory getEmf() {
        return emf;
    }

    public static EntityManager getEm() {
        return em;
    }

    public static EntityManager createConnection() {
        if (em == null) {
            // Iniciamos una sesión
            em = createConnection2().createEntityManager();
        }
        return em;
    }

    public static EntityManagerFactory createConnection2() {
        if (emf == null) {
            // Inicializamos un objeto SessionFactory con la configuración
            // del fichero User.hbm.xml
            //Inicialización del SessionFactory
            emf = Persistence.createEntityManagerFactory("example");
        }
        return emf;
    }

    public static void close() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

    public static void close2() {
        if (em != null) {
            em.close();
            em = null;
        }
    }

}
