import java.util.ArrayList;

// у меня нет других идей как еще работать с интерфейсом гениологическое древо, не ломая полностью структкру задания
public class newGeo implements GeoTree {

    @Override
    public void append(Person person1, Relationship re1, Person person2, Relationship re2) {
        tree.add(new Node(person1, re1, person2));
        tree.add(new Node(person2, re2, person1));
    }

    @Override
    public ArrayList<Node> getTree() {
        return tree;
    }

}
