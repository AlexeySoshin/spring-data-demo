package me.soshin.springdatademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class SpringDataDemoApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @LocalServerPort
    Long port;

    @Test
    public void contextLoads() {
    }

    @Test
    public void findAll() {
        String expectedJson = getExpected("findAll-empty.json");
        webClient.get().uri("/api/customers/").exchange().expectBody().json(expectedJson);
    }

    @Test
    public void create() {
        webClient.post().uri("/api/customers")
                .header("Content-Type", "application/json")
                .syncBody(getJSON("create.json")).exchange().expectStatus().isCreated();
    }

    /**
     * Replaces default ports
     */
    private String getExpected(String name) {
        return getJSON(name).replace(":8080", ":" + port);
    }

    /**
     * Reads requested JSON to string
     */
    private String getJSON(String name) {
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(name)).toURI());
            return String.join("", Files.readAllLines(path));
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
