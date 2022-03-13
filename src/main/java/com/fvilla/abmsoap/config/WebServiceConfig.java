package com.fvilla.abmsoap.config;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.fvilla.abmsoap.cxf.OperacionesAbm;
 
@Configuration
public class WebServiceConfig {
    
    @Autowired
    private Bus bus;

    @Autowired
    private OperacionesAbm operacionesAbm;
    
    @Bean
    public ServletRegistrationBean<CXFServlet> cxfServlet() {
        return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/abm-soap/*");
    }

    @Bean
    public Endpoint userEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, operacionesAbm);
        endpoint.publish("/services");

        return endpoint;
    }
}