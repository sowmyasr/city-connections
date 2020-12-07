package com.mastercard.citiinfra.services;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class ConnectivityServiceTest {

    ConnectivityService connectivityService = new ConnectivityService();

    @Test
    public void loadCitiesWithWrongFile(){
        Map<String, Set<String>> adjacentCities = connectivityService.loadCities("abc.txt");
        Assert.assertNull(adjacentCities);
    }
    @Test
    public void loadCitiesWithWrongFomrat(){
        Map<String, Set<String>> adjacentCities = connectivityService.loadCities("abc.txt");
        Assert.assertNull(adjacentCities);
    }
    @Test
    public void loadCitiesWithRightFomrat(){
        Map<String, Set<String>> adjacentCities = connectivityService.loadCities("city.txt");
        Assert.assertNotNull(adjacentCities);
        Assert.assertTrue(adjacentCities.size()>0);
        Assert.assertEquals("yes",connectivityService.isConnected("Newark","New York"));
        Assert.assertEquals("yes",connectivityService.isConnected("New York","Newark"));
        Assert.assertEquals("no",connectivityService.isConnected("New York","ABC"));
    }
}
