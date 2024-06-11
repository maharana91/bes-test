package com.example.consumingwebservice;

import jakarta.xml.soap.MimeHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.TransportConstants;

import javax.xml.transform.TransformerException;
import java.io.IOException;


public class HeaderModification implements WebServiceMessageCallback {
    @Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {
        try{
            SaajSoapMessage soapMessage = (SaajSoapMessage) webServiceMessage;
            MimeHeaders headers = soapMessage.getSaajMessage().getMimeHeaders();
            headers.setHeader(TransportConstants.HEADER_CONTENT_TYPE, "application/soap+xml;charset=utf-8");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
