/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.strater.jenn;

import javax.jws.WebService;
import java.util.HashMap; 
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author jstrater
 */
@WebService(serviceName = "calendar", portName = "calendarServicePortTypeBindingPort", endpointInterface = "dk.dtu.imm.ws.calendar.CalendarServicePortType", targetNamespace = "http://ws.imm.dtu.dk/calendar", wsdlLocation = "WEB-INF/wsdl/Calendar/calendar.wsdl")
public class Calendar {
    
    private HashMap<XMLGregorianCalendar,String> appointments = new HashMap<XMLGregorianCalendar,String>();

    public java.lang.String getAppointment(XMLGregorianCalendar part1) {
        return appointments.get(part1);
    }

    public void addApointment(java.lang.String part1, XMLGregorianCalendar part2) {
        appointments.put(part2, part1);
    }
    
}
