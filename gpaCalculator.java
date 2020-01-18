import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class gpaCalculator extends JFrame {

	//2 separate panels each with its own grid
	GridLayout courses = new GridLayout(18,4);

	//create a string with all the letter grades to be used in the comboBoxes
	static final String letters[] = {"","A+","A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
	//create a frame
	JFrame frame = new JFrame();
	//create a panel to use within the Frame
	JPanel p1 = new JPanel();

	//create 7 Labels total
	JLabel l1 = new JLabel("Course");
	JLabel l2 = new JLabel("Credit Hours");
	JLabel l3 = new JLabel("Grade");
	JLabel l4 = new JLabel("");	
	JLabel l5 = new JLabel("Target GPA");
	JLabel l6 = new JLabel("");
	JLabel l7 = new JLabel("Refresh");

	//t1-t30 are textFields for courses and credits
	JTextField t1 = new JTextField(20); 
	JTextField t2 = new JTextField(20);
	JTextField t3 = new JTextField(20);
	JTextField t4 = new JTextField(20);
	JTextField t5 = new JTextField(20);
	JTextField t6 = new JTextField(20);
	JTextField t7 = new JTextField(20);
	JTextField t8 = new JTextField(20);
	JTextField t9 = new JTextField(20);
	JTextField t10 = new JTextField(20);
	JTextField t11 = new JTextField(20);
	JTextField t12 = new JTextField(20);
	JTextField t13 = new JTextField(20);
	JTextField t14 = new JTextField(20);
	JTextField t15 = new JTextField(20);
	JTextField t16 = new JTextField(20);
	JTextField t17 = new JTextField(20);
	JTextField t18 = new JTextField(20);
	JTextField t19 = new JTextField(20);
	JTextField t20 = new JTextField(20);
	JTextField t21 = new JTextField(20);
	JTextField t22 = new JTextField(20);
	JTextField t23 = new JTextField(20);
	JTextField t24 = new JTextField(20);
	JTextField t25 = new JTextField(20);
	JTextField t26 = new JTextField(20);
	JTextField t27 = new JTextField(20);
	JTextField t28 = new JTextField(20);
	JTextField t29 = new JTextField(20);
	JTextField t30 = new JTextField(20);

	JTextField t31 = new JTextField(20); //this is the target GPA
	JTextField t32 = new JTextField(20); //this displays calculated GPA

	//create 15 combo boxes for 15 grades possible
	JComboBox c1 = new JComboBox(letters);
	JComboBox c2 = new JComboBox(letters);
	JComboBox c3 = new JComboBox(letters);
	JComboBox c4 = new JComboBox(letters);
	JComboBox c5 = new JComboBox(letters);
	JComboBox c6 = new JComboBox(letters);
	JComboBox c7 = new JComboBox(letters);
	JComboBox c8 = new JComboBox(letters);
	JComboBox c9 = new JComboBox(letters);
	JComboBox c10 = new JComboBox(letters);
	JComboBox c11 = new JComboBox(letters);
	JComboBox c12 = new JComboBox(letters);
	JComboBox c13 = new JComboBox(letters);
	JComboBox c14 = new JComboBox(letters);
	JComboBox c15 = new JComboBox(letters);

	//we will create 15 buttons for the remove operation
	JButton b1 = new JButton("Remove");
	JButton b2 = new JButton("Remove");
	JButton b3 = new JButton("Remove");
	JButton b4 = new JButton("Remove");
	JButton b5 = new JButton("Remove");
	JButton b6 = new JButton("Remove");
	JButton b7 = new JButton("Remove");
	JButton b8 = new JButton("Remove");
	JButton b9 = new JButton("Remove");
	JButton b10 = new JButton("Remove");
	JButton b11 = new JButton("Remove");
	JButton b12 = new JButton("Remove");
	JButton b13 = new JButton("Remove");
	JButton b14 = new JButton("Remove");
	JButton b15 = new JButton("Remove");

	//buttons for clearing information, adding 15 credits, and calculating gpa
	JButton b16 = new JButton ("Clear All");
	JButton b17 = new JButton ("Calculate GPA");
	JButton b18 = new JButton ("Add 15 Credits");
	JButton b19 = new JButton ("Refresh");

	//create an arraylist that takes in doubles for credit hours
	ArrayList<Double> credithrs = new ArrayList<Double>();
	//create an arraylist that takes in the textfield for credit hours
	ArrayList<JTextField>courseText = new ArrayList<JTextField>();
	//create an arraylist to take in all the comboboxes
	ArrayList<JComboBox> credsEarned = new ArrayList<JComboBox>();
	//create an arraylist to obtain all the converted doubles from the combobox format
	ArrayList<Double> converted = new ArrayList<Double>();


	//this method contains all the operations of the frame itself
	public gpaCalculator() {
		p1.setLayout(courses);

		//adds the actionlistener to the buttons
		b1.addActionListener(new remove1());
		b2.addActionListener(new remove2());
		b3.addActionListener(new remove3());
		b4.addActionListener(new remove4());
		b5.addActionListener(new remove5());
		b6.addActionListener(new remove6());
		b7.addActionListener(new remove7());
		b8.addActionListener(new remove8());
		b9.addActionListener(new remove9());
		b10.addActionListener(new remove10());
		b11.addActionListener(new remove11());
		b12.addActionListener(new remove12());
		b13.addActionListener(new remove13());
		b14.addActionListener(new remove14());
		b15.addActionListener(new remove15());
		b16.addActionListener(new removeAll());
		b17.addActionListener(new calculateGPA());
		b18.addActionListener(new addCreds());
		b19.addActionListener(new refresh());


		//we add the 2 textFields, combobox, and remove the buttons for each row
		p1.add(l1);
		p1.add(l2);
		p1.add(l3);
		p1.add(l4);
		p1.add(t1);
		p1.add(t2);
		p1.add(c1);
		p1.add(b1);
		p1.add(t3);
		p1.add(t4);
		p1.add(c2);
		p1.add(b2);
		p1.add(t5);
		p1.add(t6);
		p1.add(c3);
		p1.add(b3);
		p1.add(t7);
		p1.add(t8);
		p1.add(c4);
		p1.add(b4);
		p1.add(t9);
		p1.add(t10);
		p1.add(c5);
		p1.add(b5);
		p1.add(t11);
		p1.add(t12);
		p1.add(c6);
		p1.add(b6);
		p1.add(t13);
		p1.add(t14);
		p1.add(c7);
		p1.add(b7);
		p1.add(t15);
		p1.add(t16);
		p1.add(c8);
		p1.add(b8);
		p1.add(t17);
		p1.add(t18);
		p1.add(c9);
		p1.add(b9);
		p1.add(t19);
		p1.add(t20);
		p1.add(c10);
		p1.add(b10);
		p1.add(t21);
		p1.add(t22);
		p1.add(c11);
		p1.add(b11);
		p1.add(t23);
		p1.add(t24);
		p1.add(c12);
		p1.add(b12);
		p1.add(t25);
		p1.add(t26);
		p1.add(c13);
		p1.add(b13);
		p1.add(t27);
		p1.add(t28);
		p1.add(c14);
		p1.add(b14);
		p1.add(t29);
		p1.add(t30);
		p1.add(c15);
		p1.add(b15);
		
		p1.add(l5); //adds target GPA label
		p1.add(t31); //adds target GPA textfield
		p1.add(b17); //adds calculate GPA button
		p1.add(t32); //adds calculated GPA textfield
		//p2.add(l6); //adds empty label to get to next column?
		p1.add(b16); //adds Remove all button
		p1.add(b18);
		p1.add(b19); //adds Refresh button

		frame.add(p1); //adds panel to the frame

		//all the frame operations needed
		frame.setTitle("Grade Report");
		frame.setBounds(50, 0, 1000, 1000);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//adds the textfield values to the courseText arrayList
		courseText.add(t2);
		courseText.add(t4);
		courseText.add(t6);
		courseText.add(t8);
		courseText.add(t10);
		courseText.add(t12);
		courseText.add(t14);
		courseText.add(t16);
		courseText.add(t18);
		courseText.add(t20);
		courseText.add(t22);
		courseText.add(t24);
		courseText.add(t26);
		courseText.add(t28);
		courseText.add(t30);
		
		//these are the combobox credits put into creditsEarned
		credsEarned.add(c1);
		credsEarned.add(c2);
		credsEarned.add(c3);
		credsEarned.add(c4);
		credsEarned.add(c5);
		credsEarned.add(c6);
		credsEarned.add(c7);
		credsEarned.add(c8);
		credsEarned.add(c9);
		credsEarned.add(c10);
		credsEarned.add(c11);
		credsEarned.add(c12);
		credsEarned.add(c13);
		credsEarned.add(c14);
		credsEarned.add(c15);
	}
	
	//if the person didn't select a letter grade, add 0.0 to the total calculation
	public ArrayList<Double> getCredits (ArrayList<JTextField> p) {
		ArrayList<Double> credits = new ArrayList<>();
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i).getText().length()==0) {
				credits.add(0.0);
			}	
			//otherwise add the value after converting the text to a double
			else {
				String a = p.get(i).getText();
				Double b = Double.parseDouble(a);
				credits.add(b);
			}
		}
		return credits;
		//returns an arraylist with double values
	}

	//this will take the arraylist with double values and get a total sum in double format
	public double getTotalCreds (ArrayList<Double> d) {
		double sum = 0.0;
		for (int i=0; i<d.size(); i++) {
			sum += d.get(i);
		}
		return sum;
		
	}
	
	//this method converts letter grade to GPA values
	private double conversion (String s) {
		if (s == "A+") {
			return 4.0;
		}
		else if (s.equals("A")) {
			return 4.0;
		}
		else if (s.equals("A-")) {
			return 3.7;
		}
		else if (s.equals("B+")) {
			return 3.5;
		}
		else if (s.equals("B")) {
			return 3.3;
		}
		else if (s.equals("B-")) {
			return 3.0;
		}
		else if (s.equals("C+")) {
			return 2.7;
		}
		else if (s.equals("C")) {
			return 2.5;
		}
		else if (s.equals("C-")) {
			return 2.3;
		}
		else if (s.equals("D+")) {
			return 2.0;
		}
		else if (s.equals("D")) {
			return 1.7;
		}
		else if (s.equals("D-")) {
			return 1.5;
		}
		else if (s.equals("F")) {
			return 1.0;
		}
		else {
			return 0.0;
		}
	}
	
	//the 15 remove methods for each row to take out the values entered
	private class remove1 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t1.setText("");
			t2.setText("");
			c1.setSelectedIndex(0);
		}
	}

	private class remove2 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t3.setText("");
			t4.setText("");
			c2.setSelectedIndex(0);
		}
	}

	private class remove3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t5.setText("");
			t6.setText("");
			c3.setSelectedIndex(0);
		}
	}

	private class remove4 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t7.setText("");
			t8.setText("");
			c4.setSelectedIndex(0);
		}
	}

	private class remove5 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t9.setText("");
			t10.setText("");
			c5.setSelectedIndex(0);
		}
	}

	private class remove6 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t11.setText("");
			t12.setText("");
			c6.setSelectedIndex(0);
		}
	}

	private class remove7 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t13.setText("");
			t14.setText("");
			c7.setSelectedIndex(0);
		}
	}

	private class remove8 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t15.setText("");
			t16.setText("");
			c8.setSelectedIndex(0);
		}
	}

	private class remove9 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t17.setText("");
			t18.setText("");
			c9.setSelectedIndex(0);
		}
	}

	private class remove10 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t19.setText("");
			t20.setText("");
			c10.setSelectedIndex(0);
		}
	}

	private class remove11 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t21.setText("");
			t22.setText("");
			c11.setSelectedIndex(0);
		}
	}

	private class remove12 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t23.setText("");
			t24.setText("");
			c12.setSelectedIndex(0);
		}
	}

	private class remove13 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t25.setText("");
			t26.setText("");
			c13.setSelectedIndex(0);
		}
	}

	private class remove14 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t27.setText("");
			t28.setText("");
			c14.setSelectedIndex(0);
		}
	}

	private class remove15 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			t29.setText("");
			t30.setText("");
			c15.setSelectedIndex(0);
		}
	}
	
	private class addCreds implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			ArrayList<Double> p = new ArrayList<Double>();
			getCredits(courseText).add(15.0);
		}
	}

	//remove everything entered in the whole Grid
	private class removeAll implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent o) {
			JTextField newText = null;
			JComboBox newBox = null;

			for(Component a: p1.getComponents()) {
				if (a.getClass().toString().contains("javax.swing.JTextField")) {
					newText = (JTextField)a;
					newText.setText("");
				}
				else if (a.getClass().toString().contains("javax.swing.JComboBox")) {
					newBox = (JComboBox)a;
					newBox.setSelectedIndex(0);
				}
			}
		}
	}

	//calculates the GPA 
	private class calculateGPA implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//loops through the credits earned combobox arraylist
			for(JComboBox i: credsEarned) {
				//if the the string of the item selected in the combo box is nothing, then add 0.0
				if (i.getSelectedItem().toString().equals("")) {
					converted.add(0.0);
				}
				else {
					//when there is something selected in the combobox it is converted to a double and added
					String w = i.getSelectedItem().toString();
					Double d = conversion(w);
					converted.add(d);
				}
			}
			//total will get the grade point value
			double total = 0.0;
			for (int i=0; i<converted.size(); i++) {
				double s = converted.get(i)*getCredits(courseText).get(i);
				total += s;
			}
			
			//finalGPA is the grade point average
			double finalGPA = total/getTotalCreds(getCredits(courseText));
			String g = String.valueOf(finalGPA);
			t32.setText(g);
		}
	}
	private class refresh implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			frame.revalidate();
	        frame.repaint();
		}
	}
	
//	public static double calcRequiredGPA implements ActionListener {
//		/*can't complete this method in time I was going to:
//		 * initialize variables: credit hours taken, credit hours desired, grade point taken;
//		 * set up a for loop in the credits taken,
//		 * add the credit hours taken to i.creditHours
//		 * add the grade point taken to i.gradePoint
//		 * if (i is in the desired spot)
//		 * desired credit hours += i.credit hour
//		 * you return:
//		 * ((credit hours taken + credit hours desired) * GPA desired) - (GPA taken/Credit hours desired)
//		 * to get your required GPA.
//		 */
//	}
	

	public static void main(String[] args) {
		new gpaCalculator();
	}

}