import java.util.ArrayList;

public interface GeoTree {
    ArrayList<Node> tree = new ArrayList<>();

    void append(Person person1, Relationship re1, Person person2, Relationship re2);

    ArrayList<Node> getTree();
}