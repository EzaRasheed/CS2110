import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JComponent;

public class BubbleSorter {

	private int[] a;
	private Lock sortStateLock;
	private static final int DELAY = 1;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private JComponent component;
	public BubbleSorter(int[] arr, JComponent passingComponent) {
		a = arr;
		sortStateLock = new ReentrantLock();
		component = passingComponent;
	}
	public void sort() throws InterruptedException {
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				int minPos = minPositionIndex(i);
				sortStateLock.lock();
				try {
					if (a[j] > a[j + 1]) {
						Random.swap(a, j, j+1);
						minPos = a[j];
					} 
					else {
						minPos = a[j + 1];
					}
				}
				finally {
					sortStateLock.unlock();
				}
				pause(10);
			}
		}
	}

	public int minPositionIndex(int pass) throws InterruptedException {
		int minPos = pass; 
		for (int i = pass + 1; i < a.length; i++) {
			sortStateLock.lock();
			try {
				if (a[i] < a[minPos]) {
					minPos = i;
				}
				markedPosition = i;
			}
			finally {
				sortStateLock.unlock();
			}
		}
		return minPos;

	}

	public void draw(Graphics g) {
		sortStateLock.lock();
		try {
			int deltaX = component.getWidth() / a.length;
			for (int i = 0; i < a.length; i++) {
				if (i == markedPosition) {
					g.setColor(Color.BLUE);
				}
				else if (i <= alreadySorted) {
					g.setColor(Color.RED);
				}
				else {
					g.setColor(Color.PINK);
				}
				g.drawLine(i * deltaX, 0, i * deltaX, a[i] * 5);
			}
		}
		finally {
			sortStateLock.unlock();
		}
	}

	public void pause(int steps) throws InterruptedException {
		component.repaint();
		Thread.sleep(steps + DELAY);
	}

}