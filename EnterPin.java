import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class EnterPin extends JFrame implements ActionListener {
	JPanel Main, Grid;
	JTextField t1;
	JButton Clear, Enter;
	JButton[] NumButton = new JButton[10];
	
	String num1 = "";
	final String num2 = "5467";
	int error = 0;
	
	public EnterPin() {
		setTitle("Pin Enter App");
		setSize(500,300);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Main = new JPanel();
		t1 = new JTextField("CLOSE",18);
		t1.setHorizontalAlignment(SwingConstants.RIGHT);
		t1.setEditable(false);
		t1.setFont(new Font("Arial",Font.PLAIN, 30));
		
		Main.add(t1);
		add(Main,BorderLayout.NORTH);
		
		Grid = new JPanel(new GridLayout(4,3));
		for(int i = 0; i < NumButton.length; i++) {
			NumButton[i] = new JButton(""+i);
			NumButton[i].addActionListener(this);
			NumButton[i].setFont(new Font((i+""), Font.PLAIN, 24));
		}
		Clear = new JButton("CLEAR");
		Clear.addActionListener(this);
		Clear.setFont(new Font(null, Font.PLAIN, 24));
		Enter = new JButton("ENTER");
		Enter.setFont(new Font(null, Font.PLAIN, 24));
		Enter.addActionListener(this);
		Grid.add(NumButton[1]);Grid.add(NumButton[2]);Grid.add(NumButton[3]);
		Grid.add(NumButton[4]);Grid.add(NumButton[5]);Grid.add(NumButton[6]);
		Grid.add(NumButton[7]);Grid.add(NumButton[8]);Grid.add(NumButton[9]);
		Grid.add(Clear);Grid.add(NumButton[0]);Grid.add(Enter);
		
		add(Grid,BorderLayout.CENTER);
		
		setVisible(true);
		setResizable(false);	
	}
	public static void main(String[] args) {
		new EnterPin();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
			 for (int i = 0; i < NumButton.length; i++) {
			        if (e.getSource() == NumButton[i]) {
			            if (t1.getText().equals("CLOSE") || t1.getText().equals("WRONG PIN") || 
			                t1.getText().equals("Entry failed, please retry")) {
			                t1.setText("");
			                t1.setForeground(Color.BLACK);
			                num1 = "";
			            }
			            t1.setText(t1.getText() + "*");
			            num1 += i;     
			        }
			    }
			    if (e.getSource() == Clear) {
			        t1.setForeground(Color.BLACK);
			        t1.setText("CLOSE");
			        Enter.setEnabled(true);
			        num1 = "";
			    }
			    if (e.getSource() == Enter) {
			        if (num1.equals(num2)) {
			            t1.setForeground(Color.GREEN);
			            t1.setText("OPEN");
			            Enter.setEnabled(false);
			            error = 0;
			            num1 = "";
			        } else {
			            error++;
			            t1.setForeground(Color.RED);
			            if (error == 4) {
			                t1.setText("Entry failed, please retry");
			                Enter.setEnabled(false);
			                error = 0;
			            } else {
			                t1.setText("WRONG PIN");
			            }
			            num1 = "";
			        }
			    }
			}
		}
