// For #6, I used Stack Overflow to help me out with the recursive calls

import java.awt.Color;

public class Recursion {
	
	// Main method testing for methods 1-5
	public static void main(String[] args) {
		 System.out.println(reverseString("Eza")); // Expected and Actual output: azE
		 System.out.println(reverseString("Computer Science")); // Expected and Actual output: ecneicS retupmoC
		 System.out.println(countWays(3)); // Expected and Actual output: 3 
	     System.out.println(countWays(5)); // Expected and Actual output: 8
	     System.out.println(Ackermann(1, 0)); // Expected and Actual output: 2
	     System.out.println(Ackermann(3, 2)); // Expected and Actual output: 29
	     System.out.println(handShakes(5)); // Expected and Actual output: 10
	     System.out.println(handShakes(10)); // Expected and Actual output: 45
	     System.out.println(squareRoot(48)); // Expected: 6.92820323028 Actual: 6.928203307386093
	     System.out.println(squareRoot(81)); // Expected: 9 Actual: 9.000009437275327
	}
	
	// Method that takes in	a String "s" and returns the reverse of	it
	public static String reverseString(String s){
		if(s.length() <= 1){ // if the length of the string is 1 or 0, there will be no recursion needed
			return s; // so the string is just returned how it is 
	    } 
		else {
			return reverseString(s.substring(1)) + s.charAt(0); // starts at position one in string till the end of the string and reverses that portion, and then adds the first character(at position 0) to the end of the reversed string
		}
	}

	
	// Method that calculates the different ways to climb up a staircase of a set height, using small and/or large strides
	public static int countWays(int numStairs) {
		if(numStairs < 4) { // up till 3 stairs, the combination of ways to climb up the stairs equals the amount of stairs
						    // this is a base case
			return numStairs;
	    } 
		else {
			return countWays(numStairs - 1) + countWays(numStairs - 2); // recursive cases calculate different combinations possible for the remainder number of stairs after the first step, whether a small(1) or large(2) stride, then adds them together to return the total number of different ways to climb up the set value of stairs 
	    }
	}

	
	// Method which solves Ackermann's function
	public static int Ackermann(int m, int n) {
		if(m == 0) { // instructions give function which states to return n+1 if m=0
			return n+1;
		} 
		else if ((m > 0) && (n == 0)) { // instructions give function which states to return A(m-1, 1) if m>0 AND n=0
			return Ackermann(m-1, 1);
		} 		
		else {
			return Ackermann(m-1, Ackermann(m, n-1)); // instructions give function which states to return A(m-1, A(m, n-1)) if m>0 and n>0
		}	
	}

	
	// Method to calculate total number of handshakes for a set number of people
	public static int handShakes(int n) {
		if(n < 2) { // if there are less than 2 people
			return 0; // returns 0 as there are no handshakes possible
	    } 
		else {
			return (n-1) + handShakes(n-1); // else return the value of (n-1) handshakes(one less person each time) plus the recursive method with all the previous handshakes made to get the total number of handshakes  
										   // without recursion calculation(alternative): ((n * (n-1)) / 2)
		}
	}
	
	
	 // Method to compute the square root of a number
	 // Recursive helper method
	 public static double squareRootGuess(double x, double g) {   
		 if (Math.abs(x-(g*g)) < 0.001) // if the positive square root value(x) minus the guess(g) squared gives a remainder within 0.0001 decimal places, return the guess(g) of the square root(x) because it is pretty accurate
			 							// basically checks to see if g^2 is nearly equal to x
			 return g;       
		 else
			 return squareRootGuess(x,((g+(x/g))/2)); // else return until you get a "better guess" ---> (g+(x/g))/2
	 }

     // Recursive method which finds the square root of x
	 public static double squareRoot(double x) {
          return squareRootGuess(x, x-1);	//calls the helper method to find the square root
     }
	 
	 
	 // Drawing Koch Snowflake using turtle (Check citation) 
	 public static void snowflake(Turtle t, double length, int depth) {
		 if(depth == 0)  // if at last level(depth) of recursion, move forward
			 t.forward(length);
		 else { // else, recursively call snowflake
			 snowflake(t, length, depth-1); 
	         t.left(60); // side 1 of snowflake (rotate 60 degrees)
	         snowflake(t, length, depth-1);
	         t.right(120); // side 2 of snowflake (rotate 120 degrees)
	         snowflake(t, length, depth-1);
	         t.left(60); // side 3 of snowflake (rotate 60 degrees)
	         snowflake(t, length, depth-1);
	        }
	 }
	 
	 // Main method testing for Kock Snowflake
	 public static void main2(String[] args) {
	        World myWorld = new World(900,900,Color.PINK);
	        Turtle lily = new Turtle(myWorld);
	        lily.setDelay(0);
	        
	        snowflake(lily, 9.0, 3);  
	        lily.right(120);
	        snowflake(lily, 9.0, 3);
	        lily.right(120);
	        snowflake(lily, 9.0, 3);
	    }
	 
} //end class