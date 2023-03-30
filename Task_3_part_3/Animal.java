
public abstract class Animal implements Interface {
    public String name;
    public boolean validStatus;
    private String voice;

    public Animal(String name) {
        this.name = name;
        this.validStatus = true;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }

    public String getVoice() {
        return voice;
    }

    public void setValidStatus(boolean status) {
        this.validStatus = status;
    }

    public boolean getValidStatus() {
        return validStatus;
    }

    public void eat(Animal Animal) {
        System.out.println(this.name + " ест корм");
    }
}