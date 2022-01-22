package day04;

import java.time.LocalDate;

public class Product extends Item {

    // --- constructors -------------------------------------------------------

    public Product(String name, int price) {
        super(name, price);
    }

    // --- public methods -----------------------------------------------------

    @Override
    public Product copy() {
        return new Product(name, price);
    }

    @Override
    public void setExpiryDateDefault() {
        setExpiryDate(LocalDate.now().plusYears(1));
    }

    public void setExtendedExpiryDate(int years) {
        setExpiryDateDefault();
        setExpiryDate(expiryDate.plusYears(years));
    }
}