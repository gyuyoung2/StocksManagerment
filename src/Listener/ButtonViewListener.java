package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;

import GUI.StockViewer;
import GUI.WindowFrame;
import StocksManagement.StocksManager;

public class ButtonViewListener implements ActionListener {
	
	WindowFrame frame;

	public ButtonViewListener(WindowFrame frame) {
		this.frame = frame;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		StockViewer stockViewer = frame.getStockviewer(); 
		StocksManager stocksManager = getObject("stockmanager.ser"); //stocksManager ��ü�� ������.
		stockViewer.setStocksManager(stocksManager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(stockViewer);
		frame.revalidate();
		frame.repaint();
	}
	
	public static StocksManager getObject(String fileName) { //getObject method ����
		StocksManager stocksManager = null; //stocksManager �ʱ�ȭ
		
		
		try { //try/catch�� ����
			FileInputStream file = new FileInputStream(fileName); //FileInputStream Ŭ���� ������ ����
			ObjectInputStream in = new ObjectInputStream(file); //ObjectInputStream Ŭ���� ������ ����
			
			stocksManager = (StocksManager) in.readObject(); //readObject method�� �̿��� ������ �о��
			
			in.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			return stocksManager; //stocksManger�� ��ȯ��
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManger�� ��ȯ��
		
	}

}
