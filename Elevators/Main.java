import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int f = 0;
        int num_floors = 0;
        int num_elevators = 0;
        int max_capacity = 5;
        while (f == 0) {
            try {
                System.out.print("Enter number of floors: ");
                int flag = 0;
                while(flag == 0) {
                    num_floors = Integer.parseInt(in.nextLine());
                    if(num_floors > 0)
                        flag = 1;
                    else
                        System.out.print("Try again. This number must be more than 0 ");
                }
                flag = 0;
                System.out.print("Enter number of elevators: ");
                while(flag == 0) {
                    num_elevators = Integer.parseInt(in.nextLine());
                    if(num_elevators > 0)
                        flag = 1;
                    else {
                        System.out.print("Try again. This number must be more than 0 ");
                        System.out.println(" ");
                    }
                }
                f = 1;
            }
            catch (RuntimeException e) {
                System.out.println("Exception: " + e.getMessage());
                System.out.println("Try again");
                System.out.println(" ");
            }
        }
        System.out.println("Input is OK");
        System.out.println("Start of the work...");
        ElevatorsControl controller = new ElevatorsControl(num_floors, num_elevators, max_capacity);
        Calls calls = new Calls(num_floors, controller);
        Thread calls_thread = new Thread(calls);
        Thread elevators_thread = new Thread(controller);
        calls_thread.start();
        elevators_thread.start();
    }
}
