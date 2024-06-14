
package com.example.consumingwebservice;

import com.example.consumingwebservice.stubs.GetPassword;
import com.example.consumingwebservice.stubs.GetPasswordResponse;
import com.example.consumingwebservice.stubs.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.soap.MimeHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;

@Service
public class BESClient extends WebServiceGatewaySupport {

    Logger log = LoggerFactory.getLogger(BESClient.class);
    @Autowired
    private SaajSoapMessageFactory messageFactory;

    public GetPasswordResponse getPasswordResponse() throws Exception {
        try {
            ObjectFactory factory = new ObjectFactory();
            GetPassword requestPassword = factory.createGetPassword();

            JAXBElement<String> userId = factory.createString("abc");
            JAXBElement<String> password = factory.createString("xyz");
            JAXBElement<String> passKey = factory.createString("er34");

            requestPassword.setUserId(userId);
            requestPassword.setPassword(password);
            requestPassword.setPassKey(passKey);

            MimeHeaders headers = messageFactory.createWebServiceMessage().getSaajMessage().getMimeHeaders();
            headers.addHeader("Content-Type", "application/soap+xml;charset=utf-8");
            getWebServiceTemplate().setMessageFactory(messageFactory);

            return (GetPasswordResponse) getWebServiceTemplate()
                    .marshalSendAndReceive("https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure", requestPassword);
        } catch (Exception ex) {
            System.out.println("GetPassword Response Error: " + ex.getMessage());
            log.error("GetPassword Response Error: " + ex.getLocalizedMessage());
        }
        return null;
    }
}

