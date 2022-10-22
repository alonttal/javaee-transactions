package com.alon.javaeetests;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("cdi-resource")
public class CDIResource {
    @Inject
    private CDIContainer cdiContainer;

    @GET
    @Path("test-1")
    public String Test1() {
        try {
            cdiContainer.doTransactionalOperation1();
        } catch (Exception ex) {
            System.out.println("exception was caught: " + ex.getMessage());
        }
        boolean result = cdiContainer.elements().size() == 3;

        System.out.println("result: " + result);
        return String.valueOf(result);
    }

    @GET
    @Path("test-2")
    public String Test2() {
        try {
            cdiContainer.doTransactionalOperation2();
        } catch (Exception ex) {
            System.out.println("exception was caught: " + ex.getMessage());
        }
        boolean result = cdiContainer.elements().isEmpty();

        System.out.println("result: " + result);
        return String.valueOf(result);
    }

    @GET
    @Path("test-3")
    public String Test3() {
        try {
            cdiContainer.doTransactionalOperation3();
        } catch (Exception ex) {
            System.out.println("exception was caught: " + ex.getMessage());
        }
        boolean result = cdiContainer.elements().isEmpty();

        System.out.println("result: " + result);
        return String.valueOf(result);
    }
}
