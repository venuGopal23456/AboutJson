package Treemodel;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;

public class JacksonTreeModelExample3 {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {

        try {

            JsonNode root = mapper.readTree(new File("C:\\Users\\Venu\\IdeaProjects\\jsonconversion\\user.json"));

            String resultOriginal = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
            System.out.println("Before Update " + resultOriginal);

            // 1. Update id to 1000
            ((ObjectNode) root).put("id", 1000L);

            // 2. If middle name is empty , update to M
            ObjectNode nameNode = (ObjectNode) root.path("name");
            if ("".equals(nameNode.path("middle").asText())) {
                nameNode.put("middle", "M");
            }

            // 3. Create a new field in nameNode
            nameNode.put("nickname", "mkyong");

            // 4. Remove last field in nameNode
            nameNode.remove("last");

            // 5. Create a new ObjectNode and add to root
            ObjectNode positionNode = mapper.createObjectNode();
            positionNode.put("name", "Developer");
            positionNode.put("years", 10);
            ((ObjectNode) root).set("position", positionNode);

            // 6. Create a new ArrayNode and add to root
            ArrayNode gamesNode = mapper.createArrayNode();

            ObjectNode game1 = mapper.createObjectNode().objectNode();
            game1.put("name", "Fall Out 4");
            game1.put("price", 49.9);

            ObjectNode game2 = mapper.createObjectNode().objectNode();
            game2.put("name", "Dark Soul 3");
            game2.put("price", 59.9);

            gamesNode.add(game1);
            gamesNode.add(game2);
            ((ObjectNode) root).set("games", gamesNode);

            // 7. Append a new Node to ArrayNode
            ObjectNode email = mapper.createObjectNode();
            email.put("type", "email");
            email.put("ref", "abc@mkyong.com");

            JsonNode contactNode = root.path("contact");
            ((ArrayNode) contactNode).add(email);

            String resultUpdate = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);

            System.out.println("After Update " + resultUpdate);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}