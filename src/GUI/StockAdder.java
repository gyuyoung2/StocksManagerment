package GUI;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class StockAdder extends JFrame { //JFrame 클래스 상속
	public StockAdder() { //StockAdder 생성자 생성
		JPanel panel = new JPanel(); //JPanel 객체 생성
		panel.setLayout(new SpringLayout()); //setLayout method
		
		JLabel labelName = new JLabel("Company Name: ", JLabel.TRAILING); //오른쪽으로 배치
		JTextField fieldName = new JTextField(10); //JTextField 객체 생성
		labelName.setLabelFor(fieldName); //labelName에 field값 추가
		panel.add(labelName); //panel에 label 추가
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
		panel.add(labelMemo); //panel에 label 추가
		panel.add(fieldMemo); //panel에 field 추가
		
		panel.add(new JButton("Save")); //저장 버튼 panel에 추가
		panel.add(new JButton("Cancel")); //취소 버튼 panel에 추가
		
		SpringUtilities.makeCompactGrid(panel, 5, 2, 6, 6, 6, 6); //makeCompactGrid method를 통해 panel의 각각 위치 설정
		
		this.setSize(500,500); //GUI창의 크기 설정
		this.setContentPane(panel); //frame에 ContentPane을 panel로 변경
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창을 닫으면 프로그램 종료
		this.setVisible(true); //창이 보이도록 함
	}
}
