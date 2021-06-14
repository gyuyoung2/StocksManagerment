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
		StockInput stock = new KoreaStock(StockKind.Korea); //������ ����
		
		try { //try catch�� ����
			stock.setStocksName(fieldName.getText()); //setStockNamed���� fieldName ����
			stock.setBuyStock(Integer.parseInt(fieldPrice.getText())); //setBuyStock���� fieldPrice ����
			stock.setGoalPrice(Integer.parseInt(fieldGoal.getText())); //setGoalPrice���� fieldGoal ����
			stock.setmemo(fieldMemo.getText()); //setMemo���� fieldMemo ����
			stocksManager.addStocks(stock); //addStock()
			putObject(stocksManager, "stockmanager.ser"); //putObject�� ���Ƿ� �����͸� �ҷ���
			stock.printInfo(); //����ڰ� �Է��� ������� ������
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (SellException e1) {
			e1.printStackTrace();
		}
		
	}
	
	public static StocksManager putObject(StocksManager stocksManager ,String fileName) { //putObject method ����
		try {
			FileOutputStream file = new FileOutputStream(fileName); //FileOutputStream Ŭ���� ������ ����
			ObjectOutputStream out = new ObjectOutputStream(file); //ObjectOutputStream Ŭ���� ������ ����
			
			out.writeObject(stocksManager); //writeObject method�� ���� ������ ��ü�� ����.
			
			out.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManager�� ��ȯ
		
	}

}
