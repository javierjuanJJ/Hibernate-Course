package com.example.projecthibernatejpa_springboot.respositories;

import com.example.projecthibernatejpa_springboot.Dao.Connection;
import com.example.projecthibernatejpa_springboot.Exceptions.UserException;
import com.example.projecthibernatejpa_springboot.domain.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAO implements UserService {
    private EntityManager em;
    private EntityManagerFactory emf;

    public UserDAO() {
        em = Connection.createConnection();
        emf = Connection.createConnection2();
    }

    @Transactional
    @Override
    public void create(User object) throws UserException {

        try {
            //Iniciamos una transacción
            em.getTransaction().begin();

            //Persistimos los objetos
            em.persist(object);

            //Commiteamos la transacción
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new UserException(e);
        }
    }

    @Override
    public void delete(User object) throws UserException {

        try {
            if (em.contains(object))
                em.remove(object);
            else
                em.remove(em.merge(object));
        } catch (Exception e) {
            throw new UserException(e);
        }
    }
    @Transactional
    @Override
    public List<User> getAll() throws UserException {
        try {
            em = Connection.createConnection();
            emf = Connection.createConnection2();
            List<User> listUsers = em.createQuery("from User ").getResultList();
            Connection.close2();
            Connection.close();
            return listUsers;
        } catch (Exception e) {
            throw new UserException(e);
        }
    }

    @Override
    public User getById(int id) throws UserException {


        User user = null;
        try {
            user = em.find(User.class, id);
        } catch (Exception e) {
            throw new UserException(e);
        }

//
//      // Cerramos todos los objetos

        return user;
    }

    @Override
    public void update(User object) throws UserException {

        try {
            em.merge(object);
        } catch (Exception e) {
            throw new UserException(e);
        } finally {
        }


    }
}
