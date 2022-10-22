package com.alon.javaeetests;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class CDIContainer {

    @PersistenceContext
    private EntityManager em;

    // Does not rollback because it is a checked-exception (business exception)
    public void doTransactionalOperation1() throws Exception {
        TransactionUtils.doTransactionalOperation1(em);
    }

    // Rollback because it is an unchecked-exception (system exception)
    public void doTransactionalOperation2() {
        TransactionUtils.doTransactionalOperation2(em);
    }

    // Rollback because it is configured to rollback for RollbackException
    @Transactional(rollbackOn = RollbackException.class)
    public void doTransactionalOperation3() throws Exception {
        TransactionUtils.doTransactionalOperation3(em);
    }

    public List<Item> elements() {
        return TransactionUtils.elements(em);
    }

    @PostConstruct
    public void init() {
        System.out.println("init " + this);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy " + this);
    }
}
