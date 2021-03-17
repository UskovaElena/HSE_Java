import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Complex.InvalidOper, Matrix.MatrixSizeError {
        Scanner in = new Scanner(System.in);

        Complex x = new Complex();
        Complex y = new Complex();
        Complex z = new Complex();

        x.readComplexNum(in);
        y.readComplexNum(in);

        System.out.println("x + y =");
        System.out.println(x.SumComplex(y).ComplexToString());
        System.out.println("z = x + y = ");
        System.out.println(z.SumComplex(x, y).ComplexToString());
        System.out.println("z = x - y = ");
        System.out.println(x.SubComplex(y).ComplexToString());
        System.out.println("z = x * y = ");
        System.out.println(z.MultComplex(x, y).ComplexToString());
        System.out.println("z = x / y = ");
        System.out.println(z.DivComplex(x, y).ComplexToString());

        System.out.print("Input size of int matrix (n): ");
        int n = in.nextInt();
        System.out.print("Input size of int matrix (m): ");
        int m = in.nextInt();
        int[][] matr1_int = new int[n][m];
        int[][] matr2_int = new int[n][m];
        int[][] matr3_int = new int[m][n];

        Random random = new Random();

        for (int i = 0; i < n; i++){
            for (int j= 0; j < m; j++){
                matr1_int[i][j] = random.nextInt(15);
                matr2_int[i][j] = random.nextInt(15);
            }
        }

        for (int i = 0; i < m; i++){
            for (int j= 0; j < n; j++){
                matr3_int[i][j] = random.nextInt(15);
            }
        }

        System.out.println("");
        Matrix matr_1 = new Matrix(n, m, 1, matr1_int);
        matr_1.printMatrix();
        System.out.println("");
        Matrix matr_2 = new Matrix(n, m, 1, matr2_int);
        matr_2.printMatrix();
        System.out.println("");
        Matrix matr_3 = new Matrix(m, n, 1, matr3_int);
        matr_3.printMatrix();
        Matrix matr_res = new Matrix(n, m, 1);
        Matrix matr_res1 = new Matrix(n, n, 1);
        System.out.println("");

        System.out.println("Sum:");
        matr_res.sum(matr_1, matr_2);
        matr_res.printMatrix();
        System.out.println("");

        System.out.println("Sub:");
        matr_res = matr_res.sub(matr_1, matr_2);
        matr_res.printMatrix();
        System.out.println("");

        System.out.println("Mult:");
        matr_res1 = matr_res1.mul(matr_1, matr_3);
        matr_res1.printMatrix();
        System.out.println("");

        System.out.println("Transp matr1:");
        matr_res = matr_1.Transp();
        matr_res.printMatrix();
        System.out.println("");

        System.out.println("Deter matr_res1 (mult):");
        matr_res1.printDeter();
        System.out.println("");

        System.out.println("");
        System.out.println("");
        System.out.print("Input size of Complex matrix (n): ");
        int k = in.nextInt();
        System.out.print("Input size of Complex matrix (m): ");
        int l = in.nextInt();
        Complex[][] matr1_c = new Complex[k][l];
        Complex[][] matr2_c = new Complex[k][l];
        Complex[][] matr3_c = new Complex[l][k];

        Random rand = new Random();

        for (int i = 0; i < k; i++) {
            for (int j= 0; j < l; j++) {
                matr1_c[i][j] = new Complex(rand.nextDouble(), rand.nextDouble());
                matr2_c[i][j] = new Complex(rand.nextDouble(), rand.nextDouble());
            }
        }

        for (int i = 0; i < l; i++){
            for (int j= 0; j < k; j++){
                matr3_c[i][j] = new Complex(rand.nextDouble(), rand.nextDouble());
            }
        }

        System.out.println("");
        Matrix matr_1c = new Matrix(n, m, 0, matr1_c);
        matr_1c.printMatrix();
        System.out.println("");
        Matrix matr_2c = new Matrix(n, m, 0, matr2_c);
        matr_2c.printMatrix();
        System.out.println("");
        Matrix matr_3c = new Matrix(m, n, 0, matr3_c);
        matr_3c.printMatrix();
        Matrix matr_resc = new Matrix(n, m, 0);
        Matrix matr_res1c = new Matrix(n, n, 0);
        System.out.println("");

        System.out.println("Sum:");
        matr_resc.sum(matr_1c, matr_2c);
        matr_resc.printMatrix();
        System.out.println("");

        System.out.println("Sub:");
        matr_resc = matr_resc.sub(matr_1c, matr_2c);
        matr_resc.printMatrix();
        System.out.println("");

        System.out.println("Mult:");
        matr_res1c = matr_res1c.mul(matr_1c, matr_3c);
        matr_res1c.printMatrix();
        System.out.println("");

        System.out.println("Transp matr1:");
        matr_resc = matr_1c.Transp();
        matr_resc.printMatrix();
        System.out.println("");

        System.out.println("Deter matr_res1c (mult):");
        matr_res1c.printDeter();
        System.out.println("");
    }
}
