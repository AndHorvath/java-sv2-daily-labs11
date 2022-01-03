package day01;

public class NormalUser implements User {

    // --- attributes ---------------------------------------------------------

    private String email;
    private String password;

    // --- constructors -------------------------------------------------------

    public NormalUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // --- getters and setters ------------------------------------------------


    @Override
    public String getEmail() { return email; }

    @Override
    public String getPassword() { return password; }
}