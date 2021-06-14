package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import GUI.StockAdder;
import GUI.WindowFrame;

public class ButtonAddListener implements ActionListener {
	
	WindowFrame frame;

	public ButtonAddListener(WindowFrame frame) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {  //Button Event
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getStockadder());
		frame.revalidate();
		frame.repaint();
	}

}
