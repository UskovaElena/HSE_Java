import java.util.ArrayList;

public class Elevator {
    private int id;
    private int cur_floor = 0;
    private int capacity;
    private int direction;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    Elevator(int id, int capacity) {
        setId(id);
        setCapacity(capacity);
        setCur_floor(0);
    }

    public void go() {
        for(Passenger p : getPassengers()) {
            if (p.getTo() == getCur_floor())
                passengers.remove(p);
        }
        setCur_floor(getCur_floor() + getDirection());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCur_floor(int cur_floor) {
        this.cur_floor = cur_floor;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void addPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    public int getId() {
        return this.id;
    }

    public int getCur_floor() {
        return this.cur_floor;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getDirection() {
        return this.direction;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }
}
