package StocksManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import GUI.WindowFrame;
import log.EventLogger;
public class MenuManager {
	static EventLogger logger = new EventLogger("log.txt"); //log를 기록하는 생성자 생성
	
	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in); //사용자에게 입력받기위해 Scanner클래스 생성
		StocksManager stocksManager = getObject("stockmanager.ser"); //직렬화 처리.(객체를 파일에 쓴다)
		if(stocksManager == null) { //stocksManager가 비어있으면
			stocksManager = new StocksManager(input);
		} //각각 매뉴의 기능 method를 활용하기 위해StocksManager 클래스 생성
		
		
		WindowFrame frame = new WindowFrame(stocksManager); //WindowFrame 객체 생성
		selectMenu(input, stocksManager); //selectMenu method를 활용하여 사용자에게 메뉴노출과 선택기능 추가
		putObject(stocksManager, "stockmanager.ser"); //stockmanager.ser 객체 저장
		
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
				logger.log("add a Stock"); //로그 실행
				break;
			case 2:
				stocksManager.deleteStocks(); //주식 종목 삭제하는 함수 실행
				logger.log("delete a Stock"); //로그 실행
				break;
			case 3:
				stocksManager.editStocks(); //관심종목에 담긴 종목들을 수정하는 함수 실행
				logger.log("edit a Stock"); //로그 실행
				break;
			case 4:
				stocksManager.viewStocks(); //관심종목을 볼수있는 함수 실행
				logger.log("view a Stocks"); //로그 실행
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
	
	public static StocksManager getObject(String fileName) { //getObject method 생성
		StocksManager stocksManager = null; //stocksManager 초기화
		
		
		try { //try/catch문 실행
			FileInputStream file = new FileInputStream(fileName); //FileInputStream 클래스 생성자 생성
			ObjectInputStream in = new ObjectInputStream(file); //ObjectInputStream 클래스 생성자 생성
			
			stocksManager = (StocksManager) in.readObject(); //readObject method를 이용해 파일을 읽어옴
			
			in.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			return stocksManager; //stocksManger를 반환함
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManger를 반환함
		
	}
	
	public static StocksManager putObject(StocksManager stocksManager ,String fileName) { //putObject method 생성
		try {
			FileOutputStream file = new FileOutputStream(fileName); //FileOutputStream 클래스 생성자 생성
			ObjectOutputStream out = new ObjectOutputStream(file); //ObjectOutputStream 클래스 생성자 생성
			
			out.writeObject(stocksManager); //writeObject method를 통해 파일을 객체에 전달.
			
			out.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManager를 반환
		
	}
}



		
		