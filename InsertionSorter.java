import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class InsertionSorter {
	
	private int[] a;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private Lock sortStateLock;
	private JComponent component;
	private static final int DELAY = 10;
	
	public InsertionSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}
	
	public void sort() throws InterruptedException{
		for(int i = 1; i < a.length; i++) {
			int ahead = a[i];
			int currentIndex = i-1;
			sortStateLock.lock();
			try {
				while(ahead < a[currentIndex] && currentIndex >= 0) {
					int larger = a[currentIndex];
					a[currentIndex] = ahead;
					a[currentIndex + 1] = larger;
					markedPosition = currentIndex;
					if(currentIndex > 0) {
						currentIndex--;
					}
				}
			}
			finally {
				sortStateLock.unlock();
			}
			pause(20);
		}
	}

	public void draw(Graphics g) {
		sortStateLock.lock();
		try {
			int deltaX = component.getWidth() / a.length;
			for (int i = 0; i < a.length; i++) {
				if (i == markedPosition) {
					g.setColor(Color.RED);
				}
				else if (i <= alreadySorted) {
					g.setColor(Color.GREEN);
				}
				else {
					g.setColor(Color.CYAN);
				}
				g.drawLine(i * deltaX, 0, i * deltaX, a[i] * 5);
			}
		}
		finally {
			sortStateLock.unlock();
		}
	}
	public void pause(int steps) throws InterruptedException{
		component.repaint();
		Thread.sleep(steps * DELAY);
	}
}