import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;



public class FinanceTracker extends JFrame implements ActionListener {
	String nam, desc, type;
	File myfile = new File("Tracker.txt");
	int no = 1;
	Double amo;
	JPanel p1, p2,p3;
	JTextArea IDt,t3;
	JLabel ID, Name, Description, Due;
	ButtonGroup sel;
	JRadioButton Expenses, Income;
	JTextField  Namet, Descriptiont, Duet;
	JButton clear, submit;
	
	
	public FinanceTracker() {
		setTitle("Finance Tracker app");
        setSize(400, 300);
        setLayout(new BorderLayout());

        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        // Top Panel - ID label
        ID = new JLabel("ID: #" + no);
        ID.setFont(new Font("Arial", Font.PLAIN, 20));
        p2.setLayout(new FlowLayout(FlowLayout.LEFT));
        p2.add(ID);

        // Input Fields
        Name = new JLabel("Name:");
        Description = new JLabel("Description:");
        Due = new JLabel("Amount:");
        Namet = new JTextField(15);
        Descriptiont = new JTextField(15);
        Duet = new JTextField(15);

        // Radio Buttons
        Expenses = new JRadioButton("Expenses");
        Income = new JRadioButton("Income");
        sel = new ButtonGroup();
        sel.add(Income);
        sel.add(Expenses);

        // Buttons
        clear = new JButton("Clear");
        submit = new JButton("Submit");
        clear.addActionListener(this);
        submit.addActionListener(this);

        // Center Panel - Using GridBagLayout
        p1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        p1.add(Name, gbc);
        gbc.gridx = 1;
        p1.add(Namet, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        p1.add(Description, gbc);
        gbc.gridx = 1;
        p1.add(Descriptiont, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        p1.add(Due, gbc);
        gbc.gridx = 1;
        p1.add(Duet, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        p1.add(Income, gbc);
        gbc.gridx = 1;
        p1.add(Expenses, gbc);

        // Bottom Panel - Buttons
        p3.add(clear);
        p3.add(submit);

        // Add Panels to Frame
        add(p2, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        add(p3, BorderLayout.SOUTH);

        setVisible(true);
        setResizable(false);		
	}

	public static void main(String[] args) {
		new FinanceTracker();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == submit) {
		try {
			nam = Namet.getText();
			desc = Descriptiont.getText();
			amo = Double.parseDouble(Duet.getText());
			if (Income.isSelected()) {
				type = "Income";
			}
			else{
				type = "Expenses";
			}
			JOptionPane.showMessageDialog(null, "Entry Successful", "Success", JOptionPane.INFORMATION_MESSAGE);
			ID.setText("ID: #" + (++no));
			
				BufferedWriter br = new BufferedWriter(new FileWriter(myfile,true));
				String output  = "Name: " + nam + ", "+ desc + ", Type: "+ type + ", Amount: "+ amo;
				br.write(output);
				br.newLine();
				br.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Amount must not be a string", "Error", JOptionPane.ERROR_MESSAGE);		
			}
			
			
		}
		if(e.getSource() ==  clear) {
			Namet.setText("");
			Descriptiont.setText("");
			Duet.setText("");
			sel.clearSelection();
		
		}
	}

}
