
package com.example.consumingwebservice;

import com.example.consumingwebservice.stubs.GetPassword;
import com.example.consumingwebservice.stubs.GetPasswordResponse;
import com.example.consumingwebservice.stubs.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.soap.MimeHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.ws.soap.saaj.SaajSoapMessage;
import org.springframework.ws.transport.TransportConstants;

import javax.xml.transform.TransformerException;
import java.io.IOException;

public class BESClient extends WebServiceGatewaySupport  {

    public GetPasswordResponse getPasswordResponse() {
        ObjectFactory factory = new ObjectFactory();
        GetPassword requestPassword = factory.createGetPassword();

        JAXBElement<String> userId = factory.createString("abc");
        JAXBElement<String> password = factory.createString("xyz");
        JAXBElement<String> passKey = factory.createString("er34");

        requestPassword.setUserId(userId);
        requestPassword.setPassword(password);
        requestPassword.setPassKey(passKey);

        GetPasswordResponse response = (GetPasswordResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://bsestarmfdemo.bseindia.com/MFOrderEntry/MFOrder.svc/Secure", requestPassword,
                        new SoapActionCallback(
                                "http://pbustarmfsrv113.bseltd.domain/MFOrderEntry/MFOrder.svc"));

        return response;
    }


}

