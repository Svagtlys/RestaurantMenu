package restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuItem {

    public final static ArrayList<String> ITEM_OPTIONS = new ArrayList<>(Arrays.asList("Appetizer", "Main Course", "Dessert"));

    private String name, description, category;
    private double price;
    private boolean isNewItem;
    private LocalDate dateCreated;

    public MenuItem(String name, String description, String category, double price)
    {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isNewItem = true;
        this.dateCreated = LocalDate.now();

        if(! ITEM_OPTIONS.contains(this.category))
        {
            this.category = "Appetizer";
        }

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public boolean isNewItem() {
        return isNewItem;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNewItem() {
        if(dateCreated.isBefore(LocalDate.now().minusMonths(1))) //if date created is over a month ago, then no longer new
        {
            this.isNewItem = false;
        }
    }
}
