package restaurant;

public class Restaurant {
    public static void main(String[] args)
    {
        Menu myMenu = new Menu("McDonald's");

        MenuItem i1 = new MenuItem("McDouble", "A large burger with delicious toppings.", MenuItem.ITEM_OPTIONS.get(1), 5.46);
        MenuItem i2 = new MenuItem("Chicken McNuggets", "Many pieces of fried mashed chicken in a box.", MenuItem.ITEM_OPTIONS.get(1), 3.42);
        MenuItem i3 = new MenuItem("McFlurry", "Because we can't get enough of the \"Mc\", gotta give it to you frozen!", MenuItem.ITEM_OPTIONS.get(2), 1.58);

        myMenu.addItem(i1);
        myMenu.addItem(i2);
        myMenu.addItem(i3);
        myMenu.addItem(i2);

        myMenu.listItems();
        myMenu.listItem("McFlurry");

        myMenu.removeItem("McFlurry");
        myMenu.listItems();
    }
}
