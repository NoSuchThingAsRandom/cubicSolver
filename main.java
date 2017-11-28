package cubicSolver;

import java.util.Scanner;

public class main {
    //The values in the equation in the form ax^3 + bx^2 + cx + d
    private static double a;
    private static double b;
    private static double c;
    private static double d;

    //The three roots of the equation
    private static double x1;
    private static double x2;
    private static double x3;

    //The answer to the repeated bit (See equation)
    private static double repeat;

    //Gets the inputs from the equation
    public static void getInputs() {
	//Declares input function
        Scanner in = new Scanner(System.in);
        System.out.println("Solves cubics in the form Ax^3 + Bx^2 + Cx +D");
		
	//Gets actual values from user
        System.out.println("Enter tha value of A:");
        a = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of B:");
        b = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of C:");
        c = Double.parseDouble(in.nextLine());
        System.out.println("Enter tha value of D:");
        d = Double.parseDouble(in.nextLine());
        System.out.println("A=" + a + ", B=" + b + ", C=" + c + ", D=" + d);
    }

    //Calculates the repeated bit of the equation and returns it
    public static double calcRepeat() {
        repeat = (((b * c)
                / (6 * Math.pow(a, 2)))
                - ((Math.pow(b, 3))
                / (27 * Math.pow(a, 3)))
                - (d
                / (2 * a)));
        return repeat;
    }
    //Calculates the first root
    public static double calcX1() {
        if (repeat != 0) {
			//Returns the result of the equation x1
            x1 = Math.cbrt(
                    (repeat + Math.sqrt(
                            Math.pow(repeat, 2)
                                    + Math.pow((c / (3 * a) - (Math.pow(b, 2) / (9 * Math.pow(a, 2)))), 3))))
                    + Math.cbrt(repeat - Math.sqrt(
                    Math.pow(repeat, 2)
                            + Math.pow((c / (3 * a) - (Math.pow(b, 2) / (9 * Math.pow(a, 2)))), 3)))
                    - (b / (3 * a));
        } else {
			//The cube roots cancel out because its zero so only need to return the last fraction
            x1 = -(b / (3 * a));
        }
        return x1;
    }
    //Calculates the second root
    public static String calcX2() {
		//Checks if the discriminant  is negative
        if ((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) < 0) {
			//It has complex roots so it calculates and returns them
            return String.valueOf(
                    (-(b + (a * x1))) / (2 * a)//The real part
					+ " + "
                            + String.valueOf(
					Math.sqrt(
						(Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) * -1)//The imaginary value
						/ (2 * a))
			    + "i"//The imaginary label
            );
        } else {
	    //Calculates the actual root and returns it
            x2 = (-(b + (a * x1)))//The numerator without the discriminant  
                    + Math.sqrt((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1))//The discriminant 
                    / (2 * a);//The denominator
        }
        return String.valueOf(x2);//Returns the result
    }
    //Calculates the third root
    public static String calcX3() {
	//Checks if the discriminant  is negative
        if ((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) < 0) {
	    //It has complex roots so it calculates and returns them
            return String.valueOf(
                    (-(b + (a * x1))) / (2 * a)//The real part
			+ " + "
                            + String.valueOf(
					Math.sqrt((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1) * -1)//The imaginary part
					/ (2 * a))
			    + "i"//The imaginary label
            );
        } else {
		//Calculates the actual root and returns it 
            x3 = (-(b + (a * x1)))//The numerator without the discriminant  
                    - Math.sqrt((Math.pow(b + (a * x1), 2)) + ((4 * a * d) / x1))//The discriminant 
                    / (2 * a);//The denominator
            return String.valueOf(x3);//Returns the result
        }
    }
	/*The "run" of the program
	    In order:
		Get the equation from the user
		Calculate the repeated bit
		Calculates first root and outputs it
		Calculates second root and outputs it
		Calculate third root and outputs it
	*/
	public static void main(String[] args) {
        getInputs();
        calcRepeat();
        System.out.println("X1= "+calcX1());
        System.out.println("X2= "+calcX2());
        System.out.println("X3= "+calcX3());
    }
}
