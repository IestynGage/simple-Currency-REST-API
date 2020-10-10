package com.restAPI.TechChallenge.Model;

import com.restAPI.TechChallenge.DataStructure.ListsCountries;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class BorderInfo_JPY_SizeTest {

    @Test
    void getBorderInfo_JPY_SizeTest() throws Exception {
        BorderInfo bi = new BorderInfo();
        ListsCountries actualData = bi.getData("JPY");

        assertEquals(2,actualData.getUsingCurrency().size());
        assertEquals(4,actualData.getBorderCountries().size());
    }

    @Test
    void getBorderInfo_CUC_SizeTest() throws Exception {
        BorderInfo bi = new BorderInfo();
        ListsCountries actualData = bi.getData("CUC");

        assertEquals(1,actualData.getUsingCurrency().size());
        assertEquals(0,actualData.getBorderCountries().size());
    }

    @Test
    void getBorderInfo_DKK_SizeTest() throws Exception {
        BorderInfo bi = new BorderInfo();
        ListsCountries actualData = bi.getData("DKK");

        assertEquals(3,actualData.getUsingCurrency().size());
        assertEquals(1,actualData.getBorderCountries().size());
    }

    @Test
    void getBoderInfo_JPY_DataTest(){
        BorderInfo bi = new BorderInfo();
        ListsCountries listsCountries = bi.getData("JPY");
        HashSet<String> actualCurrency = listsCountries.getUsingCurrency();
        HashSet<String> actualBorders = listsCountries.getBorderCountries();

        assertTrue(actualCurrency.contains("JPN"));
        assertTrue(actualCurrency.contains("ZWE"));
        assertTrue(actualBorders.contains("MOZ"));
        assertTrue(actualBorders.contains("BWA"));
        assertTrue(actualBorders.contains("ZAF"));
        assertTrue(actualBorders.contains("ZMB"));
    }
}