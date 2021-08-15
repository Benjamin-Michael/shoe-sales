package za.ac.cput.controller;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Shoe;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import za.ac.cput.util.GenericHelper;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class StaffControllerTest {
    private static Staff staff = StaffFactory.createStaff("101","Phofu","Gum");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/staff/";
    @Test
    void getAllStaff() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
    }

    @Test
    void b_getStaff() {
        String url = BASE_URL + staff.getStaffId();
        ResponseEntity<Staff> response = restTemplate.getForEntity(url, Staff.class);
        assertEquals(staff.getStaffId(), response.getBody().getStaffId());
    }

    @Test
    void a_createStaff() {
        ResponseEntity<Staff> response = restTemplate.postForEntity(BASE_URL, staff, Staff.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void updateStaff() {
    }

    @Test
    void e_deleteStaff() {
        String url = BASE_URL + staff.getStaffId();
        restTemplate.delete(url);
    }
}

