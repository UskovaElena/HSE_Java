import java.io.*;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter path or name of input file");  // input.txt
        String fileName = in.nextLine();
        File file = new File(fileName);
        boolean flag = false;
        while(!flag) {
            if (!file.exists()) {
                System.out.println("The file not found. Enter another file name");
                fileName = in.nextLine();
                file = new File(fileName);
            } else if (file.length() == 0) {
                System.out.println("The file is empty. Enter another file name");
                fileName = in.nextLine();
                file = new File(fileName);
            } else {
                System.out.println("File is OK");
                flag = true;
            }
        }
        FileWork File = new FileWork(file);
        LettersCounter data = new LettersCounter(File.read());
        Map<Character, Integer> map = data.count();
        Scanner out = new Scanner(System.in);
        System.out.println("Enter path or name of output file");  // output.txt
        String fileN = in.nextLine();
        File file_out = new File(fileN);
        FileWork File_out = new FileWork(file_out);
        File_out.write(map);
        System.out.println("Done!");
    }
}
