import java.util.Scanner;

public class main {

    private static double a;
    private static double b;
    private static double c;
    private static double d;


    private static double x1;
    private static double x2;
    private static double x3;

    private static double repeat;

    public static void getInputs() {
        Scanner in = new Scanner(System.in);
        System.out.println("Solves cubics in the form Ax^3 + Bx^2 + Cx +D");
        System.out.println("Enter tha value of A:");
     //   a = Double.parseDouble(new Scanner(System.in).nextLine());
        a = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of B:");
        b = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of C:");
        c = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of D:");
        d = Double.parseDouble(in.nextLine());
        System.out.println("A=" + a + ", B=" + b + ", C=" + c + ", D=" + d);
    }


    public static double calcRepeat() {
        repeat = (((b * c)
                / (6 * Math.pow(a, 2)))
                - ((Math.pow(b, 3))
                / (27 * Math.pow(a, 3)))
                - (d
                / (2 * a)));
        return repeat;
    }

    public static double calcX1() {
        if (repeat != 0) {
            x1 = Math.cbrt(
                    (repeat + Math.sqrt(
                            Math.pow(repeat, 2)
                                    + Math.pow((c / (3 * a) - (Math.pow(b, 2) / (9 * Math.pow(a, 2)))), 3))))
                    + Math.cbrt(repeat - Math.sqrt(
                    Math.pow(repeat, 2)
                            + Math.pow((c / (3 * a) - (Math.pow(b, 2) / (9 * Math.pow(a, 2)))), 3)))
                    - (b / (3 * a));
        } else {
            x1 = -(b / (3 * a));
        }
        return x1;
    }

    public static String calcX2() {
        if ((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) < 0) {
            return String.valueOf(
                    (-(b + (a * x1))) / (2 * a) + " + "
                            + String.valueOf(Math.sqrt(
                            (Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) * -1
                    ) / (2 * a)) + "i"
            );
        } else {
            x2 = (-(b + (a * x1)))
                    + Math.sqrt(
                    (Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1))
                    / (2 * a);
        }
        return String.valueOf(x2);
    }

    public static String calcX3() {
        if ((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) < 0) {
            return String.valueOf(
                    (-(b + (a * x1))) / (2 * a) + " + "
                            + String.valueOf(Math.sqrt(
                            (Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) * -1
                    ) / (2 * a)) + "i"
            );
        } else {
            x3 = (-(b + (a * x1)))
                    - Math.sqrt(
                    (Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1))
                    / (2 * a);
            return String.valueOf(x3);
        }
    }

    public static void main(String[] args) {
        getInputs();
        calcRepeat();
        System.out.println("X1= "+calcX1());
        System.out.println("X2= "+calcX2());
        System.out.println("X3= "+calcX3());
    }
}
