package com.strater.jenn;

import javax.jws.WebService;
import java.util.ArrayList;
import dtu.imm.ws.Person;
import dtu.imm.ws.Wpfault;

@WebService(serviceName = "WhitePagesService", portName = "WhitePagesPortTypeBindingPort", endpointInterface = "dtu.imm.ws.WhitePagesPortType", targetNamespace = "ws.imm.dtu", wsdlLocation = "WEB-INF/wsdl/WhitePagesService/WhitePages.wsdl")
public class WhitePagesService {
    
    ArrayList<Person> people = new ArrayList();

    public java.lang.String addPerson(Person person) throws Wpfault {
        people.add(person);
        return "done";
    }

    public dtu.imm.ws.PersonArray findPerson(Person person) {
        return new dtu.imm.ws.PersonArray();
    }
}
