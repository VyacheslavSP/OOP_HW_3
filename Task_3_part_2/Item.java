public class Item {
    private String name_item;

    public Item(String name_item) {
        this.name_item = name_item;
    }

    public String name_item() {
        return name_item;

    }

    @Override
    public boolean equals(Object obj) { /// я не совсем понимаю практическое применение этого. Ведь по сути, даже если
                                        /// мы
                                        /// создали 2 одинаковых элемента(все поля одинаковы) то по сути это все равно 2
                                        /// разных элемента (как минимум отличается хэш)т.е. сама идея сравнивать
                                        /// объекты как таковые по всем полям несостоятельна для всех случаев,кроме
                                        /// когда будет попытка сравнить объект сам с собой. или я совсем запутался
        if (obj == null) {
            return false;
        } else if (this.getClass() != obj.getClass()) {
            return false;
        } else if (obj.getClass() == this.getClass()) {
            Item nowItmem = (Item) obj;
            if (this.name_item() == nowItmem.name_item()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}