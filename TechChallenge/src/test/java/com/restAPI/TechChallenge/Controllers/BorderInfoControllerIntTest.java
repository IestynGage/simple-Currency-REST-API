package com.restAPI.TechChallenge.Controllers;

import com.google.gson.Gson;
import com.restAPI.TechChallenge.DataStructure.ListsCountries;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(BorderInfoController.class)
class BorderInfoControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getBorderInfo_JPY_SizeTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/borderInfo?currency=JPY");
        MvcResult result = mvc.perform(request).andReturn();

        Gson gson = new Gson();
        ListsCountries actualData = gson.fromJson(result.getResponse().getContentAsString(),ListsCountries.class);

        assertEquals(2,actualData.getUsingCurrency().size());
        assertEquals(4,actualData.getBorderCountries().size());
    }

    @Test
    void getBorderInfo_CUC_SizeTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/borderInfo?currency=CUC");
        MvcResult result = mvc.perform(request).andReturn();

        Gson gson = new Gson();
        ListsCountries actualData = gson.fromJson(result.getResponse().getContentAsString(),ListsCountries.class);

        assertEquals(1,actualData.getUsingCurrency().size());
        assertEquals(0,actualData.getBorderCountries().size());
    }

    @Test
    void getBorderInfo_DKK_SizeTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/borderInfo?currency=DKK");
        MvcResult result = mvc.perform(request).andReturn();

        Gson gson = new Gson();
        ListsCountries actualData = gson.fromJson(result.getResponse().getContentAsString(),ListsCountries.class);

        assertEquals(3,actualData.getUsingCurrency().size());
        assertEquals(1,actualData.getBorderCountries().size());
    }

    @Test
    void getBoderInfo_JPY_DataTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/borderInfo?currency=JPY");
        MvcResult result = mvc.perform(request).andReturn();

        Gson gson = new Gson();

        ListsCountries listsCountries = gson.fromJson(result.getResponse().getContentAsString(),ListsCountries.class);
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