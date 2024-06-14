package com.example.consumingwebservice.controller;

//import com.example.consumingwebservice.CountryClient;
//import com.example.consumingwebservice.stubs.Currency;
//import com.example.consumingwebservice.stubs.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.consumingwebservice.BESClient;


@RestController
@RequestMapping("/bes")
public class BesController {

    @Autowired
    private BESClient besClient;
    @GetMapping("/test")
    public String test() {
        return "Controller-Test";
    }

 /*   @GetMapping("/{name}")
    public Currency getCurrency(@PathVariable("name") String countryName) {
        //String country = "Spain";
        CountryClient countryClient = new CountryClient();
       GetCountryResponse response = countryClient.getCountry(countryName);
        System.err.println(response.getCountry().getCurrency());
        return response.getCountry().getCurrency();
    }*/

    @GetMapping("/getPassword")
    public ResponseEntity<?> getUserPassword() throws Exception {
        return ResponseEntity.ok(besClient.getPasswordResponse());
    }
}
