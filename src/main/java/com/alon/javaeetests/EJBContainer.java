package com.alon.javaeetests;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

// It is important that the class is stateless. in case of singleton the bean would not be destroyed on non-application
// exceptions
@Stateless
public class EJBContainer {

    @PersistenceContext
    private EntityManager em;

    // Does not rollback because it is a checked-exception (business exception)
    public void doTransactionalOperation1() throws Exception {
        TransactionUtils.doTransactionalOperation1(em);
    }

    // Rollback exception because it is a unchecked-exception (system exception)
    public void doTransactionalOperation2() {
        TransactionUtils.doTransactionalOperation2(em);
    }

    // Rollback exception because it is an application-exception annotated with @ApplicationException(rollback=true)
    public void doTransactionalOperation3() throws RollbackException {
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