package stock;

import java.util.Scanner;

import exception.SellException;

public interface StockInput {
	
	public String getStocksName(); //getStockName abstract method ����.
	
	public void setStocksName(String stocksName); //setStocksName abstract method ����.
	
	public void setBuyStock(int buyStock) throws SellException ; //setBuyStock abstract method ����.
	
	
	public void setGoalPrice(int goalPrice); //setGoalPrice abstract method ����.
	
	public void setmemo(String memo); //setmemo abstract method ����.
	
	public void setDollar(int Dollar); //setDollar abstract method ����.
	
	public void getUserInput(Scanner input); //getUserInput abstract method ����.
	
	public void printInfo(); //printInfo abstract method ����.
	
	public void setStockName(Scanner input); //setStockName method ����.
	
	public void setStockPrice(Scanner input); //setStockPrice method ����.
	
	public void setStockGoal(Scanner input); //setStockGoal method ����.
	
	public void setStockMemo(Scanner input); //setStockMemo method ����.
	
	public int setStockDollar(Scanner input); //setStockDollar method ����.
	
}
