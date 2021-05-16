package stock;

import java.util.Scanner;

import exception.SellException;

public interface StockInput {
	
	public String getStocksName(); //getStockName abstract method 선언..
	
	public void setStocksName(String stocksName); //setStocksName abstract method 선언.
	
	public void setBuyStock(int buyStock) throws SellException ; //setBuyStock abstract method 선언.
	
	
	public void setGoalPrice(int goalPrice); //setGoalPrice abstract method 선언.
	
	public void setmemo(String memo); //setmemo abstract method 선언.
	
	public void setDollar(int Dollar); //setDollar abstract method 선언.
	
	public void getUserInput(Scanner input); //getUserInput abstract method 선언.
	
	public void printInfo(); //printInfo abstract method 선언.
	
	public void setStockName(Scanner input); //setStockName method 선언.
	
	public void setStockPrice(Scanner input); //setStockPrice method 선언.
	
	public void setStockGoal(Scanner input); //setStockGoal method 선언.
	
	public void setStockMemo(Scanner input); //setStockMemo method 선언.
	
	public int setStockDollar(Scanner input); //setStockDollar method 선언.
	
}
