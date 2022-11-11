package com.codewithcaleb.springbootsoap.api.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class SoapWsConfig {

    //we will inform Springboot to generate the WSDL file for us
    //remember i am not going to consume SOAP like REST
    //Remember this SOAP Application will have to be served
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> MessageDispatchServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<MessageDispatcherServlet>(servlet,"/ws/*");
    }

    @Bean(name = "loanEligibility")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("LoadEligibilityIndicator");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace("http://www.codewithcaleb.com/springbootsoap/api/loanEligibility");
        defaultWsdl11Definition.setSchema(schema);
        return defaultWsdl11Definition;
    }

    @Bean
    public XsdSchema schema(){
        return new SimpleXsdSchema(new ClassPathResource("loaneligibility.xsd"));
    }

}
