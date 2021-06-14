package StocksManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import stock.KoreaStock;
import stock.OverseaStock;
import stock.Stock;
import stock.StockInput;
import stock.StockKind;	

public class StocksManager implements Serializable { //Serializable 구현
	/**
	 * 
	 */
	private static final long serialVersionUID = 8934422693209771066L;
	
	ArrayList<StockInput> stocks = new ArrayList<StockInput>(); //ArrayList를 활용하기 위해 stocks 객체 생성
	transient Scanner input; //input 생성자 선언
	StocksManager(Scanner input){ //생성자 인자값에 Scanner input을 넣으므로써 
		this.input = input; //사용자가 입력하는 값 저장을 도와주는 input 생성
	}
	
	public void addStocks(String Name, String Price, String Goal, String Memo) {
		StockInput stockInput = new KoreaStock(StockKind.Korea); // 생성자 생성
		stockInput.getUserInput(input); //Stock 클래스의 getUserInput() method 실행
		stocks.add(stockInput);
	}
	
	public void addStocks(StockInput stockInput) {
		stocks.add(stockInput);
	}
	
	public void addStocks(){ //주식'종목 정보'추가하는 함수 생성
		Scanner input = new Scanner(System.in);
		int kind = 0; //사용자가 메뉴 입력할 변수 선언과 초기화
		StockInput stockInput; //Stock 클래스 생성자 생성
		while(kind != 1 || kind != 2) { //사용자가 1,2 이외에 숫자를 입력할때까지 반복
			try {
			System.out.print("1. 국내주식"); //국내주식 종목 추가 안내
			System.out.println(" 2. 해외주식"); //해외주식 종목 추가 안내
			System.out.print("주식종류를 선택해주세요 between 1 - 2: "); //사용자에게 종목종류를 입력받을려고 안내문 출력
			kind = input.nextInt(); //사용자가 입력한 값을 kind변수에 할당
			if (kind == 1) { //사용자가 국내주식을 선택
				stockInput = new KoreaStock(StockKind.Korea); // 생성자 생성
				stockInput.getUserInput(input); //Stock 클래스의 getUserInput() method 실행
				stocks.add(stockInput); //자료형ArrayList Stocks 클래스의 안 속성들에 값 add함수로 할당 
				break;// 종료
			}
			else if (kind == 2) { //사용자가 해외주식을 선택
				stockInput = new OverseaStock(StockKind.Oversea); //생성자 생성
				stockInput.getUserInput(input); //Stock 클래스의 getUserInput() method 실행
				stocks.add(stockInput); //자료형ArrayList Stocks 클래스의 안 속성들에 값 add함수로 할당  
				break; //종료
			}
			else {
				System.out.print("주식종류를 선택해주세요 1 or 2: "); //사용자에게 올바른 값을 입력할때까지 출력
			}
		}
			catch(InputMismatchException e) { //try/catch문을 통해 예외처리
				System.out.println("Please put an integer between 1 and 2f!"); //오류 안내문 출력
				if(this.input.hasNext()) { 
					this.input.next();
				}
				kind = -1;
			}
		}
	}
	
	public void deleteStocks(){ //주식'종목 정보'삭제하는 함수 생성
		Scanner input = new Scanner(System.in);
		System.out.println("어떤 종목을 삭제하시겠습니까?"); // 사용자에게 삭제 할 종목 입력 안내문 출력
		String name = input.next(); //삭제할 종목명 입력값을 name에 할당
		int index = findIndex(name); //findIndex method에서 반환한 index값을 index변수에 저장
		removefromStocks(index, name); //removefromStocks method를 통해 해당 index데이터 삭제
		
	}
	
	public int findIndex(String name) { //findIndex method 생성
		int index = -1; //array가 index를 못찾는것을 예상 하기 위해 index에 -1 할당.
		for(int i = 0; i<stocks.size(); i++) { //name배열에 입력된 크기만큼 for반복문 실행하게 loop설계
			if(stocks.get(i).getStocksName().equals(name)) { //입력한 종목이 내가 저장한 종목가 같으면 index값 할당
				index = i; //index값 할당
				break; //종료
			}
		}
		return index; //index값 반환
	}
	
