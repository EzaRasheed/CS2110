import java.awt.Color;


public class Koch {

    public static void main(String[] args) {
        World myWorld = new World(900,900,Color.GREEN);
        Turtle bob = new Turtle(myWorld);
        bob.setDelay(0);
        //drawTriangle(bob, 4, -200,-100,405,-100,100,350.75);

        koch(bob, 3, 12.0);
        bob.right(120);
        koch(bob, 3, 12.0);
        bob.right(120);
        koch(bob, 3, 12.0);
    }

     public static void koch(Turtle t, int n, double size) {
        if(n==0)
            t.forward(size);
        else
        {
            koch(t, n-1, size);
            t.left(60);
            koch(t, n-1, size);
            t.right(120);
            koch(t, n-1, size);
            t.left(60);
            koch(t, n-1, size);
        }


     }
}