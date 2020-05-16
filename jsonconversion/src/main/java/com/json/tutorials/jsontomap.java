package com.json.tutorials;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Map;
public class jsontomap {


    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"mkyong\", \"age\":\"37\"}";

        try {

            // convert JSON string to Map
            Map<String, String> map = mapper.readValue(json, Map.class);

            // it works
            //Map<String, String> map = mapper.readValue(json, new TypeReference<Map<String, String>>() {});

            System.out.println(map);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
