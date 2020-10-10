package com.restAPI.TechChallenge.DataStructure;

import java.util.HashSet;

public class ListsCountries {
    HashSet<String> usingCurrency;
    HashSet<String> borderCountries;

    /**
     * Initalizes the dataset
     */
    public ListsCountries(){
        usingCurrency = new HashSet<>();
        borderCountries = new HashSet<>();
    }

    /**
     * Adds string to HashSet
     * @param country to add the Hash Set
     */
    public void addUsingCurrency(String country){
        usingCurrency.add(country);
    }

    /**
     * Adds string to HashSet
     * @param country to add the Hash Set
     */
    public void addBorderCounty(String country){
        if(!usingCurrency.contains(country)) {
            borderCountries.add(country);
        }
    }

    /**
     * Checks if string is already contained in currency
     * @param country to add the Hash Set
     */
    public Boolean isInCurrency(String country){
        return usingCurrency.contains(country);
    }

    /**
     * Gets the usingCurrency HashSet
     * @return usingCurrency HashSet
     */
    public HashSet<String> getUsingCurrency() {
        return usingCurrency;
    }

    /**
     * Gets the borderCountries HashSet
     * @return borderCountries HashSet
     */
    public HashSet<String> getBorderCountries() {
        return borderCountries;
    }

    /**
     * Gets the object ina a string format
     * @return ListCountries in a string format
     */
    @Override
    public String toString() {
        return "ListsCountries{" +
                "usingCurrency=" + usingCurrency +
                ", borderCountries=" + borderCountries +
                '}';
    }
}
