package com.alon.javaeetests;

import javax.persistence.EntityManager;
import java.util.List;

public class TransactionUtils {

    public static void doTransactionalOperation1(EntityManager em) throws Exception {
        saveItems(em);
        throw new Exception("should not rollback because it is a business exception");
    }

    public static void doTransactionalOperation2(EntityManager em) {
        saveItems(em);
        throw new RuntimeException("should rollback because it is a system exception");
    }

    public static void doTransactionalOperation3(EntityManager em) throws RollbackException {
        saveItems(em);
        throw new RollbackException("should rollback due to configuration");
    }

    public static List<Item> elements(EntityManager em) {
        return em.createNamedQuery(Item.FIND_ALL, Item.class).getResultList();
    }

    private static void saveItems(EntityManager em) {
        em.persist(new Item(1));
        em.persist(new Item(2));
        em.persist(new Item(3));
    }
}
