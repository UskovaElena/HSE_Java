import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flag = 0;
        while (flag == 0) {
            try {
                System.out.println("Введите ФИО и дату рождения:");
                String data = in.nextLine();
                FIO info = new FIO(data);
                System.out.println(info.getFio() + "; Возраст: " + info.getAge() + "; Пол: " + info.getSex());
                flag = 1;
            } catch (RuntimeException e) {
                System.out.println("Format is unexpected. Exception: " + e.getMessage());
                System.out.println("Try again.");
                System.out.println(" ");
            }
        }
    }
}
