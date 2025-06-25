package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class InputStream {

    public static void main(String[] args) throws IOException {


        inputStream();

    }

    private static void inputStream() throws IOException {

        String path = "idempotency.json";

        java.io.InputStream is = InputStream.class.getClassLoader().getResourceAsStream(path);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(is);
        for (int i = 0; i < jsonNode.size(); i++) {
            JsonNode node = jsonNode.get(i);
            System.out.printf("Index %d: %s%n", i, node.toString());
        }

        Path path1 = Paths.get("src/main/resources/russell");
        try (Stream<Path> walk = Files.walk(path1)) {
            walk.filter(Files::isRegularFile).forEach(p ->{
                try {
                    JsonNode jsonNode1 = mapper.readTree(new File(p.toString()));
                    System.out.println(jsonNode1.toString());
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }
}
