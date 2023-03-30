import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

// у меня нет других идей как еще работать с интерфейсом гениологическое древо, не ломая полностью структкру задания
public class newGeo implements GeoTree, Interface_write_read__to_txt {

    @Override
    public void append(Person person1, Relationship re1, Person person2, Relationship re2) {
        tree.add(new Node(person1, re1, person2));
        tree.add(new Node(person2, re2, person1));
    }

    @Override
    public ArrayList<Node> getTree() {
        return tree;
    }

    @Override
    public void write(GeoTree tree) {
        try (FileWriter writer = new FileWriter("GeoTree.txt", false)) {
            for (Node node : newGeo.tree) {
                writer.append(node.toString());
                writer.append('\n');
            }
            writer.flush();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public newGeo read(ArrayList<Person> MyPerson) {
        newGeo gt = new newGeo();
        String tmp = new String();

        try (FileReader reader = new FileReader("GeoTree.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                tmp = tmp + ((char) c);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        String[] tmp_node = tmp.split("\n"); // разбили по узлам
        for (int j = 0; j < tmp_node.length; j++) {
            if (j % 2 == 0) {
                String[] tmp_node_element = tmp_node[j].split("\\s");
                Person tmp_P_1 = new Person("Null", 0, "Female", "1");// создали временного перса
                Person tmp_P_2 = new Person("Null", 0, "Female", "1");
                Relationship tmRelationship_1 = Relationship.parent; // временые отношения
                Relationship tmRelationship_2 = Relationship.parent;
                for (int i = 0; i < tmp_node_element.length; i++) {
                    boolean Find_person = false;
                    if (i == 0) {
                        Iterator<Person> iterator = MyPerson.iterator();
                        tmp_P_1.setFullName(tmp_node_element[i]);// прописали имя
                        while (iterator.hasNext()) { // поискали имя в списке персон
                            Person Search = iterator.next();
                            if (Search.equals(tmp_P_1)) { // если что то сошлось
                                tmp_P_1 = Search; // присваеваем 1 персоне
                                Find_person = true;
                                break;
                            }
                        }
                        // если ничего не найдено
                        if (!Find_person) { // создай правильного временного перса
                            String new_Name = tmp_node_element[i].split("<")[1].split(":")[0];
                            tmp_P_1.setFullName(new_Name);
                            tmp_P_1.setAge(Integer.valueOf(tmp_node_element[i + 1]));
                            tmp_P_1.setGender(tmp_node_element[i + 2]);
                            tmp_P_1.setID(UUID.randomUUID().toString());
                        }
                    }
                    if (i == 3) {

                        switch (tmp_node_element[i]) {
                            case "parent":
                                tmRelationship_1 = Relationship.parent;
                                tmRelationship_2 = Relationship.children;
                                break;
                            case "children":
                                tmRelationship_1 = Relationship.children;
                                tmRelationship_2 = Relationship.parent;
                                break;
                            case "husband":
                                tmRelationship_1 = Relationship.husband;
                                tmRelationship_2 = Relationship.wife;
                                break;
                            case "wife":
                                tmRelationship_1 = Relationship.wife;
                                tmRelationship_2 = Relationship.husband;
                                break;
                            case "grandParent":
                                tmRelationship_1 = Relationship.grandParent;
                                tmRelationship_2 = Relationship.grandChildren;
                                break;
                            case "grandChildren":
                                tmRelationship_1 = Relationship.grandChildren;
                                tmRelationship_2 = Relationship.grandParent;
                                break;
                        }
                    }
                    if (i == 4) {
                        Iterator<Person> iterator = MyPerson.iterator();
                        tmp_P_2.setFullName(tmp_node_element[i]);
                        while (iterator.hasNext()) {
                            Person Search = iterator.next();
                            if (Search.equals(tmp_P_2)) {
                                tmp_P_2 = Search; // присваеваем 2 персоне
                                Find_person = true;
                                break;
                            }
                        }
                        // если ничего не найдено
                        if (!Find_person) { // создай правильного временного перса
                            String new_Name = tmp_node_element[i].split(":")[0];
                            tmp_P_2.setFullName(new_Name);
                            tmp_P_2.setAge(Integer.valueOf(tmp_node_element[i + 1]));
                            tmp_P_2.setGender(tmp_node_element[i + 2].split(">")[0]);
                            tmp_P_2.setID(UUID.randomUUID().toString());
                        }
                    }
                } // после всего этого безобразия записали в дерево
                gt.append(tmp_P_1, tmRelationship_1, tmp_P_2, tmRelationship_2);
            }

        }
        return gt;
    }
}