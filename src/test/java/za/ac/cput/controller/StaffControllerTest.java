package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Staff;
import za.ac.cput.factory.StaffFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class StaffControllerTest {
   private static Staff staff = StaffFactory.createStaff("Phiy","Jay");
    @Autowired
    private TestRestTemplate restTemplate;

    private final String baseURL = "http://localhost:8080/staff";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Staff> postResponse = restTemplate.postForEntity(url, staff , Staff.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        staff = postResponse.getBody();
        System.out.println("New Staff : " + staff);
        assertEquals(staff.getStaffId(), postResponse.getBody().getStaffId());
    }
    @Test
    void b_read() {
        String url = baseURL + "/read/" + staff.getStaffId();
        System.out.println("URL: " + url);
        ResponseEntity<Staff> response = restTemplate.getForEntity(url, Staff.class);
        assertEquals(staff.getStaffId(), response.getBody().getStaffId());
    }
    @Test
    void c_update()
    {
        Staff updated = new Staff.Builder().copy(staff).setFirstName("Azola").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<Staff> response = restTemplate.postForEntity(url, updated, Staff.class);
        assertNotNull(response.getBody());
    }
    @Test
    void e_delete()
    {
        String url = baseURL + "/delete/" + staff.getStaffId();
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
        System.out.println("Show staff : ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}


