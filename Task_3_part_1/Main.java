import java.util.ArrayList;
import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Person masha = new Person("Маша", 60, "Female", UUID.randomUUID().toString()); 
        Person toma = new Person("Тома", 65, "Female", "1");
        Person irina = new Person("Ирина", 40, "Female", "2");
        Person vasya = new Person("Вася", 42, "Male", "3");
        Person jane = new Person("Женя", 10, "Female", "4");
        Person ivan = new Person("Ваня", 20, "Male", "5");
        Person maxim = new Person(null, 80, "Male", "6");
        ArrayList<Person> MyPerson = new ArrayList<>();
        MyPerson.add(masha);
        MyPerson.add(toma);
        MyPerson.add(irina);
        MyPerson.add(vasya);
        MyPerson.add(jane);
        MyPerson.add(ivan);
        MyPerson.add(maxim);
        newGeo gt = new newGeo();

        gt.append(masha, Relationship.parent, irina, Relationship.children);
        gt.append(toma, Relationship.parent, vasya, Relationship.children);
        gt.append(irina, Relationship.wife, vasya, Relationship.husband);
        gt.append(irina, Relationship.parent, jane, Relationship.children);
        gt.append(irina, Relationship.parent, ivan, Relationship.children);
        gt.append(maxim, Relationship.parent, irina, Relationship.children);
        System.out.println(irina); // вывод информации о персоне (без служебного ID)

        print(gt, vasya, Relationship.husband); 
        
        String find_ID = "6";
        Person x = null;
        for (Person tmp : MyPerson) {
            if (tmp.getID() == find_ID) {
                x = tmp;
            }
        }
        if (x != null) {
            print(gt, x, SearchID.grandParent); // результат
        }

    }

    static void print(GeoTree tree, Person name, Relationship re) {
        System.out.printf("%s - %s по отношению к: ", name, re.toString());
        System.out.println(new Research(tree).spend(name, re));
    }

    static void print(GeoTree tree, Person name, SearchRe re) {
        String st = "";
        if (re == SearchRe.grandParent) {
            if (name.getGender() == "Female")
                st = "GrandMother";
            else if (name.getGender() == "Male")
                st = "GrandFather";
        } else if (re == SearchRe.grandChildren) {
            if (name.getGender() == "Male")
                st = "GrandSon";
            else if (name.getGender() == "Female")
                st = "GrandDaughter";
        }
        System.out.printf("%s - %s по отношению к: ", name, st);
        System.out.println(new Research(tree).spend(name, re));
    }

    static void print(GeoTree tree, Person iDPerson, SearchID re) {
        String st = "";
        if (re == SearchID.grandParent) {

            if (iDPerson.getGender() == "Female")
                st = "GrandMother";
            else if (iDPerson.getGender() == "Male")
                st = "GrandFather";
        } else if (re == SearchID.grandChildren) {
            if (iDPerson.getGender() == "Male")
                st = "GrandSon";
            else if (iDPerson.getGender() == "Female")
                st = "GrandDaughter";
        }
        String str1 = Integer.toString(iDPerson.getAge());
        str1=iDPerson.getFullName()+" возрастом "+str1+" " +st+" ";
        System.out.print(str1);
        System.out.println(new Research(tree).spend(iDPerson, re));
    }

    static void print(GeoTree tree, SearchAge se, int age) {
        String st = "";
        if (se == SearchAge.ageYounger)
            st = "до";
        else if (se == SearchAge.ageOlder)
            st = "от";
        System.out.printf("Люди %s %d: ", st, age);
        System.out.println(new Research(tree).spend(se, age));
    }

    static void print(GeoTree tree, Gender ge) {
        System.out.printf("Выводим всех %s: ", ge);
        System.out.println(new Research(tree).spend(ge));
    }
}