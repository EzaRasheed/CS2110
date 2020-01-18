import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;


public class SortViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Sorts");
		frame.setLayout(new GridLayout(2,1));
		final int FRAME_WIDTH = 2000;
		final int FRAME_HEIGHT = 1000;
		
		JPanel labelPanel = new JPanel(new GridLayout(1,3));
		JPanel sortingPanel = new JPanel(new GridLayout(1,3));
		frame.add(sortingPanel);
		frame.add(labelPanel);
		
		JLabel insertionSortLabel = new JLabel ("Insertion Sort", JLabel.CENTER);
		insertionSortLabel.setSize(500, 100);
		JLabel bubbleSortLabel = new JLabel ("Bubble Sort", JLabel.CENTER);
		bubbleSortLabel.setSize(500, 100);
		JLabel selectionSortLabel = new JLabel ("Selection Sort", JLabel.CENTER);
		selectionSortLabel.setSize(500, 100);
		
		
		labelPanel.add(insertionSortLabel);
		labelPanel.add(bubbleSortLabel);
		labelPanel.add(selectionSortLabel);
		
		final SelectionSortComponent display1 = new SelectionSortComponent();
		final InsertionSortComponent display2 = new InsertionSortComponent();
		final BubbleSortComponent display3 = new BubbleSortComponent();
		
		sortingPanel.add(display1);
		sortingPanel.add(display2);
		sortingPanel.add(display3);
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		frame.setVisible(true);
		display1.startAnimation();
		display2.startAnimation();
		display3.startAnimation();
		
	}
}