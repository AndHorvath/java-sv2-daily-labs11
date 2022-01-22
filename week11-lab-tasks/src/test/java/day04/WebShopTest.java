package day04;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WebShopTest {

    WebShop webShop;
    WebShop other;
    Item product;
    Item service;
    Customer customer;
    Throwable exception;

    @BeforeEach
    void setUp() {
        product = new Product("product", 2000);
        service = new Service("service", 1000);
        customer = new Customer("John Doe", 7000);
        webShop = new WebShop(
            new ArrayList<>(List.of(product, service)), new ArrayList<>(List.of(customer)));
        other = new WebShop();
    }

    @Test
    void getItemsTest() {
        assertEquals(new ArrayList<>(List.of(product, service)), webShop.getItems());
        assertEquals(new ArrayList<>(List.of()), other.getItems());
    }

    @Test
    void getCustomersTest() {
        assertEquals(new ArrayList<>(List.of(customer)), webShop.getCustomers());
        assertEquals(new ArrayList<>(List.of()), other.getCustomers());
    }

    @Test
    void addItemTest() {
        other.addItem(product);
        other.addItem(service);
        assertEquals(new ArrayList<>(List.of(product, service)), other.getItems());
    }

    @Test
    void addCustomerTest() {
        other.addCustomer(customer);
        assertEquals(new ArrayList<>(List.of(customer)), other.getCustomers());
    }

    @Test
    void getExpiryDateOfItemTest() {
        assertEquals(LocalDate.now().plusYears(1), webShop.getExpiryDateOfItem(product));
        assertEquals(LocalDate.now().plusMonths(3), webShop.getExpiryDateOfItem(service));
    }

    @Test
    void getExpireDatOfItemTestInvalid() {
        exception = assertThrows(
            IllegalArgumentException.class,
            () -> webShop.getExpiryDateOfItem(new Product("other", 2000)));
        assertEquals("Specified item is not in assortment.", exception.getMessage());
    }

    @Test
    void purchaseItemByCustomerTest() {
        webShop.purchaseItemByCustomer("product", "John Doe");
        assertEquals(1, customer.getItems().size());
        assertEquals(LocalDate.now().plusYears(4), customer.getItems().get(0).getExpiryDate());
        assertEquals(LocalDate.now().plusYears(1), webShop.getExpiryDateOfItem(product));
        assertEquals(4800, customer.getMoney());

        webShop.purchaseItemByCustomer("service", "John Doe");
        assertEquals(2, customer.getItems().size());
        assertEquals(LocalDate.now().plusMonths(3), customer.getItems().get(1).getExpiryDate());
        assertEquals(3800, customer.getMoney());

        webShop.purchaseItemByCustomer("product", "John Doe");
        assertEquals(3, customer.getItems().size());
        assertEquals(LocalDate.now().plusYears(1), customer.getItems().get(2).getExpiryDate());
        assertEquals(1800, customer.getMoney());
    }

    @Test
    void purchaseItemByCustomerTestInvalid() {
        exception = assertThrows(
            IllegalArgumentException.class,
            () -> webShop.purchaseItemByCustomer("other", "John Doe"));
        assertEquals("Specified item is not in assortment.", exception.getMessage());

        exception = assertThrows(
            IllegalArgumentException.class,
            () -> webShop.purchaseItemByCustomer("product", "Jane Doe"));
        assertEquals("Specified customer is not customer of the web shop.", exception.getMessage());

        webShop.purchaseItemByCustomer("product", "John Doe");
        webShop.purchaseItemByCustomer("service", "John Doe");
        webShop.purchaseItemByCustomer("product", "John Doe");
        exception = assertThrows(
            IllegalStateException.class,
            () -> webShop.purchaseItemByCustomer("product", "John Doe"));
        assertEquals("Insufficient purchasing power.", exception.getMessage());
    }
}