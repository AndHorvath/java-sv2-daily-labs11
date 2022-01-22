package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    Service service;
    Service other;

    @BeforeEach
    void setUp() {
        service = new Service("service", 1000);
    }

    @Test
    void getNameTest() {
        assertEquals("service", service.getName());
    }

    @Test
    void getPriceTest() {
        assertEquals(1000, service.getPrice());
    }

    @Test
    void getExpiryDateTest() {
        assertNull(service.getExpiryDate());
    }

    @Test
    void setExpireDateTest() {
        service.setExpiryDate(LocalDate.of(2030, 10, 20));
        assertEquals(LocalDate.of(2030, 10, 20), service.getExpiryDate());
    }

    @Test
    void copyTest() {
        other = service.copy();
        assertEquals("service", other.getName());
        assertEquals(1000, other.getPrice());
        assertEquals(Service.class, other.getClass());
    }

    @Test
    void setExpiryDateDefaultTest() {
        service.setExpiryDateDefault();
        assertEquals(LocalDate.now().plusMonths(3), service.getExpiryDate());
    }
}