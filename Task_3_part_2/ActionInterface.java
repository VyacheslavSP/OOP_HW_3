
interface ActionInterface {
    void put(Closet closet, Item item);

    void pull(Closet closet, Item item);

    void get_access(Closet closet);

    void terminate_access(Closet closet);

}
