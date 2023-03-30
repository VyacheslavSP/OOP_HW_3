import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Human Ivan = new Human("Иван");
        Cat Barsik = new Cat("Барсик");
        System.out.println(Barsik.getName());
        Barsik.setName("Barsik");
        System.out.println(Barsik.getName());
        Dog DOG = new Dog("Собака");
        System.out.println(DOG.getName());
        DOG.eat(null);
        DOG.voice();
        Mouse Mouse_1 = new Mouse("1 мышь");
        Mouse Mouse_2 = new Mouse("2 мышь");
        Mouse_1.eat(null);
        Mouse_2.voice();
        Barsik.eat(Mouse_2);
        Barsik.voice();
        System.out.println(Mouse_2.getAlive());
        Barsik.eat(DOG);
        ArrayList<Animal> zoo = new ArrayList<>();
        zoo.add(Barsik);
        zoo.add(DOG);
        zoo.add(Mouse_1);
        zoo.add(Mouse_2);
        Iterator<Animal> iterator = zoo.iterator();
        System.out.println("Работа со списком");
        for (Animal animal : zoo) {
            System.out.println(animal.getName());
        }
        while (iterator.hasNext()) {
            Animal next = iterator.next();
            if (next.getClass().getName() == Mouse.class.getName()) {
                Mouse Mouse = (Mouse) next;
                if (!(Mouse.getAlive())) {
                    iterator.remove();
                }
            }

        }
        for (Animal animal : zoo) {
            System.out.println(animal.getName());
        }
    }
}