import java.awt.*;
import java.awt.event.*;

public class Temperature extends Frame implements ActionListener{
	Panel p1,p2,p3,p4,p6, p7,p8,p9,p10;
	Label lp1,lp2,lp4,lp5,lp6,lp7;
	Button b1,b2;
	TextField t1,t2;
	
	public Temperature() {
		setTitle("Temparature Converter");
		setSize(380,270);
		setLayout(new GridLayout(10,0));
		setBackground(Color.LIGHT_GRAY);
		
		
		p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp1 = new Label("Celsius to Fahrenheit");
		p1.add(lp1);
		
		p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp2 = new Label("Start Temp:");
		t1 = new TextField(7);
		b1 = new Button("Convert");
		b1.addActionListener(this);
		p2.add(lp2);p2.add(t1); p2.add(b1);
		
	
		p3 = new Panel(new BorderLayout());
		lp4 = new Label();
		lp4.setAlignment(Label.CENTER);
		p3.add(lp4);
		p4 = new Panel();
		
		

		p6 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp5 = new Label("Fahrenheit to celsius");
		p6.add(lp5);
		
		p7 = new Panel(new FlowLayout(FlowLayout.LEFT));
		lp6= new Label("Start Temp:");
		t2 = new TextField(7);
		b2 = new Button("Convert");
		b2.addActionListener(this);
		p7.add(lp6);p7.add(t2); p7.add(b2);
		p8 = new Panel(new BorderLayout());
		lp7 = new Label();
		lp7.setAlignment(Label.CENTER);
		p8.add(lp7);
		p9 = new Panel();
		p10 = new Panel();
		
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
		

		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
				dispose();
			}
			});
	}
	
	public static void main(String[] args) {
		new Temperature();
	}
	public void actionPerformed(ActionEvent e) {
		
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
