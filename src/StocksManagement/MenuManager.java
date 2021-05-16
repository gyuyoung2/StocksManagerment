package StocksManagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManager {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //사용자에게 입력받기위해 Scanner클래스 생성.
		StocksManager stocksManager = new StocksManager(input); //각각 매뉴의 기능 method를 활용하기 위해StocksManager 클래스 생성
		
		selectMenu(input, stocksManager); //selectMenu method를 활용하여 사용자에게 메뉴노출과 선택기능 추가
		
	}
	
	public static void selectMenu(Scanner input, StocksManager stocksManager) { //selectMenu method 생성
		int num= -1;// 사용자가 메뉴 입력할 변수 선언과 초기화
		while (num != 5) { //매뉴 설정
			try {
			showMenu();//showMenu method를 통해 메뉴 출력
			
			num = input.nextInt(); //사용자가 입력한 값을 정수형으로 변수에 저장
			switch(num) { //switch구문을 통해 사용자가 사용하고자 하는 메뉴로 이동
			case 1:
				stocksManager.addStocks();//주식 종목 등록하는 함수 실행
				break;
			case 2:
				stocksManager.deleteStocks(); //주식 종목 삭제하는 함수 실행
				break;
			case 3:
				stocksManager.editStocks(); //관심종목에 담긴 종목들을 수정하는 함수 실행
				break;
			case 4:
				stocksManager.viewStocks(); //관심종목을 볼수있는 함수 실행
				break;
			default:
				continue;//프로그램 종료
				}
			}
			catch(InputMismatchException e) { //try/catch문을 사용해 예외처리
				System.out.println("Please put an integer between 1 and 4!");
				if(input.hasNext()) {
					input.next();
				}
				num = -1;
			}
		}
	}
	
	public static void showMenu() { //addMenu method 생성
		System.out.println("### Stocks Management System Menu ###");
		System.out.println("1. Add Stocks");
		System.out.println("2. Delete Stocks");
		System.out.println("3. Edit Stocks");
		System.out.println("4. View Stocks");
		System.out.println("5. Exit");
		System.out.print("Select one number between 1 - 5:");
	}
}



		
		
