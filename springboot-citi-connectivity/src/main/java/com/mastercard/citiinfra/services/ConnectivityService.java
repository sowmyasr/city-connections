package com.mastercard.citiinfra.services;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

@Service
public class ConnectivityService {
    public Map<String, Set<String>> adjacentCities;

    public static final String fileName = "city.txt";
    public static final String YES = "yes";
    public static final String NO = "no";
    public Map<String, Set<String>> loadCities(String fileName) {
        adjacentCities = new HashMap<>();

        try{
            FileReader fr=new FileReader(new ClassPathResource(fileName).getFile());   //reads the file
            BufferedReader br=new BufferedReader(fr);
            String line;
            while((line=br.readLine())!=null) {
                System.out.println(line);
                String[] road = line.split(",");
                if(road.length!=2) return null;
                String from = road[0].toLowerCase().trim();
                String to = road[1].toLowerCase().trim();

                if (!adjacentCities.containsKey(from))
                    adjacentCities.put(from, new HashSet<>());
                adjacentCities.get(from).add(to);
                if (!adjacentCities.containsKey(to))
                    adjacentCities.put(to, new HashSet<>());
                adjacentCities.get(to).add(from);
            }

            fr.close();
        }catch(Exception e){
            System.out.println("Format is not correct or wrong file is correct");
            return null;

        }
        return adjacentCities;

    }
    public String isConnected(String from, String to){
        if(adjacentCities==null)
            loadCities(fileName);
        Set<String> set = getConnectedCitis(from, to);
        return set.contains(to.toLowerCase())? YES : NO;
    }

    private HashSet<String> getConnectedCitis(String origin, String destination) {
        HashSet<String> set = new HashSet<>();
        set.add(origin.toLowerCase());
        visitAllCities(origin.toLowerCase(),set);
        return  set;
    }

    private void visitAllCities(String origin, HashSet<String> set) {
        for(String city:adjacentCities.get(origin)){
            if(set.contains(city)) continue;
            else{
                set.add(city);
                visitAllCities(city, set);
            }
        }
    }


    //private static void visitAllAdjacent()

}
