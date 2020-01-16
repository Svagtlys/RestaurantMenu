package restaurant;

import java.time.LocalDate;
import java.util.HashMap;

public class Menu {

    private String restaurantName;
    private LocalDate lastUpdated;
    private HashMap<String, MenuItem> itemsOnMenu;

    public Menu(String restaurantName)
    {
        this.restaurantName = restaurantName;
        this.lastUpdated = LocalDate.now();
        this.itemsOnMenu = new HashMap<>();
    }

    public void addItem(String name, String description, String category, double price) //Will change lastUpdated
    {
        if(itemsOnMenu.containsKey(name)){
            System.out.println("Item " + name + " already exists:");
            this.listItem(name);
            return;
        }
        this.lastUpdated = LocalDate.now();
        MenuItem newItem = new MenuItem(name, description, category, price);
        itemsOnMenu.put(name, newItem);
    }

    public void addItem(MenuItem newItem) //Will change lastUpdated
    {
        if(itemsOnMenu.containsKey(newItem.getName())){
            System.out.println("Item " + newItem.getName() + " already exists:");
            this.listItem(newItem.getName());
            return;
        }
        this.lastUpdated = LocalDate.now();
        itemsOnMenu.put(newItem.getName(), newItem);
    }

    public void removeItem(String name) //Removes related item from menu
    {
        if(itemsOnMenu.containsKey(name))
        {
            itemsOnMenu.remove(name);
            System.out.println("Removed menu item called " + name + ".");
            this.lastUpdated = LocalDate.now();
        } else {
            System.out.println("Menu item called " + name + " not found.");
        }
    }

    public void removeItem(MenuItem i)
    {
        if(itemsOnMenu.containsKey(i.getName()))
        {
            itemsOnMenu.remove(i.getName());
            System.out.println("Removed menu item called " + i.getName() + ".");
            this.lastUpdated = LocalDate.now();
        } else {
            System.out.println("Menu item called " + i.getName() + " not found.");
        }
    }

    private boolean isNewItem(MenuItem mi)
    {
        mi.setNewItem();
        return mi.isNewItem();
    }

    public void listNewItems() //Will update which items are new and then print out new items
    {
        for(String i: itemsOnMenu.keySet()){
            if(isNewItem(itemsOnMenu.get(i)))
            {
                System.out.println(i + " : Added " + itemsOnMenu.get(i).getDateCreated());
            }
        }
    }

    public void listLastUpdated() //Will print out the date that the menu was last updated
    {
        System.out.println("Last updated on: " + lastUpdated);
    }

    public void listItems() //Will print out keys in menu
    {
        for(String i : itemsOnMenu.keySet())
        {
            System.out.println(itemsOnMenu.get(i).toString());
        }
    }

    public void listItem(String item)
    {
        if(itemsOnMenu.containsKey(item))
        {
            System.out.println(itemsOnMenu.get(item).toString());
        } else {
            System.out.println("Menu item called " + item + " not found.");
        }
    }



}
