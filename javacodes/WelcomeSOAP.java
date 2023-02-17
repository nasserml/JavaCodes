package com.deitel.welcomesoap;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WelcomeSOAP")
public class WelcomeSOAP {

    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Welcome to JAX-WS web services with SOAP, " + txt + " !";
    }
}
