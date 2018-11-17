import java.awt.Container;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE
}

public class Calculator extends JFrame {

	private JTextField resultTextField;
	private JButton C, add, subtract, multiply, divide, compute, dot;

	private JButton numbers[];
	private Font font;
	
	//test operand
	//int first = 500, second = 100;
	
	//operands and operator
	String first, second, operator;
	
	public Calculator() {
		first = second = operator = "";
	}
	
	/*Operation o = Operation.ADD;

	class OperationListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == add) {
				o = Operation.ADD;
			}
			if (e.getSource() == subtract) {
				o = Operation.SUBTRACT;
			}
			if (e.getSource() == multiply) {
				o = Operation.MULTIPLY;
			}
			if (e.getSource() == divide) {
				o = Operation.DIVIDE;
			}
			if (e.getSource() == C) {
				
			}
			
		}

	}
	*/

	class ComputeListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();
			//resultTextField = new JTextField(16); 
			//if number
			if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') { 
				// if operand is present then add to second no 
				if (!operator.equals("")) 
					second = second + s; 
				else
					first = first + s;
				
				resultTextField.setText(first+operator+second);
			}
			else if (s.charAt(0) == 'C') { 
				// clear the one letter 
				first = operator = second = ""; 

				// set the value of text 
				resultTextField.setText(first + operator + second); 
			} 
			else if (s.charAt(0) == '=') { 

				double result; 

				// store the value in 1st 
				if (operator.equals("+")) 
					result = (Double.parseDouble(first) + Double.parseDouble(second)); 
				else if (operator.equals("-")) 
					result = (Double.parseDouble(first) - Double.parseDouble(second)); 
				else if (operator.equals("/")) 
					result = (Double.parseDouble(first) / Double.parseDouble(second)); 
				else
					result = (Double.parseDouble(first) * Double.parseDouble(second)); 

				// set the value of text 
				resultTextField.setText(first + operator + second + "=" + result); 

				// convert it to string 
				first = Double.toString((double)Math.round(result * 100000d) / 100000d); 

				operator = second = ""; 
			} 
			else { 
				// if there was no operand 
				if (operator.equals("") || second.equals("")) 
					operator = s; 
				// else evaluate 
				else { 
					double result; 

					// store the value in 1st 
					if (operator.equals("+")) 
						result = (Double.parseDouble(first) + Double.parseDouble(second)); 
					else if (operator.equals("-")) 
						result = (Double.parseDouble(first) - Double.parseDouble(second)); 
					else if (operator.equals("/")) 
						result = (Double.parseDouble(first) / Double.parseDouble(second)); 
					else
						result = (Double.parseDouble(first) * Double.parseDouble(second)); 

					// convert it to string 
					first = Double.toString((double)Math.round(result * 100000d) / 100000d); 

					// place the operator 
					operator = s; 

					// make the operand blank 
					second = ""; 
				} 

				// set the value of text 
				resultTextField.setText(first + operator + second); 
			} 
			/*
			int result = 0;
			if (o == Operation.ADD) {
				result = first + second;
			}
			if (o == Operation.SUBTRACT) {
				result = first - second;
			}
			if (o == Operation.DIVIDE) {
				result = first / second;
			}
			if (o == Operation.MULTIPLY) {
				result = first * second;
			}

			resultTextField.setText(result + "");
			*/
		}

	}

	public void CalculatorCommand() {
		createComponents();
		setLayout();
		addComponents();
		addBehaviors();
		display();
	}

	private void addBehaviors() {
		ComputeListener c = new ComputeListener();
		compute.addActionListener(c);
		add.addActionListener(c);
		subtract.addActionListener(c);
		divide.addActionListener(c);
		multiply.addActionListener(c);
		C.addActionListener(c);
		for (int i = 0; i < 10; i++) {
			numbers[i].addActionListener(c);
		}
		dot.addActionListener(c);
		
		
		/*
		OperationListener ol = new OperationListener();
		add.addActionListener(ol);
		subtract.addActionListener(ol);
		multiply.addActionListener(ol);
		divide.addActionListener(ol);
		C.addActionListener(ol);
		*/
	}

	private void display() {
		setSize(600, 600);
		setLocation(300, 300);
		setVisible(true);

	}

	private void addComponents() {
		Container c = getContentPane();
		c.add(resultTextField);

		JPanel panel = new JPanel();
		panel.add(C);
		c.add(panel);
		
		panel = new JPanel();
		panel.add(numbers[7]);
		panel.add(numbers[8]);
		panel.add(numbers[9]);
		panel.add(divide);
		c.add(panel);
		
		panel = new JPanel();
		panel.add(numbers[4]);
		panel.add(numbers[5]);
		panel.add(numbers[6]);
		panel.add(multiply);
		c.add(panel);
		
		panel = new JPanel();
		panel.add(numbers[1]);
		panel.add(numbers[2]);
		panel.add(numbers[3]);
		panel.add(subtract);
		c.add(panel);
		
		panel = new JPanel();
		panel.add(numbers[0]);
		panel.add(dot);
		panel.add(compute);
		panel.add(add);
		c.add(panel);

	}

	private void setLayout() {
		GridLayout gl = new GridLayout(6, 1);
		Container c = this.getContentPane();
		c.setLayout(gl);

	}

	private void createComponents() {
		font = new Font("TimesRoman", Font.PLAIN, 36);
		resultTextField = new JTextField(10);
		resultTextField.setFont(font);

		add = new JButton("+");
		add.setFont(font);
		subtract = new JButton("-");
		subtract.setFont(font);
		multiply = new JButton("*");
		multiply.setFont(font);
		divide = new JButton("/");
		divide.setFont(font);
		compute = new JButton("=");
		compute.setFont(font);
		C = new JButton("C");
		C.setFont(font);
		dot = new JButton(".");
		dot.setFont(font);

		numbers = new JButton[10];
		for (int i = 0; i < 10; i++) {
			numbers[i] = new JButton(i+"");
			numbers[i].setFont(font);
		}

	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.CalculatorCommand();
		//c.first = 4;
		//c.second = 3;
	}

}
