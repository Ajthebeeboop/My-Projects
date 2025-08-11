import java.awt.*;
import java.awt.event.*;

//Implements The Window Frame for the UI
public class Temperature extends Frame implements ActionListener{
	//initializing components
	Panel p1,p2,p3,p4,p6, p7,p8,p9,p10;
	Label lp1,lp2,lp4,lp5,lp6,lp7;
	Button b1,b2;
	TextField t1,t2;
	
	//Constructor for temperature frame
	public Temperature() {
		setTitle("Temparature Converter");
		setSize(380,270);
		setLayout(new GridLayout(10,0));
		setBackground(Color.LIGHT_GRAY);
		
		//Celsius-Fahrenheit panel sets as label object panel
		p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp1 = new Label("Celsius to Fahrenheit");
		p1.add(lp1);
		
		//Start temperature label and Conversion button set as the first panel, button listens for functionality
		p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp2 = new Label("Start Temp:");
		t1 = new TextField(7);
		b1 = new Button("Convert");
		b1.addActionListener(this);
		p2.add(lp2);p2.add(t1); p2.add(b1);
		
		
		//Panel for spacing
		p3 = new Panel(new BorderLayout());
		lp4 = new Label();
		lp4.setAlignment(Label.CENTER);
		p3.add(lp4);
		p4 = new Panel();
		
		
		//Celsius-Fareheit panel sets as label object panel
		p6 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp5 = new Label("Fahrenheit to celsius");
		p6.add(lp5);
		
		//Start temperature label and Conversion button set as the second panel, button listens for functionality
		p7 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp6= new Label("Start Temp:");
		t2 = new TextField(7);
		b2 = new Button("Convert");
		b2.addActionListener(this);
		p7.add(lp6);p7.add(t2); p7.add(b2);
		
		//Panel for spacing
		p8 = new Panel(new BorderLayout());
		lp7 = new Label();
		lp7.setAlignment(Label.CENTER);
		p8.add(lp7);
		p9 = new Panel();
		p10 = new Panel();
		
		
		//All panels are added accordingly
		add(p1);
		add(p2);
		add(p3);
		add(p4);
		add(p6);
		add(p7);
		add(p8);
		add(p9);
		add(p10);
		
		
		
		
		
		setVisible(true);
		setResizable(false);
		
		
		//So that you can close the window using the X button 
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			});
	}
	
	//Initializes new Temperature Window 
	public static void main(String[] args) {
		new Temperature();
	}
	
	//Button Functionality
	public void actionPerformed(ActionEvent e) {
		
		//If it clicks the Celsius-Fahrenheit convert button, Calculates the result using the Fahrenheit Formula. Else It catches an error
		if (e.getSource() == b1) {
			try {
				double c = Double.parseDouble(t1.getText());
				double Formula = ((9.0/5.0* c) + 32);
				String res ="Fahrenheit: "+ Formula;
				
				lp4.setText(String.valueOf(res));
			}
			catch(NumberFormatException ex) {
				lp4.setText("Invalid Input");
				
			}
	}
		//If it clicks the Fahrenheit-Celsius convert button, Calculates the result using the Celsius Formula. Else It catches an error
		if (e.getSource() == b2) {
			try {
				double F = Double.parseDouble(t2.getText());
				double Formula = ((F-32)*5.0/9.0);
				String res ="Celsius: "+ Formula;
				
				lp7.setText(String.valueOf(res));
			}
			catch(NumberFormatException ex) {
				lp7.setText("Invalid Input");
				
			}

		}
	}
}
