package day04;

import java.time.LocalDate;

public abstract class Item {

    // --- attributes ---------------------------------------------------------

    protected String name;
    protected int price;
    protected LocalDate expiryDate;

    // --- constructors -------------------------------------------------------

    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public int getPrice() { return price; }
    public LocalDate getExpiryDate() { return expiryDate; }

    public void setExpiryDate(LocalDate expiryDate) { this.expiryDate = expiryDate; }

    // --- public methods -----------------------------------------------------

    public abstract Item copy();
    public abstract void setExpiryDateDefault();
}