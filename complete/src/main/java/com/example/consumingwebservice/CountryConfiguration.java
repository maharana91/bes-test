
package com.example.consumingwebservice;

import jakarta.xml.soap.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.TransportConstants;

import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.List;

@Configuration
public class CountryConfiguration extends WsConfigurerAdapter {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("com.example.consumingwebservice.stubs");
		return marshaller;
	}

	//@Bean
	/*public CountryClient countryClient(Jaxb2Marshaller marshaller) {
		CountryClient client = new CountryClient();
		//client.setDefaultUri("http://localhost:9999/ws");
		client.setDefaultUri("https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}*/

	@Bean
	public BESClient besClient(Jaxb2Marshaller marshaller) {
		BESClient client = new BESClient();
		//client.setDefaultUri("http://localhost:9999/ws");
		client.setDefaultUri("https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure");
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
/*
	@Bean
	public SaajSoapMessageFactory messageFactory() {
		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
		messageFactory.setSoapVersion(SoapVersion.SOAP_12);
		return messageFactory;
	}*/

	@Bean
	public SaajSoapMessageFactory messageFactory() throws SOAPException {
		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
		messageFactory.setSoapVersion(SoapVersion.SOAP_12);  //.SOAP_12
		//MimeHeaders headers =
		//headers.setHeader(TransportConstants.HEADER_CONTENT_TYPE, "application/soap+xml;charset=utf-8");
		messageFactory.setMessageFactory(MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL));
		messageFactory.createWebServiceMessage().getSaajMessage().getMimeHeaders()
				.setHeader("Content-Type", "application/soap+xml;charset=utf-8");
		messageFactory.afterPropertiesSet();
		WebServiceTemplate webServiceTemplate = new BESClient().getWebServiceTemplate();
		webServiceTemplate.setMessageFactory(messageFactory);
		webServiceTemplate.setInterceptors(new ClientInterceptor[]{new ContentTypeInterceptor()});
		return messageFactory;
	}

}

