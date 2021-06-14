package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import Listener.StockAdderCancelListener;
import Listener.StockAdderListener;
import StocksManagement.StocksManager;

public class StockAdder extends JPanel { //JFrame Ŭ���� ���
	
	WindowFrame frame; //frame ����.
	
	StocksManager stocksManager;
	
	public StockAdder(WindowFrame frame, StocksManager stocksManager) { //StockAdder ������ ����
		this.frame = frame; //�ν��Ͻ��� ���� ���� �ش� Ŭ���� ������ ����
		this.stocksManager = stocksManager; //
		JPanel panel = new JPanel(); //JPanel ��ü ����
		panel.setLayout(new SpringLayout()); //setLayout method
		
		JLabel labelName = new JLabel("Company Name: ", JLabel.TRAILING); //���������� ��ġ
		JTextField fieldName = new JTextField(10); //JTextField ��ü ����
		labelName.setLabelFor(fieldName); //labelName�� field�� �߰�
		panel.add(labelName); //panel�� label �߰�.
		panel.add(fieldName);
		
		JLabel labelPrice = new JLabel("Buy Price: ", JLabel.TRAILING); //���������� ��ġ
		JTextField fieldPrice = new JTextField(10); //JTextField ��ü ����
		labelPrice.setLabelFor(fieldPrice); //labelPrice�� field�� �߰�
		panel.add(labelPrice); //panel�� label �߰�
		panel.add(fieldPrice); //panel�� field �߰�
		
		JLabel labelGoal = new JLabel("Goal Price: ", JLabel.TRAILING); //���������� ��ġ
		JTextField fieldGoal = new JTextField(10); //JTextField ��ü ����
		labelGoal.setLabelFor(fieldGoal); //labelGoal�� field�� �߰�
		panel.add(labelGoal); //panel�� label �߰�
		panel.add(fieldGoal); //panel�� field �߰�
		
		JLabel labelMemo = new JLabel("Memo: ", JLabel.TRAILING); //���������� ��ġ
		JTextField fieldMemo = new JTextField(10); //JTextField ��ü ����
		labelMemo.setLabelFor(fieldMemo); //labelMemo�� field�� �߰�
		
		JButton saveButton = new JButton("Save"); //���� ��ư ����
		saveButton.addActionListener(new StockAdderListener(fieldName,fieldPrice,fieldGoal,fieldMemo,stocksManager)); //save listener
		
		JButton cancelButton = new JButton("Cancel"); //��� ��ư ����
		cancelButton.addActionListener(new StockAdderCancelListener(frame)); //cancel listener
		
		panel.add(labelMemo); //panel�� label �߰�
		panel.add(fieldMemo); //panel�� field �߰�
		
		panel.add(saveButton); //���� ��ư panel�� �߰�
		panel.add(cancelButton); //��� ��ư panel�� �߰�
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6); //makeCompactGrid method�� ���� panel�� ���� ��ġ ����
		
	
		this.add(panel); //frame�� ContentPane�� panel�� ����
		this.setVisible(true); //â�� ���̵��� ��
	}
}
