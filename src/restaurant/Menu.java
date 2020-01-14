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
        this.lastUpdated = LocalDate.now();
        MenuItem newItem = new MenuItem(name, description, category, price);
        menu.put(name, newItem);
    }

    public void listItems() //Will print out keys in menu
    {
        for(String i : menu.keySet())
        {
            MenuItem curr = menu.get(i);
            System.out.println(curr.getName() + " : " + curr.getDescription() + " --- " + curr.getCategory() + " .... $" + curr.getPrice());
        }
    }

    public void listNewItems() //Will update which items are new and then print out new items
    {
        for(String i: menu.keySet()){
            menu.get(i).setNewItem();
            if(menu.get(i).isNewItem())
            {
                System.out.println(i + " : " + menu.get(i).getDateCreated());
            }
        }
    }

    public void removeItem(String name) //Removes related item from menu
    {
        if(menu.containsKey(name))
        {
            menu.remove(name);
            System.out.println("Removed menu item called " + name + ".");
        } else {
            System.out.println("Menu item called " + name + " not found.");
        }
    }

    public void listLastUpdated() //Will print out the date that the menu was last updated
    {
        System.out.println(lastUpdated);
    }

    public static void main(String[] args)
    {
        Menu myMenu = new Menu("McDonald's");
        myMenu.addItem("McDouble", "A large burger with delicious toppings.", MenuItem.ITEM_OPTIONS.get(1), 5.46);
        myMenu.addItem("Chicken McNuggets", "Many pieces of fried mashed chicken in a box.", MenuItem.ITEM_OPTIONS.get(1), 3.42);
        myMenu.addItem("McFlurry", "Because we can't get enough of the \"Mc\", gotta give it to you frozen!", MenuItem.ITEM_OPTIONS.get(2), 1.58);

        myMenu.listItems();

        myMenu.listNewItems();

        myMenu.listLastUpdated();

        myMenu.removeItem("McDouble");
        myMenu.removeItem("McRib");

        myMenu.listItems();

        myMenu.addItem("McRib", "Back by popular demand, because we want your money.", MenuItem.ITEM_OPTIONS.get(1), 7.50);

        myMenu.listNewItems();

    }

}
