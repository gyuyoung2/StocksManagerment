package stock;

import java.util.Scanner;

public interface StockInput {
	
	public String getStocksName(); //getStockName abstract method 선언..
	public void setStocksName(String stocksName); //setStocksName abstract method 선언.
	public void setBuyStock(int buyStock); //setBuyStock abstract method 선언.
	public void setGoalPrice(int goalPrice); //setGoalPrice abstract method 선언.
	public void setmemo(String memo); //setmemo abstract method 선언.
	public void setDollar(int Dollar); //setDollar abstract method 선언.
	
	public void getUserInput(Scanner input); //getUserInput abstract method 선언.
	public void printInfo(); //printInfo abstract method 선언.
	
}