	public int removefromStocks(int index, String name) { //removefromStocks method 생성
		if(index >= 0) { //index값이 0이상
			stocks.remove(index); //배열 index값 정보 삭제
			System.out.println("입력된 종목 " + name + "이(가) 삭제되었습니다."); //사용자가 입력한 종목 삭제 안내문 출력
			return 1;
		} 
	else { //index값이 음수일경우
			System.out.println("입력된 종목은 정보가 없습니다."); //사용자에게 입력한 정보 없음 안내문 출력
			return -1;
		}
	}
	
	
	public void editStocks() { //주식'종목 정보' 수정하는 함수 생성
		Scanner input = new Scanner(System.in);
		System.out.print("종목 이름: "); //사용자에게 수정할 주식 종목 입력 안내문 출력
		String name = input.next(); //사용자가 입력한 값을 name에 할당
		for(int i = 0; i<stocks.size(); i++) { //name배열에 입력된 크기만큼 for반복문 실행하게 loop설계
			StockInput stock = stocks.get(i); //stocks저장공간에 있는 인덱스 값을 stock에 할당
			if(stock.getStocksName().equals(name)) { //만약 입력값과 현재 저장되어있는 주식종목 명이 값을 경우 문자열이므로 equals() method를 활용 
				int num = -1; // 사용자가 메뉴 입력할 변수 선언과 초기화
				while (num != 5) { //edit 매뉴 설정
					showEditMenu(); //showEditMenu method를 통해 사용자에게 수정섹션 메뉴 노출
					num = input.nextInt(); //사용자에게 입력받은 값을 num에 할당
					
					switch(num) { //switch문을 활용해 사용자 선택 용이
						case 1: 
							stock.setStockName(input); //setStockName()을 통해 주식이름 수정
							break;//종료
						case 2: 
							stock.setStockPrice(input); //setStockPrice()을 통해 주식매수가 수정
							break;//종료
						case 3: 
							stock.setStockGoal(input); //setStockGoal()을 통해 주식목표가 수정
							break;//종료
						case 4: 
							stock.setStockMemo(input); //setStockMemo()을 통해 주식메모 수정
							break;//종료
						default: 
							continue; //loop문 탈출
						} //swtich
			    }break; //while //종료
			}//if
		}//for
	}
	
	public void viewStocks() { //관심종목에 저장된 종목들을 보여주는 함수 생성
		System.out.println("*****현재 사용자가 관심있어하는 종목입니다*****"); //사용자에게 저장된 종목들을 시각적으로 보여주는 안내문 출력
		System.out.println("사용자께서 저장된 종목 개수는 " + stocks.size()+" 개입니다.");
	    for(int i=0; i<stocks.size(); i++) { //for반복문을 통해 name배열 크기만큼 반복되게 loop설계
	        stocks.get(i).printInfo();//사용자에게 주식 정보를 출력
	    }
	    if(stocks.size()==0) { //만약 배열안에 아무것도 없다면?
	        System.out.println("목록이 없습니다."); //사용자에게 배열안에 저장된 종목이 없다고 안내문 출력
	        System.out.println("관심종목에 추가해주세요."); //사용자에게 관심종목 추가해달라고 안내문 출력
	    }
	    System.out.println("************************************"); 

	}
	
	
	public void showEditMenu() { //showEditMenu method 생성
		System.out.println("### Stocks Info Edit Menu ###");
		System.out.println("1. Edit StocksName");
		System.out.println("2. Edit Price Stocks");
		System.out.println("3. Edit Goal Price");
		System.out.println("4. Edit Memo");
		System.out.println("5. Exit");
		System.out.print("Select one number between 1 - 5:");
	}
	
	public int size() {
		return stocks.size();
	}
	
	public StockInput get(int index) {
		return (Stock) stocks.get(index);
	}
	
}
