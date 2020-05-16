package Streaming;


import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonGeneratorJson {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try (JsonGenerator jGenerator =
                     mapper.getFactory().createGenerator(
                             new File("C:\\Users\\Venu\\IdeaProjects\\jsonconversion\\jsonGeneratorJson.json")
                             , JsonEncoding.UTF8)) {

            jGenerator.writeStartObject();                                  // {

            jGenerator.writeStringField("name", "mkyong");  				// "name" : "mkyong"
            jGenerator.writeNumberField("age", 38);         				// "age" : 38

            jGenerator.writeFieldName("messages");                          // "messages" :

            jGenerator.writeStartArray();                                   // [

            jGenerator.writeString("msg 1");                            		// "msg 1"
            jGenerator.writeString("msg 2");                            		// "msg 2"
            jGenerator.writeString("msg 3");                            		// "msg 3"

            jGenerator.writeEndArray();                                     // ]

            jGenerator.writeEndObject();                                    // }

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

