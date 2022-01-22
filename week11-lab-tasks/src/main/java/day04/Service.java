package day04;

import java.time.LocalDate;

public class Service extends Item {

    // --- constructors -------------------------------------------------------

    public Service(String name, int price) {
        super(name, price);
    }

    // --- public methods -----------------------------------------------------

    @Override
    public Service copy() {
        return new Service(name, price);
    }

    @Override
    public void setExpiryDateDefault() {
        setExpiryDate(LocalDate.now().plusMonths(3));
    }
}