package day04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WebShop {

    // --- attributes ---------------------------------------------------------

    private List<Item> items;
    private List<Customer> customers;

    // --- constructors -------------------------------------------------------

    public WebShop() {
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public WebShop(List<Item> items, List<Customer> customers) {
        this.items = items;
        this.customers = customers;
    }

    // --- getters and setters ------------------------------------------------

    public List<Item> getItems() { return items; }
    public List<Customer> getCustomers() { return customers; }

    // --- public methods -----------------------------------------------------

    public void addItem(Item item) {
        items.add(item);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public LocalDate getExpiryDateOfItem(Item item) {
        validateParameter(item);

        item.setExpiryDateDefault();
        return item.getExpiryDate();
    }

    public void purchaseItemByCustomer(String itemName, String customerName) {
        Item item = getItemByName(itemName);
        Customer customer = getCustomerByName(customerName);
        validateParameters(item, customer);

        purchaseItemByCustomer(item, customer);
    }

    // --- private methods ----------------------------------------------------

    private Item getItemByName(String name) {
        Item specifiedItem = null;
        for (Item item : items) {
            if (item.getName().equals(name)) {
                specifiedItem = item;
            }
        }
        return specifiedItem;
    }

    private Customer getCustomerByName(String name) {
        Customer specifiedCustomer = null;
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                specifiedCustomer = customer;
            }
        }
        return specifiedCustomer;
    }

    private void purchaseItemByCustomer(Item item, Customer customer) {
        validateFinancialConditions(item, customer);

        Item actualItem = item.copy();
        if (isPurchaseWithExtendedWarranty(actualItem, customer)) {
            ((Product) actualItem).setExtendedExpiryDate(3);
            customer.decreaseMoney(getIncreasedPrice(actualItem));
        } else {
            actualItem.setExpiryDateDefault();
            customer.decreaseMoney(actualItem.getPrice());
        }
        customer.addItem(actualItem);
    }

    private boolean isPurchaseWithExtendedWarranty(Item item, Customer customer) {
        return item instanceof Product && customer.getMoney() >= item.getPrice() * 3;
    }

    private int getIncreasedPrice(Item item) {
        return (int) Math.round(item.getPrice() * 1.1);
    }

    private void validateParameter(Item item) {
        if (item == null || !items.contains(item)) {
            throw new IllegalArgumentException("Specified item is not in assortment.");
        }
    }

    private void validateParameter(Customer customer) {
        if (customer == null || !customers.contains(customer)) {
            throw new IllegalArgumentException("Specified customer is not customer of the web shop.");
        }
    }

    private void validateParameters(Item item, Customer customer) {
        validateParameter(item);
        validateParameter(customer);
    }

    private void validateFinancialConditions(Item item, Customer customer) {
        if (customer.getMoney() < item.getPrice()) {
            throw new IllegalStateException("Insufficient purchasing power.");
        }
    }
}