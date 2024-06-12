package com.example.consumingwebservice;

import jakarta.xml.soap.MimeHeaders;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.WebServiceClientException;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.context.TransportContext;
import org.springframework.ws.transport.context.TransportContextHolder;
import org.springframework.ws.transport.http.HttpComponentsConnection;

import java.io.IOException;


public class ContentTypeInterceptor implements ClientInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext) {
        WebServiceMessage request = messageContext.getRequest();
        SaajSoapMessage soapMessage = (SaajSoapMessage)request;
        MimeHeaders headers = soapMessage.getSaajMessage().getMimeHeaders();
        headers.removeHeader("Content-Type");
        headers.setHeader("Content-Type", "application/soap+xml; charset=utf-8");

        //======================== 2nd implemention ==================================
        TransportContext context = TransportContextHolder.getTransportContext();
        HttpComponentsConnection connection =(HttpComponentsConnection) context.getConnection();
        try {
            connection.addRequestHeader("Content-Type", "application/soap+xml; charset=utf-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Exception e) throws WebServiceClientException {

    }
}
