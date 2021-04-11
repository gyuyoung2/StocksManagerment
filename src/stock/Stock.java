package stock;


import java.util.Scanner;

public class Stock { //Stocks클래스에 저장변수 필드 선언 
	protected StockKind kind = StockKind.Korea;
	protected String StocksName; //사용자가 입력한 값을 저장하고 name배열에 저장된 값을 반환할 변수 선언
	protected String name; //사용자가 주식 종목 입력한 값을 저장하는 변수 선언
	protected int buyStock; //사용자가 주식를 매수한 가격 값을 저장하는 변수 선언
	protected int goalPrice; //사용자가 주식의 목표가를 입력한 값을 저장하는 변수 선언
	protected String memo; //사용자가 이 종목에 대한 메모한 값을 저장하는 변수 선언
	
	public Stock() { 
	}
	
	public Stock(String StocksName, int buyStock, int goalPrice, String memo) { 
		//Stock 클래스 인자값안에 주식종목명, 매수가, 목표가, 종목 메모 순차적으로 저장함
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

	public void setmemo(String memo) { //setmemo() method생성
		this.memo = memo; //인자값으로 받은 메모 값을 memo에 할당
	}
	
	public void printInfo() { //주식정보를 출력해주는 printInfo() method 
		System.out.println("종목명: "+ StocksName + " 매수가: "+buyStock+"원 목표가: "+goalPrice+"원 메모: "+memo);//주식정보 출력
	}
	
	public void getUserInput(Scanner input) { //정보를 입력하는 getUserInput method 생성
		System.out.print("주식 종목 명을 입력해주세요: "); //사용자에게 주식 종목명을 입력 안내문 출력
		String StocksName = input.next(); //사용자에게 종목 값을 받아 Stocks클래스의 StocksName에 저장
		this.setStocksName(StocksName); //입력받은 값을 setStocksName method의 인자값으로 들어가 종목명이 저장됨
		
		System.out.print("이 종목의 매수가를 입력해주세요 :"); //사용자에게 종목의 매수가를 받기위해 안내문 출력
		int buyStock = input.nextInt(); //사용자에게 매수가 값을 받아 Stocks클래스의 buyStock에 저장
		this.setBuyStock(buyStock); //입력받은 값을 setBuyStock method의 인자값으로 들어가 매수가 값이 저장됨
		
		System.out.print("이 종목의 목표가를 입력해주세요 :"); //사용자에게 목표가를 받기위해 안내문 출력
		int goalPrice = input.nextInt(); //사용자에게 목표가 값을 받아 Stocks클래스의 goalPrice에 저장
		this.setGoalPrice(goalPrice); //입력받은 값을 setGoalPrice method의 인자값으로 들어가 목표가 값이 저장됨
		
		System.out.print("종목 메모:"); //사용자가 이 종목의 메모를 받기위해 안내문 출력
		String memo = input.next(); //사용자에게 메모의 내용을 받아 Stocks클래스의 memo에 저장
		this.setmemo(memo); //입력받은 값을 setmemo method의 인자값으로 들어가 종목메모 값이 저장됨
	}
	
	
	
	
}
