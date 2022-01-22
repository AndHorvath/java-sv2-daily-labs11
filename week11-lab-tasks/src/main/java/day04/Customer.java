package day04;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    // --- attributes ---------------------------------------------------------

    private String name;
    private int money;
    private List<Item> items;

    // --- constructors -------------------------------------------------------

    public Customer(String name, int money) {
        this.name = name;
        this.money = money;
        this.items = new ArrayList<>();
    }

    // --- getters and setters ------------------------------------------------

    public String getName() { return name; }
    public int getMoney() { return money; }
    public List<Item> getItems() { return items; }

    // --- public methods -----------------------------------------------------

    public void addItem(Item item) {
        items.add(item);
    }

    public void decreaseMoney(int money) {
        this.money -= money;
    }
}