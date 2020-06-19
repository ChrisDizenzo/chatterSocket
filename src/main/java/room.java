import java.util.LinkedList;
import java.util.Objects;

public class room {
    private final String room_id;
    private int occupancy;
    private final String eventName;
    private String description;
    private String time;
    private final LinkedList<chat> chats;

    public room(String id, String name, String desc, String t){
        room_id = id;
        occupancy = 0;
        eventName = name;
        description = desc;
        time = t;
        this.chats = new LinkedList<chat>();
    }

    public void addChat(chat c){
        chats.add(c);
    }

    public void userJoined(){
        occupancy++;
    }

    public void userLeft(){
        occupancy--;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public String getEventName() {
        return eventName;
    }

    public String getDescription() {
        return description;
    }

    public String getTime() {
        return time;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "room{" +
                "room_id='" + room_id + '\'' +
                ", occupancy=" + occupancy +
                ", eventName='" + eventName + '\'' +
                ", description='" + description + '\'' +
                ", time='" + time + '\'' +
                ", chats=" + chats +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        room room = (room) o;
        return room_id.equals(room.room_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(room_id);
    }
}
