public class Сhild extends People {

    public Сhild(String fullName) {
        super(fullName);
    }

    @Override
    public void get_access(Closet closet) {
        if (closet.getStatusDoor() == StatusDoor.open) {
            System.out.println("действие удачно.дверь уже была открыта");
        } else {
            System.out.println("действие невозможно. шкаф закрыт для детей");
        }
    }

    @Override
    public void terminate_access(Closet closet) {
        if (closet.getStatusDoor() != StatusDoor.open) {
            System.out.println("действие невозможно.дверь уже закрыта");
        } else {
            System.out.println("действие невозможно.у детей нет ключа");
        }
    }
}
