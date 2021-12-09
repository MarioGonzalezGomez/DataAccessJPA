package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HibernateController {
    private EntityManagerFactory emf;
    private EntityManager manager;
    private EntityTransaction transaction;

    public HibernateController() {


    }

    public void open() {
        emf = Persistence.createEntityManagerFactory("default");
        manager = emf.createEntityManager();
        transaction = manager.getTransaction();
    }

    public void close() {
        manager.close();
        emf.close();
    }

    public EntityManagerFactory getEmf() {
        return emf;
    }

    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(EntityTransaction transaction) {
        this.transaction = transaction;
    }


}

