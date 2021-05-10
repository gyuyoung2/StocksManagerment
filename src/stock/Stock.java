package stock;


import java.util.Scanner;

public abstract class Stock { //Stocks클래스에 저장변수 필드 선언 , Stocks의 객체를 생성하지 않음.
	protected StockKind kind = StockKind.Korea; //주식 종류
	protected String StocksName; //사용자가 입력한 값을 저장하고 name배열에 저장된 값을 반환할 변수 선언
	protected String name; //사용자가 주식 종목 입력한 값을 저장하는 변수 선언
	protected int buyStock; //사용자가 주식를 매수한 가격 값을 저장하는 변수 선언
	protected int goalPrice; //사용자가 주식의 목표가를 입력한 값을 저장하는 변수 선언
	protected String memo; //사용자가 이 종목에 대한 메모한 값을 저장하는 변수 선언
	protected int Dollar; //사용자가 해외주식을 입력할 경우 한화에서 달러로 변경한 값을 저장하는 변수 선언
	
	public Stock() { 
	}
	
	public Stock(StockKind kind) { //method overloading (종류)
		this.kind = kind;
	}
	
	public Stock(StockKind kind, String StocksName, int buyStock, int goalPrice, String memo) {  //Stock 클래스 인자값 안에 주식 종류, 주식종목명, 매수가, 목표가, 종목 메모 순차적으로 저장함
		this.kind = kind; //주식 종류를 kind에 할당
		this.StocksName = StocksName; //주식종목명을 StocksName에 할당
		this.buyStock = buyStock; //매수가를 buyStock에 할당 
		this.goalPrice = goalPrice; //목표가를 goalPrice에 할당
		this.memo = memo; //종목 메모를 memo에 할당
	}
	
	public StockKind getKind() { //getKind() method 생성
		return kind; //반환값으로 현재 kind 값 반환
	}

	public void setKind(StockKind kind) { //setKind() method 생성
		this.kind = kind; //인자값으로 받은 주식 종류 값을 kind에 할당
	}

	public String getStocksName() { //getStocksName() method 생성
		return StocksName; //반환값으로 현재 StocksName 값 반환
	}

	public void setStocksName(String stocksName) { //setStocksName() method 생성
		this.StocksName = stocksName; //인자값으로 받은 종목 이름을 StocksName에 할당
	}

	public int getBuyStock() { //getBuyStock() method 생성
		return buyStock; //반환값으로 현재 buyStock 값 반환
	}

	public void setBuyStock(int buyStock) { //setBuyStock() method 생성
		this.buyStock = buyStock; //인자값으로 받은 매수가 값을 buyStock에 할당
	}

	public int getGoalPrice() { //getGoalPrice() method 생성
		return goalPrice; //반환값으로 현재 goalPrice 값 반환
	}

	public void setGoalPrice(int goalPrice) { //setGoalPrice() method 생성
		this.goalPrice = goalPrice; //인자값으로 받은 목표가 값을 goalPrice에 할당
	}
	
	public String getMemo() { //getMemo() method 생성
		return memo; //반환값으로 현재 memo 값 반환
	}

	public void setmemo(String memo) { //setmemo() method생성.
		this.memo = memo; //인자값으로 받은 메모 값을 memo에 할당
	}
	
	public int getDollar() { //getDollar() method 생성
		return Dollar; //반환값으로 현재 Dollar 값 반환
	}
	
	public void setDollar(int Dollar) { //setDollar() method생성
		this.Dollar = Dollar; //인자값으로 받은 달러 값을 Dollar에 할당
	}
	
	
	public abstract void printInfo(); //각각의 클래스에 printInfo가 있으므로, 추상화 method 생성.
	
	
}
