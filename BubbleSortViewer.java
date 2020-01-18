import javax.swing.JFrame;

public class BubbleSortViewer {

	public static void main(String[] args) {

		JFrame frame = new JFrame();
		final int FRAME_WIDTH = 800;
		final int FRAME_HEIGHT = 1600;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		final BubbleSortComponent component = new BubbleSortComponent();

		frame.add(component);
		frame.setVisible(true);

		component.startAnimation();

	}
}