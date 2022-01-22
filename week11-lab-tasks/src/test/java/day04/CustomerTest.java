package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    Customer customer;
    Item product;
    Item service;

    @BeforeEach
    void setUp() {
        customer = new Customer("John Doe", 1000);
    }

    @Test
    void getNameTest() {
        assertEquals("John Doe", customer.getName());
    }

    @Test
    void getMoneyTest() {
        assertEquals(1000, customer.getMoney());
    }

    @Test
    void getItemsTest() {
        assertEquals(0, customer.getItems().size());
    }

    @Test
    void addItemTest() {
        product = new Product("product", 2000);
        service = new Service("service", 1000);
        customer.addItem(product);
        customer.addItem(service);

        assertEquals(2, customer.getItems().size());
        assertEquals("product", customer.getItems().get(0).getName());
        assertEquals("service", customer.getItems().get(1).getName());
        assertEquals(2000, customer.getItems().get(0).getPrice());
        assertEquals(1000, customer.getItems().get(1).getPrice());
    }

    @Test
    void decreaseMoneyTest() {
        customer.decreaseMoney(100);
        assertEquals(900, customer.getMoney());
    }
}