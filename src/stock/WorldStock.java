package stock;

import java.util.Scanner;

public abstract class WorldStock extends Stock { //WorldStock클래스는 Stock클래스에 상속

	public WorldStock(StockKind kind) { //OverseaStock 생성
		super(kind);
	}
	
	@Override
	public abstract void getUserInput(Scanner input);

	@Override
	public abstract void printInfo();

	public void setStockMemowithYN(Scanner input) { //setStockMemowithYN method 생성
		char answer = 'x'; //사용자에게 입력받을 값을 저장할 변수 선언과 초기화
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //사용자가 올바른 입력할때까지 반복
		{
			System.out.print("메모를 하실껀가요? (Y/N)"); //사용자가 이 종목의 메모를 받기위해 안내문 출력
			answer = input.next().charAt(0); //사용자에게 문자열 입력받은 값을 answer에 저장
			if(answer =='y' || answer == 'Y' ) { //y의 소문자 대문자 둘중 하나면
				setStockMemo(input); //setStockMemo method를 통해 사용자에게 메모를 입력받음				
				break; //종료
			}
			else if(answer=='n' || answer == 'N') { //n의 소문자 대문자 둘중 하나면
				this.setmemo(""); //공백 할당
				break; //종료
			}
			else {
			}
		}
	}
	
	public void setStockDollarwithYN(Scanner input) { //setStockDollarwithYN method 생성
		char answer = 'x'; //사용자에게 입력받을 값을 저장할 변수 선언과 초기화
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //사용자가 올바른 입력할때까지 반복
		{
			System.out.print("달러로 계산하시겠습니까? (Y/N)"); //사용자가 이 종목의 환율 계산하기 위해 안내문 출력
			answer = input.next().charAt(0); //사용자에게 문자열 입력받은 값을 answer에 저장
			if(answer =='y' || answer == 'Y' ) { //y의 소문자 대문자 둘중 하나면
				Dollar = setStockDollar(input); //setStockDollar method를 통해 사용자에게 달러 환전을 해줌
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
}
