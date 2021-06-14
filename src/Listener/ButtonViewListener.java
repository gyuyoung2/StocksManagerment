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
		StocksManager stocksManager = getObject("stockmanager.ser"); //stocksManager 객체를 가져옴.
		stockViewer.setStocksManager(stocksManager);
		
		frame.getContentPane().removeAll();
		frame.getContentPane().add(stockViewer);
		frame.revalidate();
		frame.repaint();
	}
	
	public static StocksManager getObject(String fileName) { //getObject method 생성
		StocksManager stocksManager = null; //stocksManager 초기화
		
		
		try { //try/catch문 실행
			FileInputStream file = new FileInputStream(fileName); //FileInputStream 클래스 생성자 생성
			ObjectInputStream in = new ObjectInputStream(file); //ObjectInputStream 클래스 생성자 생성
			
			stocksManager = (StocksManager) in.readObject(); //readObject method를 이용해 파일을 읽어옴
			
			in.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			return stocksManager; //stocksManger를 반환함
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManger를 반환함
		
	}

}
