package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class Session implements iSession {

    protected EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public Session() {
        entityManagerFactory = Persistence.createEntityManagerFactory("entityManager");
    }

    @Override
    public void openSessionWithTransaction() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @Override
    public void closeSessionWithTransaction() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
