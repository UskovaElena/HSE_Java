import java.util.Random;

public class Calls implements Runnable{
    private int num_floors = 0;
    private ElevatorsControl controller;

    Calls (int num_floors, ElevatorsControl controller) {
        setNum_floors(num_floors);
        setController(controller);
    }

    @Override
    public void run() {
        System.out.println("Calls thread is working now");
        for(int j = 0; j < 20; j++) {
            Random random = new Random();
            int num_passengers = random.nextInt(10);
            int from = random.nextInt(this.num_floors + 1);
            for (int i = 0; i < num_passengers; i++) {
                int flag = 0;
                int to = this.num_floors;
                while(flag == 0) {
                    to = random.nextInt(this.num_floors + 1);
                    if (from != to) {
                        flag = 1;
                    }
                }
                Passenger passenger = new Passenger(from, to);
                getController().addPassenger(passenger);
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

    public void setController(ElevatorsControl controller1) {
        this.controller = controller1;
    }

    public int getNum_floors() {
        return this.num_floors;
    }

    public ElevatorsControl getController() {
        return this.controller;
    }
}
