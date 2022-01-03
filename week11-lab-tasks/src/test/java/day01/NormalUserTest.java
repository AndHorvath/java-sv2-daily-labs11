package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NormalUserTest {

    NormalUser normalUser;

    @BeforeEach
    void setUp() {
        normalUser = new NormalUser("user@domain.ext", "password");
    }

    @Test
    void getEmailTest() {
        assertEquals("user@domain.ext", normalUser.getEmail());
    }

    @Test
    void getPasswordTest() {
        assertEquals("password", normalUser.getPassword());
    }
}