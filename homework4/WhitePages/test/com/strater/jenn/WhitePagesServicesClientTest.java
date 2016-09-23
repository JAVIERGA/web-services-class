package com.strater.jenn;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
import java.util.ArrayList;

public class WhitePagesServicesClientTest {
    
    Person testPerson = new Person();
    
    public void setup() {
        testPerson.firstname = "Jenn";
        testPerson.lastname = "Strater";
        testPerson.phone = "1234567890";
        Address address = new Address();
        address.street = "123 Main Street";
        address.city = "anytown";
        address.postcode = "12345";
        testPerson.address = address;
    }
    
    @Test
    public void addValidPersonTest() throws Wpfault {
        
        String response = addPerson(testPerson);
        
        assertEquals(response, "done");
    }
    
    @Test
    public void findEmptyPersonTest() {
        PersonArray response = findPerson(new Person());
        assertEquals(response.getPerson(), new ArrayList());
    }

    private static String addPerson(com.strater.jenn.Person person) throws Wpfault {
        com.strater.jenn.WhitePagesService service = new com.strater.jenn.WhitePagesService();
        com.strater.jenn.WhitePagesPortType port = service.getWhitePagesPortTypeBindingPort();
        return port.addPerson(person);
    }

    private static PersonArray findPerson(com.strater.jenn.Person person) {
        com.strater.jenn.WhitePagesService service = new com.strater.jenn.WhitePagesService();
        com.strater.jenn.WhitePagesPortType port = service.getWhitePagesPortTypeBindingPort();
        return port.findPerson(person);
    }
}
