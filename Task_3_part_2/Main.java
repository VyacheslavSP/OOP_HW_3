import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        byte capacity = 30;
        Closet myCloset = new Closet(capacity);
        Human myHuman = new Human("тестовый человек");
        Сhild myHumanChild = new Сhild("тестовый ребенок");
        Item item_1 = new Item("пальто");
        Item item_2 = new Item("куртка");
        Item item_3 = new Item("пуховик");
        Item item_4 = new Item("шапка");
        Item item_5 = new Item("шляпа");
        Item errorItem_1 = new Item("Дублирующая вещь");
        Item errorItem_2 = new Item("Дублирующая вещь");
        Random rand = new Random();
        ArrayList<Item> itemsList = new ArrayList<>();
        itemsList.add(item_1);
        itemsList.add(item_2);
        itemsList.add(item_3);
        itemsList.add(item_4);
        itemsList.add(item_5);

        System.out.println(itemsList.size());
        myHuman.get_access(myCloset);
        myHuman.get_access(myCloset);

        for (int i = 0; i < 31; i++) {
            myHuman.put(myCloset, itemsList.get(rand.nextInt(itemsList.size())));
        }

        for (int i = 0; i < 35; i++) {
            Item tmp = itemsList.get(rand.nextInt(itemsList.size()));
            System.out.println("попытка достать " + tmp.name_item());
            myHuman.pull(myCloset, tmp);
        }
        for (int i = 0; i < 10; i++) {
            myHuman.put(myCloset, itemsList.get(rand.nextInt(itemsList.size())));
        }
        myHuman.terminate_access(myCloset);
        myHumanChild.get_access(myCloset);
        myHuman.get_access(myCloset);
        myHumanChild.get_access(myCloset);
        for (int i = 0; i < 31; i++) {
            myHumanChild.put(myCloset, itemsList.get(rand.nextInt(itemsList.size())));
        }
        for (int i = 0; i < 10; i++) {
            myHuman.pull(myCloset, itemsList.get(rand.nextInt(itemsList.size())));
        }
        System.out.println(myCloset.toStringAllItems());
        System.out.println(errorItem_1.equals(errorItem_2));

    }

}