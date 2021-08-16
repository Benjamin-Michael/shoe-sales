package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.entity.ShoePromotion;
import za.ac.cput.factory.PromotionFactory;
import za.ac.cput.factory.ShoePromotionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ShoePromotionControllerTest {

    private static ShoePromotion shoePromotion = ShoePromotionFactory.newShoePromotion("VNS135",
            "VSKU1234",
            "01 August 2021",
            "30 Augsut 2021");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/shoePromotion";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<ShoePromotion> postResponse = restTemplate.postForEntity(url, shoePromotion, ShoePromotion.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        shoePromotion = postResponse.getBody();
        System.out.println("New Promotion : " + shoePromotion);
        assertEquals(shoePromotion.getPromotionId(), postResponse.getBody().getPromotionId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + shoePromotion.getPromotionId();
        System.out.println("URL: " + url);
        ResponseEntity<ShoePromotion> response = restTemplate.getForEntity(url, ShoePromotion.class);
        assertEquals(shoePromotion.getPromotionId(), response.getBody().getPromotionId());
    }

    @Test
    void c_update()
    {
        ShoePromotion updated = new ShoePromotion.Builder().copy(shoePromotion).setStartDate("15 August 2021").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<ShoePromotion> response = restTemplate.postForEntity(url, updated, ShoePromotion.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = baseURL + "/delete/" + shoePromotion.getPromotionId();
        System.out.println("URL : " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All Shoe Promotions : ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}