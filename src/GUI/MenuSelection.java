package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuSelection extends JFrame { //JFrame 클래스 상속
	
	public MenuSelection() { //MenuSelction 생성사 생성
		this.setSize(500,500); //GUI크기 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창이 닫히면 프로그램 종료
		
		JPanel panel1 = new JPanel(); //JPanel 객체 생성
		JPanel panel2 = new JPanel(); 
		JLabel label = new JLabel("Menu Selection"); //JLabel 객체 생성
		JButton b1 = new JButton("Add Stock"); //JButton 객체 생성
		JButton b2 = new JButton("Delete Stock");
		JButton b3 = new JButton("Edit Stock");
		JButton b4 = new JButton("View Stock");
		JButton b5 = new JButton("Exit");
		
		panel1.add(label); //panel1에 label 추가
		panel2.add(b1); //panel2에 버튼들 추가
		panel2.add(b2);
		panel2.add(b3);
		panel2.add(b4);
		panel2.add(b5);
		
		this.add(panel1, BorderLayout.NORTH); //MenuSelction frame에 panel1을 12시방향 추가
		this.add(panel2, BorderLayout.CENTER); //MenuSelction frame에 panel2을 중간에 추가
		this.setVisible(true); //창이 시각적으로 보임
	}
}
