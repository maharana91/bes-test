package com.example.consumingwebservice.controller;

//import com.example.consumingwebservice.CountryClient;
//import com.example.consumingwebservice.stubs.Currency;
//import com.example.consumingwebservice.stubs.GetCountryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency")
public class ContryController {

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
}
