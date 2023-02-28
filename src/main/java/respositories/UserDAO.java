package respositories;

import Dao.Connection;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAO implements GenericDAO<Object> {
    @Autowired
    private EntityManager em;
    private EntityManagerFactory emf;

    public UserDAO() {

    }

    @Transactional
    @Override
    public void create(Object object) throws Exception {

        //Iniciamos una transacción
        em.getTransaction().begin();

        //Persistimos los objetos
        em.persist(object);

        //Commiteamos la transacción
        em.getTransaction().commit();
    }

    @Override
    public void delete(Object object) throws Exception {

        if (em.contains(object))
            em.remove(object);
        else
            em.remove(em.merge(object));
    }
    @Transactional
    @Override
    public List<Object> getAll() throws Exception {
        em = Connection.createConnection();
        emf = Connection.createConnection2();
        List listUsers = em.createQuery("from User ").getResultList();
        Connection.close2();
        Connection.close();
        return listUsers;
    }

    @Override
    public Object getById(int id) throws Exception {


        User user = em.find(User.class, id);

//
//      // Cerramos todos los objetos

        return user;
    }

    @Override
    public void update(Object object) throws Exception {

        em.merge(object);


    }
}
