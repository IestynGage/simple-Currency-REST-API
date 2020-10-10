package com.restAPI.TechChallenge.Controllers;

import com.restAPI.TechChallenge.DataStructure.ListsCountries;
import com.restAPI.TechChallenge.Model.BorderInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorderInfoController {


    /**
     * Rest Controller method that accepts currency code as parameter and sends list of countries that use that currency
     * and countries that border countries that use currency
     *
     * @param currency to create ListCountries from
     * @return ListCountries object
     */
    @GetMapping("/borderInfo")
    public ListsCountries getBorderInfo(@RequestParam(value = "currency",defaultValue = "N/A") String currency){

        BorderInfo model = new BorderInfo();

        return model.getData(currency);

    }
}
