package com.example.consumingwebservice.controller;

//import com.example.consumingwebservice.CountryClient;
//import com.example.consumingwebservice.stubs.Currency;
//import com.example.consumingwebservice.stubs.GetCountryResponse;

import com.example.consumingwebservice.BESClient;
import com.example.consumingwebservice.dto.BesDTO;
import com.example.consumingwebservice.entity.BesEntity;
import com.example.consumingwebservice.mapper.BesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/bes")
public class BesController {

    @Autowired
    private BesMapper mapper;

    @Autowired
    private BESClient besClient;
    @GetMapping("/test")
    public String test() {
        BesEntity entity = new BesEntity();
        entity.setMsg("entity msg value");

        BesDTO dto = mapper.entityToDto(entity);

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
