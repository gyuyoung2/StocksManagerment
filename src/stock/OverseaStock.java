package stock;

import java.util.Scanner;

public class OverseaStock extends Stock {
	
	protected int Dollar = 1170; //달러 변수에 현재 달러 저장
	
	public OverseaStock(StockKind kind) { //OverseaStock 생성
		super(kind);
	}

	public void getUserInput(Scanner input) {
		System.out.print("주식 종목 명을 입력해주세요: "); //사용자에게 주식 종목명을 입력 안내문 출력
		String StocksName = input.next(); //사용자에게 종목 값을 받아 Stocks클래스의 StocksName에 저장
		this.setStocksName(StocksName); //입력받은 값을 setStocksName method의 인자값으로 들어가 종목명이 저장됨
		
		System.out.print("이 종목의 매수가를 입력해주세요 :"); //사용자에게 종목의 매수가를 받기위해 안내문 출력
		int buyStock = input.nextInt(); //사용자에게 매수가 값을 받아 Stocks클래스의 buyStock에 저장
		this.setBuyStock(buyStock); //입력받은 값을 setBuyStock method의 인자값으로 들어가 매수가 값이 저장됨
		
		System.out.print("이 종목의 목표가를 입력해주세요 :"); //사용자에게 목표가를 받기위해 안내문 출력
		int goalPrice = input.nextInt(); //사용자에게 목표가 값을 받아 Stocks클래스의 goalPrice에 저장
		this.setGoalPrice(goalPrice); //입력받은 값을 setGoalPrice method의 인자값으로 들어가 목표가 값이 저장됨
		
		char answer = 'x'; //사용자에게 입력받을 값을 저장할 변수 선언과 초기화
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //사용자가 올바른 입력할때까지 반복
		{
			System.out.print("메모를 하실껀가요? (Y/N)"); //사용자가 이 종목의 메모를 받기위해 안내문 출력
			answer = input.next().charAt(0); //사용자에게 문자열 입력받은 값을 answer에 저장
			if(answer =='y' || answer == 'Y' ) { //y의 소문자 대문자 둘중 하나면
				System.out.print("memo"); //memo 보기 출력
				String memo = input.next(); //사용자에게 메모의 내용을 받아 Stocks클래스의 memo에 저장
				this.setmemo(memo);  //입력받은 값을 setmemo method의 인자값으로 들어가 종목메모 값이 저장됨
				break; //종료
			}
			else if(answer=='n' || answer == 'N') { //n의 소문자 대문자 둘중 하나면
				this.setmemo(""); //공백 할당
				break; //종료
			}
			else {
			}
		}
		
		answer = 'x'; //사용자에게 입력받을 값을 저장할 변수 선언과 초기화
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //사용자가 올바른 입력할때까지 반복
		{
			System.out.print("달러로 계산하시겠습니까? (Y/N)"); //사용자가 이 종목의 환율 계산하기 위해 안내문 출력
			answer = input.next().charAt(0); //사용자에게 문자열 입력받은 값을 answer에 저장
			if(answer =='y' || answer == 'Y' ) { //y의 소문자 대문자 둘중 하나면
				System.out.print("Exchange rate of Dollar:"); //환율 보기 출력
				Dollar = getBuyStock() / Dollar; // 환율계산
				this.setDollar(Dollar);  //입력받은 값을 setDollar method의 인자값으로 들어가 환율값이 저장됨
				System.out.println(Dollar + "달러");
				break; //종료
			}
			else if(answer=='n' || answer == 'N') { //n의 소문자 대문자 둘중 하나면
				this.setDollar(0); //공백 할당
				break; //종료
			}
			else {
			}
		}
	}
	
	public void printInfo() { //주식정보를 출력해주는 printInfo() method
		String skind = "none";
		switch(this.kind) { //주식 종류 판별
		case Korea:
			skind = "국내주식";
			break;
		case Oversea:
			skind = "해외주식";
			break;
		default:
		}
		System.out.println("주식 종류: "+ skind +"종목명: "+ StocksName + " 매수가: "+buyStock+"원 목표가: "+goalPrice+"원 메모: "+ memo + "/ 환전: " + Dollar + "달러");//주식정보 출력
	}
}
