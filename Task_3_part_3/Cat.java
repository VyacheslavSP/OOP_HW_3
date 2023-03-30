enum command {
    giveFood, pat, call, command_voice,
}

public class Cat extends Animal {
    private int mills;
    private long time;

    public Cat(String fullName) {
        super(fullName);
    }

    private int getMills() {
        return mills;
    }

    private void setMills(int mills) {
        this.mills = mills;
        this.time = System.currentTimeMillis();
    }

    private long sleep() {
        return this.time + getMills();
    }

    public void setCommand(command command, Human human) {
        if (getValidStatus()) {
            switch (command) {
                case giveFood:
                    setValidStatus(false);
                    setVoice(" ест и слишком занят,чтобы отвечать");
                    System.out.println(getName() + getVoice());
                    // временая задержка//
                    setMills(10);
                    setValidStatus(true);
                    break;
                case pat:
                    setValidStatus(false);
                    setVoice(getName() + " мурлыкает");
                    System.out.println(getVoice());
                    setMills(0);
                    break;
                case call:
                    System.out.println(human.getFullName() + " зовет " + getName());
                    double a = Math.random();
                    if (a < 0.7) {
                        setValidStatus(false);
                        setVoice(getName() + " говорит Мяу");
                        System.out.println(getVoice());
                        setMills(0); // утановить задержку для ограничения выполнения действий
                    } else {
                        setVoice(getName() + " игнорирует " + human.getFullName());
                        System.out.println(getVoice());
                    }
                    break;
                case command_voice:
                    setVoice(getName() + " смотрит на " + human.getFullName()
                            + " как на идиота.(кошки не выполняют команду 'Голос')");
                    System.out.println(getVoice());
                    setValidStatus(false);
                    // очень большая временая задержка-котик обидился//
                    setMills(0); // утановить задержку для ограничения выполнения действий
            }
        } else {
            System.out.println(getName() + " занят");
            if (System.currentTimeMillis() > sleep()) {
                setValidStatus(true);
            }
        }
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setVoice(String voice) {
        super.setVoice(voice);
    }

    @Override
    public void voice() {
        System.out.println(this.name + " говорит Мяу");
    }

    @Override
    public void eat(Animal obj) {

        if (obj.getClass().getName() == Mouse.class.getName()) {
            Mouse Mouse = (Mouse) obj;
            System.out.println(this.name + " ест " + Mouse.getName());
            Mouse.setAlive(false);
        } else {
            System.out.println(this.name + " не может это съесть");
        }

    }
}