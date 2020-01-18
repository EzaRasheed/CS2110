import java.awt.Graphics;

import javax.swing.JComponent;

public class InsertionSortComponent extends JComponent {
	
	private InsertionSorter sorter;
	
	public InsertionSortComponent() {
		int[] values = arrayInitializer(50);
		sorter = new InsertionSorter(values, this);
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
		
		class AnimationRunnable implements Runnable{
			@Override
			public void run() {
				try {
					sorter.sort();
				}
				catch(InterruptedException exception) {
				}
			}	
		}
		
		Runnable r = new AnimationRunnable();
		Thread t = new Thread(r);
		t.start();
		
	}
}