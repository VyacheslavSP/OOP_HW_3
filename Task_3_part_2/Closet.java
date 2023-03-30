import java.util.ArrayList;

enum StatusDoor {
    open, closet
}

public class Closet {
    private byte capacity;
    private StatusDoor statusDoor;
    private ArrayList<Item> itemsInCloset;
    public Closet(byte capacity) {
        this.capacity=capacity;
        this.statusDoor=StatusDoor.closet;
        ArrayList<Item> itemsInCloset =new ArrayList<>(capacity);
        this.itemsInCloset=itemsInCloset;
    }
    public byte getCapacity() {
        return capacity;
    }
    public StatusDoor getStatusDoor() {
        return statusDoor;
    }
    public ArrayList<Item> getItems() {
        return itemsInCloset;
    }
    public void setStatusDoor(StatusDoor statusDoor ) {
        this.statusDoor=statusDoor;
    }
    public void setElement (ArrayList<Item> itemsInCloset) {
        this.itemsInCloset=itemsInCloset;
    }
    public String toStringDoor(){
        return String.format("%s", getStatusDoor());
    }
    public StringBuilder toStringAllItems(){
      StringBuilder tmp_str= new StringBuilder();
      tmp_str.append("[");
        for (Item item : itemsInCloset) {
            tmp_str.append(item.name_item()+",");
        }
       if(tmp_str.length()!=1){
       tmp_str.replace( tmp_str.length()-1, tmp_str.length(), "]");
       }else{
        tmp_str.replace(0, 6, "пусто");
       }
        return  tmp_str;
   }
}
