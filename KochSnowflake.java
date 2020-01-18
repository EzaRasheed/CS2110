import java.awt.Color;

public class KochSnowflake {

    public static void main(String[] args) {
        World myWorld = new World(900,900,Color.PINK);
        Turtle lily = new Turtle(myWorld);
        lily.setDelay(0);
        
        snowflake(lily, 9.0, 3);  
        lily.right(120);
        snowflake(lily, 9.0, 3);
        lily.right(120);
        snowflake(lily, 9.0, 3);
    }

     public static void snowflake(Turtle t, double length, int depth) {
        if(depth == 0)  // if at last level(depth) of recursion, move forward
            t.forward(length);
        else { // else, recursively call snowflake
            snowflake(t, length, depth-1); 
            t.left(60);						// side 1 of snowflake (rotate 60 degrees)
            snowflake(t, length, depth-1);
            t.right(120);					// side 2 of snowflake (rotate 120 degrees)
            snowflake(t, length, depth-1);
            t.left(60);						// side 3 of snowflake (rotate 60 degrees)
            snowflake(t, length, depth-1);
        }

     }
}