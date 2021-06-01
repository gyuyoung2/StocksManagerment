package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Listener.ButtonAddListener;
import Listener.ButtonViewListener;

public class MenuSelection extends JPanel { //JFrame 클래스 상속.
	
	WindowFrame frame; //WindowFrame의 frame 선언
	
	public MenuSelection(WindowFrame frame) { //MenuSelction 생성사 생성
		this.frame = frame; //인스턴스로 받은 값을 해당 클래스의 변수에 저장
		
		this.setLayout(new BorderLayout()); //Layout설정
		
		JPanel panel1 = new JPanel(); //JPanel 객체 생성
		JPanel panel2 = new JPanel(); 
		JLabel label = new JLabel("Menu Selection"); //JLabel 객체 생성
		JButton b1 = new JButton("Add Stock"); //JButton 객체 생성
		JButton b2 = new JButton("Delete Stock");
		JButton b3 = new JButton("Edit Stock");
		JButton b4 = new JButton("View Stock");
		JButton b5 = new JButton("Exit");
		
		b1.addActionListener(new ButtonAddListener(frame)); //버튼의 기능 추가(주식 추가기능)
		b4.addActionListener(new ButtonViewListener(frame)); //버튼의 기능 추가(주시 목록 보기 기능)
		
		panel1.add(label); //panel1에 label 추가
		panel2.add(b1); //panel2에 버튼들 추가
		panel2.add(b2);
		panel2.add(b3);
		panel2.add(b4);
		panel2.add(b5);
		
		this.add(panel1, BorderLayout.NORTH); //MenuSelction frame에 panel1을 12시방향 추가
		this.add(panel2, BorderLayout.CENTER); //MenuSelction frame에 panel2을 중간에 추가
		
	}
}
