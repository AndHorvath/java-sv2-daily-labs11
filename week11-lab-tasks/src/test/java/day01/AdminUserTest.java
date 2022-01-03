package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AdminUserTest {

    AdminUser adminUser;

    @BeforeEach
    void setUp() {
        adminUser = new AdminUser("user@domain.ext", "password");
    }

    @Test
    void getEmailTest() {
        assertEquals("user@domain.ext", adminUser.getEmail());
    }

    @Test
    void getPasswordTest() {
        assertEquals("********", adminUser.getPassword());
    }
}