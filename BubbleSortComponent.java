import javax.swing.JComponent;
import java.awt.Graphics;

public class BubbleSortComponent extends JComponent {

	private BubbleSorter sorter;

	public BubbleSortComponent() {
		int[] values = arrayInitializer(50);
		sorter = new BubbleSorter(values, this);

	}

	public static int[] arrayInitializer(int n) {
		int[] arr = new int[n];
		int counter = 0;
		while(counter < n) {
			int num = (int) (Math.random()*n) + 1;
			boolean found = false;
			for(int i = 0; i < n; i++) {
				if(arr[i] == num) {
					found = true;
				}
			}
			if(!found) {
				arr[counter] = num;
				counter++;
			}
		}
		return arr;
	}
	
	public void paintComponent(Graphics g) {
		sorter.draw(g);
	}

	public void startAnimation() {
		class AnimationRunnable implements Runnable {
			public void run() {
				try {
					sorter.sort();
				} catch (InterruptedException exception) {

				}
			}

		}
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
	}
}