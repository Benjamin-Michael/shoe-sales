package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Shoe;
import za.ac.cput.factory.ShoeFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoeControllerTest {

    private static Shoe shoe = ShoeFactory.createShoe("Nike", GenericHelper.generateId(), GenericHelper.generateId(), GenericHelper.generateId());

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/shoe/";

    @Test
    void getAllShoes() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
    }

    @Test
    void b_getShoe() {
        String url = BASE_URL + shoe.getShoeId();
        ResponseEntity<Shoe> response = restTemplate.getForEntity(url, Shoe.class);
        assertEquals(shoe.getShoeId(), response.getBody().getShoeId());
    }

    @Test
    void a_createShoe() {
        ResponseEntity<Shoe> response = restTemplate.postForEntity(BASE_URL, shoe, Shoe.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void updateShoe() {
    }

    @Test
    void e_deleteShoe() {
        String url = BASE_URL + shoe.getShoeId();
        restTemplate.delete(url);
    }
}