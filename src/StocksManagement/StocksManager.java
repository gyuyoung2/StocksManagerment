package StocksManagement;

import java.util.ArrayList;
import java.util.Scanner;

import stock.KoreaStock;
import stock.Stock;	

public class StocksManager { 
	ArrayList<Stock> stocks = new ArrayList<Stock>(); //ArrayList를 활용하기 위해 stocks 객체 생성
	Scanner input; //input 생성자 선언
	StocksManager(Scanner input){ //생성자 인자값에 Scanner input을 넣으므로써 
		this.input = input; //사용자가 입력하는 값 저장을 도와주는 input 생성
	}
	
	
	public void addStocks(){ //주식'종목 정보'추가하는 함수 생성
		int kind = 0; //사용자가 메뉴 입력할 변수 선언과 초기화
		Stock stock; //Stock 클래스 생성자 생성
		while(kind != 1 && kind != 2) { //사용자가 1,2 이외에 숫자를 입력할때까지 반복
			System.out.print("1. 국내주식"); //국내주식 종목 추가 안내
			System.out.println(" 2. 해외주식"); //해외주식 종목 추가 안내
			System.out.print("주식종류를 선택해주세요 between 1 - 2: "); //사용자에게 종목종류를 입력받을려고 안내문 출력
			kind = input.nextInt(); //사용자가 입력한 값을 kind변수에 할당
			if (kind == 1) { //사용자가 국내주식을 선택
				stock = new KoreaStock(); // 생성자 생성
				stock.getUserInput(input); //Stock 클래스의 getUserInput() method 실행
				stocks.add(stock); //자료형ArrayList Stocks 클래스의 안 속성들에 값 add함수로 할당 
				break;// 종료
			}
			else if (kind == 2) { //사용자가 해외주식을 선택
				stock = new Stock(); //생성자 생성
				stock.getUserInput(input); //Stock 클래스의 getUserInput() method 실행
				stocks.add(stock); //자료형ArrayList Stocks 클래스의 안 속성들에 값 add함수로 할당  
				break; //종료
			}
			else {
				System.out.print("주식종류를 선택해주세요: "); //사용자에게 올바른 값을 입력할때까지 출력
			}
		}
	}
	
	public void deleteStocks(){ //주식'종목 정보'삭제하는 함수 생성
		System.out.println("어떤 종목을 삭제하시겠습니까?"); // 사용자에게 삭제 할 종목 입력 안내문 출력
		String name = input.next(); //삭제할 종목명 입력값을 name에 할당
		int index = -1; //array가 index를 못찾는것을 예상 하기 위해 index에 -1 할당
		for(int i = 0; i<stocks.size(); i++) { //name배열에 입력된 크기만큼 for반복문 실행하게 loop설계
			if(stocks.get(i).getStocksName().equals(name)) { //입력한 종목이 내가 저장한 종목가 같으면 index값 할당
				index = i; //index값 할당
				break; //종료
			}
		}
			
		if(index >= 0) { //index값이 0이상
				stocks.remove(index); //배열 index값 정보 삭제
				System.out.println("입력된 종목 " + name + "이(가) 삭제되었습니다."); //사용자가 입력한 종목 삭제 안내문 출력
			} 
		else { //index값이 음수일경우
				System.out.println("입력된 종목은 정보가 없습니다."); //사용자에게 입력한 정보 없음 안내문 출력
				return;
			}
		
	}
	
	
	public void editStocks() { //주식'종목 정보' 수정하는 함수 생성
		System.out.print("종목 이름: "); //사용자에게 수정할 주식 종목 입력 안내문 출력
		String name = input.next(); //사용자가 입력한 값을 name에 할당
		for(int i = 0; i<stocks.size(); i++) { //name배열에 입력된 크기만큼 for반복문 실행하게 loop설계
			Stock stock = stocks.get(i); //stocks저장공간에 있는 인덱스 값을 stock에 할당
			if(stock.getStocksName().equals(name)) { //만약 입력값과 현재 저장되어있는 주식종목 명이 값을 경우 문자열이므로 equals() method를 활용 
				int num = -1; // 사용자가 메뉴 입력할 변수 선언과 초기화
				while (num != 5) { //edit 매뉴 설정
					System.out.println("### Stocks Info Edit Menu ###");
					System.out.println("1. Edit StocksName");
					System.out.println("2. Edit Price Stocks");
					System.out.println("3. Edit Goal Price");
					System.out.println("4. Edit Memo");
					System.out.println("5. Exit");
					System.out.print("Select one number between 1 - 5:");
					num = input.nextInt(); //사용자에게 입력받은 값을 num에 할당
					
				switch(num) { //switch문을 활용해 사용자 선택 용이
					case 1: System.out.print("종목 이름: "); //사용자에게 종목이름을 입력 안내문 출력
							String StocksName = input.next(); //입력한 종목이름을 StocksName에 할당
							stock.setStocksName(StocksName); //그 입려된값을 Stock클래스에 있는 StocksName에 할당
							break;//종료
					case 2: System.out.print("종목 매수가: "); //사용자에게 종목 매수가를 입력 안내문 출력
							int buyStock = input.nextInt(); //입력한 매수가를 buyStock에 할당
							stock.setBuyStock(buyStock); //그 입력된값을 Stock클래스에 있는 buyStock에 할당
							break;//종료
					case 3: System.out.print("종목 목표가: "); //사용자에게 종목 목표가를 입력 안내문 출력
							int goalPrice = input.nextInt(); //입력한 목표가를 goalPrice에 할당
							stock.setGoalPrice(goalPrice); //그 입력된값을 Stock클래스에 있는 goalPrice에 할당
							break;//종료
					case 4: System.out.print("종목 메모: "); //사용자에게 종목 메모를 입력 안내문 출력
							String memo = input.next(); //입력한 목표가를 memo에 할당
							stock.setmemo(memo); //그 입력된 값을 Stock클래스에 있는 memo에 할당
							break;//종료
					case 5: continue; //loop문 탈출
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
	
	
	
}
