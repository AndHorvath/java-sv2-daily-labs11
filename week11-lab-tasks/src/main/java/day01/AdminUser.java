package day01;

public class AdminUser implements User {

    // --- attributes ---------------------------------------------------------

    private String email;
    private String password;

    // --- constructors -------------------------------------------------------

    public AdminUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // --- getters and setters ------------------------------------------------

    @Override
    public String getEmail() { return email; }

    // --- public methods -----------------------------------------------------

    @Override
    public String getPassword() {
        return "*".repeat(password.length());
    }
}