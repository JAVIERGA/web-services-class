/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.strater.jenn;

import javax.jws.WebService;

/**
 *
 * @author jstrater
 */
@WebService(serviceName = "WhitePagesService", portName = "WhitePagesPortTypeBindingPort", endpointInterface = "dtu.imm.ws.WhitePagesPortType", targetNamespace = "ws.imm.dtu", wsdlLocation = "WEB-INF/wsdl/WhitePagesService/WhitePages.wsdl")
public class WhitePagesService {

    public void whitePagesOperation(javax.xml.ws.Holder<java.lang.String> part1) throws dtu.imm.ws.Wpfault {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
