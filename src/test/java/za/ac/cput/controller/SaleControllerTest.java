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
import za.ac.cput.entity.Sale;
import za.ac.cput.factory.SaleFactory;
import za.ac.cput.util.GenericHelper;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SaleControllerTest {

    private static Sale sale = SaleFactory.createSale(GenericHelper.generateId(), "R1000", "16 August 2021");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/sale/";

    @Test
    void getAllSales() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
    }

    @Test
    void getSale() {
        String url = BASE_URL + sale.getSaleId();
        ResponseEntity<Sale> response = restTemplate.getForEntity(url, Sale.class);
        assertEquals(sale.getSaleId(), response.getBody().getSaleId());
    }

    @Test
    void createSale(){
        ResponseEntity<Sale> response = restTemplate.postForEntity(BASE_URL, sale, Sale.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void updateSale(){
        ResponseEntity<Sale> response = restTemplate.postForEntity(BASE_URL, sale, Sale.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void deleteSale(){
        String url = BASE_URL + sale.getSaleId();
        restTemplate.delete(url);
    }
}
