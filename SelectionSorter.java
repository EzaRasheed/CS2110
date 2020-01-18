// used 22.6 in Big Java textbook to get information for SelectionSorter


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

public class SelectionSorter {
	
	private int[] a;
	private int markedPosition = -1;
	private int alreadySorted = -1;
	private Lock sortStateLock;
	private JComponent component;
	private static final int DELAY = 10;
	
	public SelectionSorter(int[] anArray, JComponent aComponent) {
		a = anArray;
		sortStateLock = new ReentrantLock();
		component = aComponent;
	}
		
	public void sort() throws InterruptedException{
		for(int i = 0; i < a.length-1; i++) {
			int minPos = minimumPosition(i);
			sortStateLock.lock();
			try {
				Random.swap(a, minPos, i);
				alreadySorted = i;
			}
			finally
			{
				sortStateLock.unlock();
			}
			pause(40);
		}
	}
	
	private int minimumPosition(int from) throws InterruptedException{
		int minPos = from;
		for (int i = from + 1; i < a.length; i++) {
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
					g.setColor(Color.orange);
				}
				else if (i <= alreadySorted) {
					g.setColor(Color.MAGENTA);
				}
				else {
					g.setColor(Color.BLACK);
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