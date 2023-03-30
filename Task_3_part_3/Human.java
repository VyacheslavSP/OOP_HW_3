public class Human {
    private String fullName;

    public Human(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public String toString() {
        return String.format("%s", getFullName());
    }
}
