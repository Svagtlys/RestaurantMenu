package restaurant;

import java.time.LocalDate;
import java.util.HashMap;

public class Menu {

    private String restaurantName;
    private LocalDate lastUpdated;
    private HashMap<String, MenuItem> menu;

    public Menu(String restaurantName)
    {
        this.restaurantName = restaurantName;
        this.lastUpdated = LocalDate.now();
        menu = new HashMap<>();
    }

    public void addItem(String name, String description, String category, double price) //Will change lastUpdated
    {
        if(menu.containsKey(name)){
            System.out.println("Item " + name + " already exists:");
            this.listItem(name);
            return;
        }
        this.lastUpdated = LocalDate.now();
        MenuItem newItem = new MenuItem(name, description, category, price);
        menu.put(name, newItem);
    }

    public void addItem(MenuItem i) //Will change lastUpdated
    {
        if(menu.containsKey(i.getName())){
            System.out.println("Item " + i.getName() + " already exists:");
            this.listItem(i.getName());
            return;
        }
        this.lastUpdated = LocalDate.now();
        menu.put(i.getName(), i);
    }

    public void removeItem(String name) //Removes related item from menu
    {
        if(menu.containsKey(name))
        {
            menu.remove(name);
            System.out.println("Removed menu item called " + name + ".");
            this.lastUpdated = LocalDate.now();
        } else {
            System.out.println("Menu item called " + name + " not found.");
        }
    }

    public void removeItem(MenuItem i)
    {
        if(menu.containsKey(i.getName()))
        {
            menu.remove(i.getName());
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
        for(String i: menu.keySet()){
            if(isNewItem(menu.get(i)))
            {
                System.out.println(i + " : Added " + menu.get(i).getDateCreated());
            }
        }
    }

    public void listLastUpdated() //Will print out the date that the menu was last updated
    {
        System.out.println("Last updated on: " + lastUpdated);
    }

    public void listItems() //Will print out keys in menu
    {
        for(String i : menu.keySet())
        {
            System.out.println(menu.get(i).toString());
        }
    }

    public void listItem(String item)
    {
        if(menu.containsKey(item))
        {
            System.out.println(menu.get(item).toString());
        } else {
            System.out.println("Menu item called " + item + " not found.");
        }
    }



}
