package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.StockAdder;
import GUI.WindowFrame;

public class StockAdderCancelListener implements ActionListener {
	
	WindowFrame frame;

	public StockAdderCancelListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getMenuselction());
		frame.revalidate();
		frame.repaint();
	}

}
