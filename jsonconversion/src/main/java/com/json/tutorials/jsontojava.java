package com.json.tutorials;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
public class jsontojava {


    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();


        try {

            // ignore the null fields globally
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            // JSON file to Java object
            Staff staff = mapper.readValue(new File("C:\\Users\\Venu\\IdeaProjects\\jsonconversion\\staff.json"), Staff.class);

            // JSON string to Java object
            String jsonInString = "{\"name\":\"mkyong\",\"age\":37,\"skills\":[\"java\",\"python\"]}";
            Staff staff2 = mapper.readValue(jsonInString, Staff.class);

            // compact print
            System.out.println(staff2);

            // pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff2);

            System.out.println(prettyStaff1);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
