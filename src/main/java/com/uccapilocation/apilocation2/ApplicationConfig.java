package com.uccapilocation.apilocation2;

import com.uccapilocation.apilocation2.impl.ServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import javax.xml.ws.soap.SOAPBinding;

@Configuration
public class ApplicationConfig {
    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint(ServiceImpl serviceImpl){
        Endpoint endpoint = new EndpointImpl(bus, serviceImpl, SOAPBinding.SOAP12HTTP_BINDING);
        endpoint.publish("/soap/Service");
        return endpoint;
    }


}
