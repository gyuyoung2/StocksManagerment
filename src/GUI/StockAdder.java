package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class StockAdder extends JFrame {
	public StockAdder() {
		JPanel panel = new JPanel();
		panel.setLayout(new SpringLayout());
		
		JLabel labelName = new JLabel("Company Name: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldName = new JTextField(10);
		labelName.setLabelFor(fieldName);
		panel.add(labelName);
		panel.add(fieldName);
		
		JLabel labelPrice = new JLabel("Buy Price: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldPrice = new JTextField(10);
		labelPrice.setLabelFor(fieldPrice);
		panel.add(labelPrice);
		panel.add(fieldPrice);
		
		JLabel labelGoal = new JLabel("Goal Price: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldGoal = new JTextField(10);
		labelGoal.setLabelFor(fieldGoal);
		panel.add(labelGoal);
		panel.add(fieldGoal);
		
		JLabel labelMemo = new JLabel("Memo: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldMemo = new JTextField(10);
		labelMemo.setLabelFor(fieldMemo);
		panel.add(labelMemo);
		panel.add(fieldMemo);
		
		panel.add(new JButton("Save"));
		panel.add(new JButton("Cancel"));
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6);
		
		this.setSize(500,500);
		this.setContentPane(panel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
