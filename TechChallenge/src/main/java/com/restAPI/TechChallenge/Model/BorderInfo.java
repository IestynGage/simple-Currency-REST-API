package com.restAPI.TechChallenge.Model;

import com.jayway.restassured.path.json.JsonPath;
import com.restAPI.TechChallenge.DataStructure.ListsCountries;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class BorderInfo {
    /**
     * Sends a request to restCountries to get json object about the currency code,
     * then the data from restcountries API is turned into ListCountries object
     *
     * @param currency the currency code to create ListCountries from
     * @return ListCountries object about the currency
     */
    public ListsCountries getData(String currency) {
        final String url = "https://restcountries.eu/rest/v2/currency/"+currency;
        RestTemplate restTemplate = new RestTemplate();
        var result = restTemplate.getForObject(url, String.class);
        List<String> countryUsingCurrency = JsonPath.from(result).get("alpha3Code");
        List<List<String>> countryBorderCurrency = JsonPath.from(result).get("borders");

        ListsCountries output = new ListsCountries();
        countryUsingCurrency.stream().forEach(output::addUsingCurrency);
        countryBorderCurrency.stream()
                .flatMap(x -> x.stream().filter(country -> !output.isInCurrency(country)))
                .forEach(output::addBorderCounty);


        return output;
    }
}
