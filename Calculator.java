public class Calculator extends Frame implements ActionListener {
	Panel Main, Grid;
	TextField t1;
	Button add, minus, multiply, divide, clear, delete, equal, dot;
	Button FuncButton [] = new Button[8];
	Button NumButton [] = new Button[10];
	char operator;
	double num1 = 0, num2 = 0, result = 0;
	
	
	public Calculator() {
		setTitle("Calculator");
		setSize(400,600);
		setLayout(null);
		Panel Main = new Panel();
		Main.setBounds(0, 0, 400, 200);
		Main.setLayout(null);
		t1 = new TextField();
		t1.setBounds(10, 30, 380, 170);
		t1.setEditable(false);
		t1.setFont(new Font("Arial",Font.PLAIN, 56));
		
		Main.add(t1);
		add(Main);
		
		
		add = new Button("+");
		minus = new Button("-");
		multiply = new Button("*");
		divide = new Button("/");
		equal = new Button("=");
		clear = new Button("C");
		delete = new Button("Del");
		dot = new Button(".");
		
		FuncButton[0] = add;
		FuncButton[1] = minus;
		FuncButton[2] = multiply;
		FuncButton[3] = divide;
		FuncButton[4] = equal;
		FuncButton[5] = clear;
		FuncButton[6] = delete;
		FuncButton[7] = dot;
		
		
		for(int i = 0; i < FuncButton.length; i++) {
			FuncButton[i].addActionListener(this);
			FuncButton[i].setFont(new Font((i+""), Font.ITALIC, 24));
		}
		
		Panel Grid = new Panel();
		for(int i = 0; i < NumButton.length; i++) {
			NumButton[i] = new Button(""+i);
			NumButton[i].addActionListener(this);
			NumButton[i].setFont(new Font((i+""), Font.ITALIC, 24));
		}
		
		
		
		Grid.add(NumButton[1]);Grid.add(NumButton[2]);Grid.add(NumButton[3]);Grid.add(FuncButton[0]);
		Grid.add(NumButton[4]);Grid.add(NumButton[5]);Grid.add(NumButton[6]);Grid.add(FuncButton[1]);
		Grid.add(NumButton[7]);Grid.add(NumButton[8]);Grid.add(NumButton[9]);Grid.add(FuncButton[2]);
		Grid.add(NumButton[0]);Grid.add(dot);Grid.add(FuncButton[3]);Grid.add(FuncButton[4]);
		Grid.add(FuncButton[5]); Grid.add(FuncButton[6]);
		
		Grid.setLayout(new GridLayout(5,4));
		add(Grid);
			
		
		Grid.setBackground(Color.red);
		Grid.setBounds(0,200, 400, 400);
		
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			});
		setVisible(true);
		setResizable(false);	
		}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i = 0; i < NumButton.length; i++) {
			if (e.getSource() == NumButton[i]) {
			t1.setText(t1.getText().concat(String.valueOf(i)));
			}
		}
		if (e.getSource() == dot) {
			t1.setText(t1.getText().concat("."));
			}
		if (e.getSource() == add) {
			num1 = Double.parseDouble(t1.getText());
			operator = '+';
			t1.setText("");
			}
		if (e.getSource() == minus) {
			num1 = Double.parseDouble(t1.getText());
			operator = '-';
			t1.setText("");
			}
		if (e.getSource() == multiply) {
			num1 = Double.parseDouble(t1.getText());
			operator = '*';
			t1.setText("");
			}
		if (e.getSource() == divide) {
			num1 = Double.parseDouble(t1.getText());
			operator = '/';
			t1.setText("");
			}
		if (e.getSource() == clear) {
			t1.setText("");
			}
		if (e.getSource() == delete) {
			String old = (t1.getText().substring(0, t1.getText().length() - 1));
			t1.setText(old);
			}
		if (e.getSource() == equal) {
			num2 = Double.parseDouble(t1.getText());
			switch(operator) {
			case('+'):
				result = num1 + num2;
				break;
			case('-'):
				result = num1 - num2;
				break;
			case('*'):
				result = num1 * num2;
				break;
			case('/'):
				result = num1/num2;
				break;
				}
			t1.setText(String.valueOf(result));
			num1 = result;
			}
		
	}
	public static void main(String[] args) {
		new Calculator();
	}
}
