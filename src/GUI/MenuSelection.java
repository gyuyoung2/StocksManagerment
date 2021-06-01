package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Listener.ButtonAddListener;
import Listener.ButtonViewListener;

public class MenuSelection extends JPanel { //JFrame Ŭ���� ���.
	
	WindowFrame frame; //WindowFrame�� frame ����
	
	public MenuSelection(WindowFrame frame) { //MenuSelction ������ ����
		this.frame = frame; //�ν��Ͻ��� ���� ���� �ش� Ŭ������ ������ ����
		
		this.setLayout(new BorderLayout()); //Layout����
		
		JPanel panel1 = new JPanel(); //JPanel ��ü ����
		JPanel panel2 = new JPanel(); 
		JLabel label = new JLabel("Menu Selection"); //JLabel ��ü ����
		JButton b1 = new JButton("Add Stock"); //JButton ��ü ����
		JButton b2 = new JButton("Delete Stock");
		JButton b3 = new JButton("Edit Stock");
		JButton b4 = new JButton("View Stock");
		JButton b5 = new JButton("Exit");
		
		b1.addActionListener(new ButtonAddListener(frame)); //��ư�� ��� �߰�(�ֽ� �߰����)
		b4.addActionListener(new ButtonViewListener(frame)); //��ư�� ��� �߰�(�ֽ� ��� ���� ���)
		
		panel1.add(label); //panel1�� label �߰�
		panel2.add(b1); //panel2�� ��ư�� �߰�
		panel2.add(b2);
		panel2.add(b3);
		panel2.add(b4);
		panel2.add(b5);
		
		this.add(panel1, BorderLayout.NORTH); //MenuSelction frame�� panel1�� 12�ù��� �߰�
		this.add(panel2, BorderLayout.CENTER); //MenuSelction frame�� panel2�� �߰��� �߰�
		
	}
}
