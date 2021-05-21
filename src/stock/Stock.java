package stock;


import java.io.Serializable;
import java.util.Scanner;

import exception.SellException;

public abstract class Stock implements StockInput, Serializable { /** //Stocks클래스에 저장변수 필드 선언 , Stocks의 객체를 생성하지 않음.
	 * 
	 */
	private static final long serialVersionUID = 8737937472405928517L;

private static final int Null = 0;
	
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

	public void setBuyStock(int buyStock) throws SellException { //setBuyStock() method 생성
		if (buyStock<=0 || buyStock == Null) {
			throw new SellException();
		}
		
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
	
	public void setStockName(Scanner input) { //setStockName method 생성
		System.out.print("종목 이름: "); //사용자에게 종목이름을 입력 안내문 출력
		String StocksName = input.next(); //입력한 종목이름을 StocksName에 할당
		this.setStocksName(StocksName); //그 입력된값을 setStocksName method의 인자값으로 들어가 이름이 저장됨
	}	
	
	public void setStockPrice(Scanner input) { //setStockPrice method 생성
		int buyStock = 0;
		while (buyStock <= 0) {
			System.out.print("종목 매수가: "); //사용자에게 종목 매수가를 입력 안내문 출력
			buyStock = input.nextInt(); //입력한 매수가를 buyStock에 할당
			try {
				this.setBuyStock(buyStock);
			} catch (SellException e) { //try/catch문을 활용함으로써 예외처리
				System.out.println("매수가를 0원이상으로 적어주세요."); //오류 안내문 출력
			}//그 입력된값을 setBuyStock method의 인자값으로 들어가 매수가 값이 저장됨
		}
	}
	
	public void setStockGoal(Scanner input) { //setStckGoal method 생성
		System.out.print("이 종목의 목표가를 입력해주세요 :"); //사용자에게 목표가를 받기위해 안내문 출력
		int goalPrice = input.nextInt(); //사용자에게 목표가 값을 받아 Stocks클래스의 goalPrice에 저장
		this.setGoalPrice(goalPrice); //입력받은 값을 setGoalPrice method의 인자값으로 들어가 목표가 값이 저장됨
	}
	
	public void setStockMemo(Scanner input) { //setStockMemo method 생성
		System.out.print("memo"); //memo 보기 출력
		String memo = input.next(); //사용자에게 메모의 내용을 받아 Stocks클래스의 memo에 저장
		this.setmemo(memo);  //입력받은 값을 setmemo method의 인자값으로 들어가 종목메모 값이 저장됨
	}
	
	public int setStockDollar(Scanner input) { //setStockDollar method 생성
		int Dollar = 1170; //달러 변수에 현재 달러 저장
		System.out.print("Exchange rate of Dollar:"); //환율 보기 출력
		int Dollar1 = getBuyStock() / Dollar; // 매수가 환율계산
		int Dollar2 = getGoalPrice() / Dollar; //목표가 환율계산
		this.setDollar(Dollar1);  //입력받은 값을 setPriceDollar method의 인자값으로 들어가 매수가 환율값이 저장됨
		System.out.print("매수가 환율: " + Dollar1 + "달러"); //매수가 달러 출력
		System.out.println("목표가 환율: " + Dollar2 + "달러"); // 목표가 달러 출력
		return Dollar1; //매수가 달러 반환
	}
	
}
