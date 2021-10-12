//Author: Faidh Adams 215060148
package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Return;
import za.ac.cput.factory.ReturnFactory;
import za.ac.cput.util.GenericHelper;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReturnControllerTest {

    private static Return returns = ReturnFactory.createReturn(GenericHelper.generateId(),"16 August 2021");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/return/";

    @Test
    void getAllReturns() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
    }

    @Test
    void getReturn() {
        String url = BASE_URL + returns.getReturnId();
        ResponseEntity<Return> response = restTemplate.getForEntity(url, Return.class);
        assertEquals(returns.getReturnId(), response.getBody().getReturnId());
    }

    @Test
    void createReturn(){
        ResponseEntity<Return> response = restTemplate.postForEntity(BASE_URL, returns, Return.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void updateReturn(){
        ResponseEntity<Return> response = restTemplate.postForEntity(BASE_URL, returns, Return.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void deleteReturn(){
        String url = BASE_URL + returns.getReturnId();
        restTemplate.delete(url);
    }
}
