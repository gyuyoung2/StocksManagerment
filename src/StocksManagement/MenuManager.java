package StocksManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {
	
	public static void main(String[] args) {
		int num= 0;// 사용자가 메뉴 입력할 변수 선언과 초기화 
		Stocks stocks = new Stocks();
		Scanner input = new Scanner(System.in); //사용자에게 입력받기위해 Scanner클래스 생성
		ArrayList<String> name = new ArrayList<String>(); //주식이름 저장할 ArrayList name 생성
		ArrayList<String> price = new ArrayList<String>(); //주식가격 저장할 ArrayList price 생성
		String StocksName=null , StocksPrice = null; //주식이름, 주식가격 입력받을 변수 선언
		
		while (num != 5) { //매뉴 설정
			System.out.println("### Stocks Management System Menu ###");
			System.out.println("1. Add Stocks");
			System.out.println("2. Delete Stocks");
			System.out.println("3. View Stocks");
			System.out.println("4. All remove Stocks");
			System.out.println("5. Exit");
			System.out.print("Select one number between 1 - 5:");
			num = input.nextInt(); //사용자가 입력한 값을 정수형으로 변수에 저장
			
		switch(num) { //switch구문을 통해 사용자가 사용하고자 하는 메뉴로 이동
		
		case 1:
			name = StocksManager.addStocks(); //주식 종목 추가하는 함수 리턴값을 name배열에 저장
			System.out.println("관심종목에 저장된 종목은"+name+"입니다."); //사용자에게 저장된 종목들을 알려주는 안내문 출력
			break;
		case 2:
			StocksManager.deleteStocks(name); //주식 종목 삭제하는 함수 실행
			break;
		case 3:
			StocksManager.viewStocks(name); //관심종목에 담긴 종목들의 목록을 보여주는 함수 실행
	        break;
	        
		case 4:
			StocksManager.removeStocks(name); //관심종목전체를 삭제하는 함수 실행
			break;
		}

	}
	}
}


		
		