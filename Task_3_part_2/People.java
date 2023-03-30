import java.util.ArrayList;

import java.util.Iterator;

public class People implements ActionInterface {
    public String name;
    private String fullName;

    public People(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String toString() {
        return String.format("%s", getFullName());
    }

    @Override
    public void put(Closet closet, Item item) {
        if (closet.getStatusDoor() == StatusDoor.open) {
            int count = closet.getCapacity() - closet.getItems().size();
            System.out.println("свободного места " + String.valueOf(count));
            if (count > 0) {
                ArrayList<Item> tmp = closet.getItems();
                tmp.add(item);
                closet.setElement(tmp);
                System.out.println("Действие удачно вещь " + item.name_item() + " добавлена");
            } else {
                System.out.println("действие невозможно. кончилось место");
            }
        } else {
            System.out.println("действие невозможно.дверь закрыта");
        }
    }

    @Override
    public void pull(Closet Closet, Item item) {
        ArrayList<Item> tmp = Closet.getItems();
        Iterator<Item> iterator = tmp.iterator();
        boolean flag = false;
        if (tmp.size() != 0) {
            while (iterator.hasNext()) {
                Item next = iterator.next();
                if (next.name_item() == item.name_item()) {
                    System.out.println("Взята вешь " + item.name_item());
                    iterator.remove();
                    System.out.println("свободного места " + tmp.size());
                    Closet.setElement(tmp);
                    flag = !flag;
                    break;
                }
            }
            if (!flag) {
                System.out.println("действие невозможно.такой вещи нет");
            }
        } else {
            System.out.println("действие невозможно.шкаф пуст");
        }
    }

    @Override
    public void get_access(Closet closet) {
        if (closet.getStatusDoor() == StatusDoor.open) {
            System.out.println("действие удачно.дверь уже открыта");
        } else {
            closet.setStatusDoor(StatusDoor.open);
            System.out.println("действие удачно.дверь открыта");
        }
    }

    @Override
    public void terminate_access(Closet closet) {
        if (closet.getStatusDoor() != StatusDoor.open) {
            System.out.println("действие невозможно.дверь уже закрыта");
        } else {
            System.out.println("действие удачно.дверь закрыта");
            closet.setStatusDoor(StatusDoor.closet);
        }
    }

}
