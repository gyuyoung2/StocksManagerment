package stock;

import java.util.Scanner;

import exception.SellException;

public interface StockInput {
	
	public String getStocksName(); //getStockName abstract method 識情.
	
	public void setStocksName(String stocksName); //setStocksName abstract method 識情.
	
	public void setBuyStock(int buyStock) throws SellException ; //setBuyStock abstract method 識情.
	
	
	public void setGoalPrice(int goalPrice); //setGoalPrice abstract method 識情.
	
	public void setmemo(String memo); //setmemo abstract method 識情.
	
	public void setDollar(int Dollar); //setDollar abstract method 識情.
	
	public void getUserInput(Scanner input); //getUserInput abstract method 識情.
	
	public void printInfo(); //printInfo abstract method 識情.
	
	public void setStockName(Scanner input); //setStockName method 識情.
	
	public void setStockPrice(Scanner input); //setStockPrice method 識情.
	
	public void setStockGoal(Scanner input); //setStockGoal method 識情.
	
	public void setStockMemo(Scanner input); //setStockMemo method 識情.
	
	public int setStockDollar(Scanner input); //setStockDollar method 識情.
	
}
