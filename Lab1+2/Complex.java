import java.lang.Math;
import java.util.Scanner;

public class Complex {
    private double a;
    private double b;

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex() {
        this.a = 0;
        this.b = 0;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public void set(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex SumComplex(Complex z1, Complex z2) {
        Complex sum = new Complex(z1.a + z2.a, z1.b + z2.b);
        this.a = sum.a;
        this.b = sum.b;
        return sum;
    }

    public Complex SumComplex(Complex z2) {
        Complex sum = new Complex(this.a + z2.a, this.b + z2.b);
        this.a = sum.a;
        this.b = sum.b;
        return sum;
    }

    public Complex SubComplex(Complex z1, Complex z2) {
        Complex sub = new Complex(z1.a - z2.a, z1.b - z2.b);
        this.a = sub.a;
        this.b = sub.b;
        return sub;
    }

    public Complex SubComplex(Complex z2) {
        Complex sub = new Complex(this.a - z2.a, this.b - z2.b);
        this.a = sub.a;
        this.b = sub.b;
        return sub;
    }

    public Complex MultComplex(Complex z1, Complex z2) {
        Complex mult = new Complex(z1.a * z2.a - z1.b * z2.b, z1.a * z2.b + z1.b * z2.a);
        this.a = mult.a;
        this.b = mult.b;
        return mult;
    }

    public Complex MultComplex(Complex z2) {
        Complex mult = new Complex(this.a * z2.a - this.b * z2.b, this.a * z2.b + this.b * z2.a);
        this.a = mult.a;
        this.b = mult.b;
        return mult;
    }

    public Complex DivComplex(Complex z1, Complex z2) throws InvalidOper {
        if (z2.a == 0 && z2.b == 0) {
            throw new InvalidOper("Invalid operation");
        } else {
            Complex div = new Complex(((z1.a * z2.a + z1.b * z2.b) / (Math.pow(z2.a, 2) + Math.pow(z2.b, 2))), ((z2.a * z1.b - z1.a * z2.b) / (Math.pow(z2.a, 2) + Math.pow(z2.b, 2))));
            this.a = div.a;
            this.b = div.b;
            return div;
        }
    }

    public Complex DivComplex(Complex z2) throws InvalidOper {
        if (z2.a == 0 && z2.b == 0) {
            throw new InvalidOper("Invalid operation");
        } else {
            Complex div = new Complex(((this.a * z2.a + this.b * z2.b) / (Math.pow(z2.a, 2) + Math.pow(z2.b, 2))), ((z2.a * this.b - this.a * z2.b) / (Math.pow(z2.a, 2) + Math.pow(z2.b, 2))));
            this.a = div.a;
            this.b = div.b;
            return div;
        }
    }

    public String ToTrig() {
        double r = Math.sqrt(Math.pow(this.a, 2) + Math.pow(this.b, 2));
        double arg = Math.atan(this.b / this.a);
        return String.format("%.2f * ( cos( %.2f ) + i*( sin( %.2f ) )", r, arg, arg);
    }

    public String FromTrig(String str) {
        int i = 0;
        char[] num;
        double r = 0.0, arg = 0.0;
        int flag = 0;
        while(i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <=9) {
                num = new char[10];
                int counter = 0;
                while(str.charAt(i) != ' ') {
                    flag = flag + 1;
                    num[counter] = str.charAt(i);
                    counter += 1;
                    i = i + 1;
                }
                String num_ = new String(num);
                if (flag == 1) {
                    r = Double.parseDouble(num_);
                }
                else if(flag == 2) {
                    arg = Double.parseDouble(num_);
                }
            }
            else
                i = i + 1;
        }
        double r_first = r * Math.cos(arg);
        double arg_first = r * Math.sin(arg);
        return String.format("%.2f + i*(%.2f)", r_first, arg_first);
    }

    public String ComplexToString() {
        return String.format("%.2f + i*(%.2f)", this.a, this.b);
    }

    static class InvalidOper extends Exception {
        InvalidOper(String message){
            super(message);
        }
    }

    public void readComplexNum(Scanner in) {
        System.out.print("Input a real part of complex number: ");
        double real = in.nextDouble();
        System.out.print("Input a imaginary part of complex number: ");
        double image = in.nextDouble();
        this.set(real, image);
    }
}
