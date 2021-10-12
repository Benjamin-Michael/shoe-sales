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
import za.ac.cput.entity.Promotion;
import za.ac.cput.factory.PromotionFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PromotionControllerTest {
    private static Promotion promotion = PromotionFactory.newPromotion("VNS135",
            "VANS OFF 50%",
            50.00);

    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/promotion";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Promotion> postResponse = restTemplate.postForEntity(url, promotion , Promotion.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        promotion = postResponse.getBody();
        System.out.println("New Promotion : " + promotion);
        assertEquals(promotion.getPromotionId(), postResponse.getBody().getPromotionId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + promotion.getPromotionId();
        System.out.println("URL: " + url);
        ResponseEntity<Promotion> response = restTemplate.getForEntity(url, Promotion.class);
        assertEquals(promotion.getPromotionId(), response.getBody().getPromotionId());
    }

    @Test
    void c_update()
    {
        Promotion updated = new Promotion.Builder().copy(promotion).setDescription("NIKE OFF 25%").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<Promotion> response = restTemplate.postForEntity(url, updated, Promotion.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete()
    {
        String url = baseURL + "/delete/" + promotion.getPromotionId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll()
    {
        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All Promotions : ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}