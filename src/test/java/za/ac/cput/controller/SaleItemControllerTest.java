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
import za.ac.cput.entity.SaleItem;
import za.ac.cput.factory.SaleItemFactory;
import za.ac.cput.util.GenericHelper;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaleItemControllerTest {
    private static SaleItem saleItem = SaleItemFactory.createSaleItem(GenericHelper.generateId(), GenericHelper.generateId());

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/saleItem/";

    @Test
    void getAllSalesItem() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
    }

    @Test
    void getSaleItem() {
        String url = BASE_URL + saleItem.getSaleItemId();
        ResponseEntity<SaleItem> response = restTemplate.getForEntity(url, SaleItem.class);
        assertEquals(saleItem.getSaleItemId(), response.getBody().getSaleItemId());
    }

    @Test
    void createSaleItem(){
        ResponseEntity<SaleItem> response = restTemplate.postForEntity(BASE_URL, saleItem, SaleItem.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void updateSaleItem(){
        ResponseEntity<SaleItem> response = restTemplate.postForEntity(BASE_URL, saleItem, SaleItem.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void deleteSaleItem(){
        String url = BASE_URL + saleItem.getSaleItemId();
        restTemplate.delete(url);
    }
}
