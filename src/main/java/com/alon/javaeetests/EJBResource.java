package com.alon.javaeetests;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("ejb-resource")
public class EJBResource {

    @Inject
    private EJBContainer ejbContainer;

    @GET
    @Path("test-1")
    public String Test1() {
        try {
            ejbContainer.doTransactionalOperation1();
        } catch (Exception ex) {
            System.out.println("exception was caught: " + ex.getMessage());
        }
        boolean result = ejbContainer.elements().size() == 3;

        System.out.println("result: " + result);
        return String.valueOf(result);
    }

    @GET
    @Path("test-2")
    public String Test2() {
        try {
            ejbContainer.doTransactionalOperation2();
        } catch (Exception ex) {
            System.out.println("exception was caught: " + ex.getMessage());
        }
        boolean result = ejbContainer.elements().isEmpty();

        System.out.println("result: " + result);
        return String.valueOf(result);
    }

    @GET
    @Path("test-3")
    public String Test3() {
        try {
            ejbContainer.doTransactionalOperation3();
        } catch (Exception ex) {
            System.out.println("exception was caught: " + ex.getMessage());
        }
        boolean result = ejbContainer.elements().isEmpty();

        System.out.println("result: " + result);
        return String.valueOf(result);
    }
}
