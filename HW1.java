import java.util.Scanner;

public class HW1 {
	
	//MAIN METHOD
	public static void main(String[] args) {
		
		// test pi
		Scanner scan2 = new Scanner(System.in);
		System.out.println("Enter an integer to calculate decimal place: ");
		int num = scan2.nextInt();
		double dec = pi(num);
		System.out.println(dec);
		// input = 3
		// output = 0.6666666666666667 (suppose to be: 3.141) :(
		// input = 5
		// output = 0.46666666666666673 (suppose to be: 3.14159) :(
		
		// test easter
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter a year: ");
		int y= scan1.nextInt();
		String date= easter(y);
		System.out.println(date);
		// input = 1999
		// output = April 4
		// input = 2001
		// output = April 15
		
		// test escape
		Scanner scan3 = new Scanner(System.in);
		System.out.println("Enter a velocity: ");
		double num1 = scan3.nextDouble();
		String vel = escape(num1);
		System.out.println(vel);
		// input = 4530.0
		// output = The astronaut will NOT return to the surface of Halley's Comet. In order for him to return, the comet would need to have a mass larger than 1.7736579985007496E23
		// input = 100.0
		// output = The astronaut will return to the surface of Halley's Comet
		
		
		// test random
		Scanner scan4 = new Scanner(System.in);
		System.out.println("Enter a number for r: ");
		int r = scan4.nextInt();
		System.out.println("Enter a number for a: ");
		int a = scan4.nextInt();
		System.out.println("Enter a number for b: ");
		int b = scan4.nextInt();
		System.out.println("Enter a number for m: ");
		int m = scan4.nextInt();
		//HERE
		int[] array= random(r, a, b, m);
		for( int i=0; i<array.length; i++) {
			System.out.print(array[i]+" ");
		// input = r: 17, a: 6, b: 1, m: 10
		// output = 3 9 5 1 7 3 9 5 1 7 3 9 5 1 7 3 9 5 1 7 3 9 5 1 7 
		// input = r: 9, a: 4, b: 5, m: 11
		// output = 8 4 10 1 9 8 4 10 1 9 8 4 10 1 9 8 4 10 1 9 8 4 10 1 9 
			
		}
			
	} // END MAIN
	
	//METHOD 1
	public static double pi(int n) {
		
		//HERE
		double frac = 1;
		String oper = "-";
		for (double i = 3.0; i<=(double)n; i++) {
			double div = 1/i;
			if (oper == "+") {
				frac += div; 
			}
			else { // test for subtraction operator "-"
				frac -= div; 
			}
	}
		return frac;
			
		}

	
	//METHOD 2
	public static String easter(int y) {
		
		int a = (y % 19);
		int b = (y / 100);
		int c = (y % 100);
		int d = (b / 4);
		int e = (b % 4);
		int g = (8 * b + 13) / (25);
		int h = (19 * a + b - d - g + 15) % (30);
		int j = (c / 4);
		int k = (c % 4);
		int m = (a + 11 * h) / (319);
		int r = (2 * e + 2 * j - k - h + m + 32) % (7);
		int n = (h - m + r + 90) / (25);
		int p = (h - m + r + n + 19) % (32);
		
		String date = null;
		
		if (n == 1) {
		    date = ("January" +" "+ p); } 
		else if (n == 2) {
			date = ("February" +" "+ p); }
		else if (n == 3) {
			date = ("March" +" "+ p); }
		else if (n == 4) {
			date = ("April" +" "+ p); }
		else if (n == 5) {
			date = ("May" +" "+ p); }
		else if (n == 6) {
			date = ("June" +" "+ p); }
		else if (n == 7) {
			date = ("July" +" "+ p); }
		else if (n == 8) {
			date = ("August" +" "+ p); }
		else if (n == 9) {
			date = ("September" +" "+ p); }
		else if (n == 10) {
			date = ("October" +" "+ p); }
		else if (n == 11) {
			date = ("November" +" "+ p); }
		else {
			date = ("December" +" "+ p); }
		
		return date;
		
	}
	
	//METHOD 3
	public static String escape (double v) {
		double G = 6.67e-11; // gravitational constant value
		double M = 1.3e22; // mass formula value
		double R = 1.153e6; // radius value
		double formula = Math.sqrt((2*G*M)/(R));
		double conver = formula * 2.23694; // convert to get formula in mph not m/s
		
		if (conver <= v ) {
			double vel_sqr = Math.pow(v, 2);
			double mass = ((vel_sqr * R) / (2*G));
			return "The astronaut will NOT return to the surface of Halley's Comet. In order for him to return, the comet would need to have a mass larger than" +" "+ mass;
					
		}
		else {
			return "The astronaut will return to the surface of Halley's Comet";
		}
	}
	
	//METHOD 4
	public static int [] random (int r, int a, int b, int m) {
		int [] list = new int [25];
		for (int i = 0; i < list.length; i++) {
			int rand_form = ((a * r) + b) % (m);
			list[i] = rand_form;
			r = rand_form; // update value of r after each iteration in for loop
		}
		return list;
	}

}
