package Listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JTextField;

import StocksManagement.StocksManager;
import exception.SellException;
import stock.KoreaStock;
import stock.Stock;
import stock.StockInput;
import stock.StockKind;

public class StockAdderListener implements ActionListener {

	JTextField fieldName;
	JTextField fieldPrice;
	JTextField fieldGoal;
	JTextField fieldMemo;
	
	StocksManager stocksManager;
	
	public StockAdderListener(
			JTextField fieldName, 
			JTextField fieldPrice, 
			JTextField fieldGoal, 
			JTextField fieldMemo, 
			StocksManager stocksManager) {
		super();
		this.fieldName = fieldName;
		this.fieldPrice = fieldPrice;
		this.fieldGoal = fieldGoal;
		this.fieldMemo = fieldMemo;
		this.stocksManager = stocksManager;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		StockInput stock = new KoreaStock(StockKind.Korea); //생성자 생성
		
		try { //try catch문 생성
			stock.setStocksName(fieldName.getText()); //setStockNamed으로  
			stock.setBuyStock(Integer.parseInt(fieldPrice.getText()));
			stock.setGoalPrice(Integer.parseInt(fieldGoal.getText()));
			stock.setmemo(fieldMemo.getText());
			stocksManager.addStocks(stock);
			putObject(stocksManager, "stockmanager.ser");
			stock.printInfo();
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (SellException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static StocksManager putObject(StocksManager stocksManager ,String fileName) { //putObject method 생성
		try {
			FileOutputStream file = new FileOutputStream(fileName); //FileOutputStream 클래스 생성자 생성
			ObjectOutputStream out = new ObjectOutputStream(file); //ObjectOutputStream 클래스 생성자 생성
			
			out.writeObject(stocksManager); //writeObject method를 통해 파일을 객체에 전달.
			
			out.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManager를 반환
		
	}

}
