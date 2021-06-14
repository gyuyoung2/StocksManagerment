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

public class StockAdder extends JPanel { //JFrame 클래스 상속
	
	WindowFrame frame; //frame 선언.
	
	StocksManager stocksManager;
	
	public StockAdder(WindowFrame frame, StocksManager stocksManager) { //StockAdder 생성자 생성
		this.frame = frame; //인스턴스로 받은 값을 해당 클래스 변수에 저장
		this.stocksManager = stocksManager; //
		JPanel panel = new JPanel(); //JPanel 객체 생성
		panel.setLayout(new SpringLayout()); //setLayout method
		
		JLabel labelName = new JLabel("Company Name: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldName = new JTextField(10); //JTextField 객체 생성
		labelName.setLabelFor(fieldName); //labelName에 field값 추가
		panel.add(labelName); //panel에 label 추가.
		panel.add(fieldName);
		
		JLabel labelPrice = new JLabel("Buy Price: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldPrice = new JTextField(10); //JTextField 객체 생성
		labelPrice.setLabelFor(fieldPrice); //labelPrice에 field값 추가
		panel.add(labelPrice); //panel에 label 추가
		panel.add(fieldPrice); //panel에 field 추가
		
		JLabel labelGoal = new JLabel("Goal Price: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldGoal = new JTextField(10); //JTextField 객체 생성
		labelGoal.setLabelFor(fieldGoal); //labelGoal에 field값 추가
		panel.add(labelGoal); //panel에 label 추가
		panel.add(fieldGoal); //panel에 field 추가
		
		JLabel labelMemo = new JLabel("Memo: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldMemo = new JTextField(10); //JTextField 객체 생성
		labelMemo.setLabelFor(fieldMemo); //labelMemo에 field값 추가
		
		JButton saveButton = new JButton("Save"); //저장 버튼 생성
		saveButton.addActionListener(new StockAdderListener(fieldName,fieldPrice,fieldGoal,fieldMemo,stocksManager)); //save listener
		
		JButton cancelButton = new JButton("Cancel"); //취소 버튼 생성
		cancelButton.addActionListener(new StockAdderCancelListener(frame)); //cancel listener
		
		panel.add(labelMemo); //panel에 label 추가
		panel.add(fieldMemo); //panel에 field 추가
		
		panel.add(saveButton); //저장 버튼 panel에 추가
		panel.add(cancelButton); //취소 버튼 panel에 추가
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6); //makeCompactGrid method를 통해 panel의 각각 위치 설정
		
	
		this.add(panel); //frame에 ContentPane을 panel로 변경
		this.setVisible(true); //창이 보이도록 함
	}
}
