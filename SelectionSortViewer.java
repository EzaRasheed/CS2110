// used 22.6 in Big Java textbook to get information for SelectionSortViewer

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SelectionSortViewer {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Selection Sort");
		
		final int FRAME_WIDTH = 1600;
		final int FRAME_HEIGHT = 800;
		
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final SelectionSortComponent component = new SelectionSortComponent();
		final InsertionSortComponent component2 = new InsertionSortComponent();
		
		frame.add(component, BorderLayout.CENTER);
		frame.setVisible(true);
		component.startAnimation();
	}
}