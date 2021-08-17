package za.ac.cput.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.StaffRole;
import za.ac.cput.factory.StaffRoleFactory;

import static org.junit.jupiter.api.Assertions.*;

class StaffRoleControllerTest {
    private static StaffRole staffRole = StaffRoleFactory.createStaffRole("1051","Manage the till");

    @Autowired
    private TestRestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:8080/staffRole/";
    @Test
    void getAllStaffRole() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, entity, String.class);
    }

    @Test
    void b_getStaffRole() {
        String url = BASE_URL + staffRole.getRoleId();
        ResponseEntity<StaffRole> response = restTemplate.getForEntity(url, StaffRole.class);
        assertEquals(staffRole.getRoleId(), response.getBody().getRoleId());
    }

    @Test
    void a_createStaffRole() {
        ResponseEntity<StaffRole> response = restTemplate.postForEntity(BASE_URL, staffRole, StaffRole.class);
        assertNotNull(response.getBody());
        System.out.println(response.getBody());
    }

    @Test
    void updateStaffRole() {
    }

    @Test
    void e_deleteStaff() {
        String url = BASE_URL + staffRole.getRoleId();
        restTemplate.delete(url);
    }
}



