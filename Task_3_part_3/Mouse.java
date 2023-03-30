public class Mouse extends Animal {
    private boolean alive;

    public Mouse(String name) {
        super(name);
        setAlive(true);

    }

    @Override
    public void voice() {
        System.out.println(this.name + " пищит");

    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Boolean getAlive() {
        return alive;
    }

}
