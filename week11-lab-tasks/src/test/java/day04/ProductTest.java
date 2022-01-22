package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product product;
    Product other;

    @BeforeEach
    void setUp() {
        product = new Product("product", 1000);
    }

    @Test
    void getNameTest() {
        assertEquals("product", product.getName());
    }

    @Test
    void getPriceTest() {
        assertEquals(1000, product.getPrice());
    }

    @Test
    void getExpiryDateTest() {
        assertNull(product.getExpiryDate());
    }

    @Test
    void setExpiryDateTest() {
        product.setExpiryDate(LocalDate.of(2030, 10, 20));
        assertEquals(LocalDate.of(2030, 10, 20), product.getExpiryDate());
    }

    @Test
    void copyTest() {
        other = product.copy();
        assertEquals("product", other.getName());
        assertEquals(1000, other.getPrice());
        assertEquals(Product.class, other.getClass());
    }

    @Test
    void setExpiryDateDefaultTest() {
        product.setExpiryDateDefault();
        assertEquals(LocalDate.now().plusYears(1), product.getExpiryDate());
    }

    @Test
    void setExtendedExpiryDateTest() {
        product.setExtendedExpiryDate(3);
        assertEquals(LocalDate.now().plusYears(4), product.getExpiryDate());
    }
}