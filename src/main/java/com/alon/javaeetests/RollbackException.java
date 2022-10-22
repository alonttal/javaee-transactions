package com.alon.javaeetests;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class RollbackException extends Exception {

    public RollbackException(String message) {
        super(message);
    }
}
