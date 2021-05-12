import java.util.ArrayList;

public class ElevatorsControl implements Runnable{
    private int num_floors;
    private int num_Elevators;
    private int capacity;
    private ArrayList<Elevator> elevators = new ArrayList<>();
    private ArrayList<Passenger> passengers = new ArrayList<>();

    ElevatorsControl(int num_floors, int num_Elevators, int capacity) {
        setNum_floors(num_floors);
        setNum_Elevators(num_Elevators);
        setCapacity(capacity);
        createElevators();
    }

    @Override
    public void run() {
        while(true) {
            System.out.println("Calls thread is working now");
            if(getPassengers().isEmpty()) {
                break;
            }
            for(Elevator e : getElevators()) {
                
            }
            for(Passenger p : getPassengers()) {

            }
        }
    }

    public void setNum_floors(int num) {
        this.num_floors = num;
    }

    public void setNum_Elevators(int num_Elevators) {
        this.num_Elevators = num_Elevators;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addElevator(Elevator elevator) {
        this.elevators.add(elevator);
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }

    public void createElevators() {
        for(int i = 0; i < num_Elevators; i++) {
            Elevator e = new Elevator(i, this.capacity);
            addElevator(e);
        }
    }

    public int getNum_floors() {
        return this.num_floors;
    }

    public int getNum_Elevators() {
        return this.num_Elevators;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Elevator> getElevators() {
        return this.elevators;
    }

    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }
}
