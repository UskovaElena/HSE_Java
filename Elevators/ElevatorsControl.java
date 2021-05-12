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
            System.out.println("Elevators thread is working now");
            int elevatorsEnvolved = 0;
            for(Elevator e : getElevators()) {
                e.go();
                if(e.getPassengers().size() < this.capacity) {
                    ArrayList<Passenger> upFrom = new ArrayList<>();
                    ArrayList<Passenger> downFrom = new ArrayList<>();
                    ArrayList<Passenger> upTo = new ArrayList<>();
                    ArrayList<Passenger> downTo = new ArrayList<>();
                    for (Passenger p : getPassengers()) {
                        if (e.getCur_floor() < p.getFrom()) {
                            upFrom.add(p);
                        } else if (e.getCur_floor() > p.getFrom()) {
                            downFrom.add(p);
                        }
                        if (e.getCur_floor() == p.getFrom() && p.getFrom() < p.getTo()) {
                            upTo.add(p);
                        } else if (e.getCur_floor() == p.getFrom() && p.getFrom() > p.getTo()) {
                            downTo.add(p);
                        }
                    }
                    if (e.getPassengers().size() == 0 || e.getCur_floor() == getNum_floors() - 1) {
                        if (e.getDirection() == 1 && (upFrom.size() < elevatorsEnvolved * getCapacity()
                                || downFrom.size() < elevatorsEnvolved * getCapacity())) {
                            e.setDirection(0);
                        } else if (downFrom.size() > elevatorsEnvolved * getCapacity() || e.getCur_floor() == getNum_floors() - 1) {
                            e.setDirection(-1);
                        }
                    } else if (e.getCur_floor() == 0) {
                        if (upFrom.size() > elevatorsEnvolved * getCapacity()) {
                            e.setDirection(1);
                        } else {
                            e.setDirection(0);
                        }
                    } else {
                        e.setDirection(1);
                    }
                    if (e.getDirection() == 0) {
                        if (upTo.size() > downTo.size() && upFrom.size() > elevatorsEnvolved * getCapacity()) {
                            e.setDirection(1);
                        } else if (upTo.size() <= downTo.size()
                                && downFrom.size() > elevatorsEnvolved * getCapacity()) {
                            e.setDirection(-1);
                        }
                    }
                    if (e.getCur_floor() == getNum_floors() - 1) {
                        e.setDirection(-1);
                    }
                    if (e.getCur_floor() == 0) {
                        e.setDirection(1);
                    }
                    ArrayList<Passenger> priorityPassengers = new ArrayList<>();
                    if (e.getDirection() == -1) {
                        priorityPassengers = upTo;
                    } else if (e.getDirection() == 1) {
                        priorityPassengers = downTo;
                    }
                    while (priorityPassengers.size() != 0 && e.getPassengers().size() < getCapacity()) {
                        e.addPassenger(priorityPassengers.get(0));
                        getPassengers().remove(priorityPassengers.get(0));
                        priorityPassengers.remove(0);
                    }
                }
                else {
                    if (e.getCur_floor() == getNum_floors() - 1) {
                        e.setDirection(-1);
                    }
                    if (e.getCur_floor() == 0) {
                        e.setDirection(1);
                    }
                }
                elevatorsEnvolved++;
                String direction = "";
                elevatorsEnvolved++;
                direction = switch (e.getDirection()) {
                    case -1 -> "down";
                    case 1 -> "up";
                    default -> "stopped";
                };
                System.out.println("Elevator id: " + e.getId() + "; Current floor: " + e.getCur_floor() +
                        "; Direction: " + direction + "; Passenger number: " + e.getPassengers().size());
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
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

    synchronized public void addElevator(Elevator elevator) {
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
