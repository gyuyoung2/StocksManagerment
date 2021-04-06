package StocksManagement;

import java.util.ArrayList;
import java.util.Scanner;	

public class StocksManager {
	
	public static ArrayList<String> addStocks(){ //자료형 ArrayList<String>으로 반환값 지정 후 주식'종목'추가하는 함수 생성
		Stocks stocks = new Stocks(); //여러 저장 정보를 받기 위해 Stocks 클래스 생성
		ArrayList<String> addname = new ArrayList<String>();//리턴값을 얻기 위해 함수안에 ArrayList 'addname' 생성
		Scanner input = new Scanner(System.in); //사용자에게 입력받기위해 Scanner클래스 생성
		System.out.print("Stocks Id:"); //사용자에게 ID를 입력받기 위해 안내문 출력
		stocks.StocksId = input.nextInt(); //input값을 정수로 받아서 StocksId변수에 저장
		System.out.println("How many add StocksName?"); //사용자에게 몇개의 주식 종목을 추가할지 알려주기
		stocks.StocksNum = input.nextInt(); //input값을 정수로 받아서 Stocks 클래스의 Stocksnum변수에 저장
		for (int i = 0; i <stocks.StocksNum; i++) { //사용자가 입력한 종목 갯수만큼 for반복문을 통해 loop실행
			System.out.print("관심종목을 입력해주세요."); //사용자에게 종목을 입력받을려고 안내문 출력
			stocks.name = input.next(); //사용자가 띄어쓰기 포함한 입력값을 name변수에 저장
			addname.add(stocks.name); //ArrayList addname에 add메소드를 사용하여 주식'종목'추가
		}
		return addname; //ArrayList addname 리턴값으로 반환
	}
	
	public static void deleteStocks(ArrayList<String> name){
		Stocks stocks = new Stocks(); //여러 저장 정보를 받기 위해 Stocks 클래스 생성
		Scanner input = new Scanner(System.in); //사용자에게 입력받기위해 Scanner클래스 생성
		System.out.println("어떤 종목을 삭제하시겠습니까?"); // 저장되어 있는 모든 이름을 String으로 변환하여 출력
		for(int i=0; i<name.size(); i++) { //name배열에 입력된 크기만큼 for반복문 실행하게 loop설계
	    stocks.StocksName = (String)name.get(i); //name배열에 입력된 값에 INDEX순차적으로 get method를 사용해 변수에 저장
	    System.out.println(stocks.StocksName); //변수에 저장된 값을 사용자에게 출력
	} //사용자에게 기존에 저장된값을 나열하여 보여주므로써 삭제를 하기에 시각적으로 유용함
		System.out.println("삭제할 종목을 입력하세요"); //사용자에게 '삭제안내'문구 출력
		stocks.StocksName = input.next(); // 입력받은 이름을 ArrayList name에서 삭제
		name.remove(stocks.StocksName); //remove method를 사용해 사용자가 입력한 값을 삭제
		System.out.println("정상적으로 삭제완료 되었습니다."); //사용자에게 삭제를 정상적으로 이루어졌다는 것을 안내
	}
	
	public static void viewStocks(ArrayList<String> name) { //관심종목에 저장된 종목들을 보여주는 함수 생성
		System.out.println("*****현재 사용자가 관심있어하는 종목입니다*****"); //사용자에게 저장된 종목들을 시각적으로 보여주는 안내문 출력
	    for(int i=0; i<name.size(); i++) { //for반복문을 통해 name배열 크기만큼 반복되게 loop설계
	        System.out.println("회사명 : " + name.get(i)); //name배열 반복문안이므로 INDEX번호대로 순차적으로 출력
	    }
	    if(name.size()==0) { //만약 배열안에 아무것도 없다면?
	        System.out.println("목록이 없습니다."); //사용자에게 배열안에 저장된 종목이 없다고 안내문 출력
	        System.out.println("관심종목에 추가해주세요."); //사용자에게 관심종목 추가해달라고 안내문 출력
	    }
	    System.out.println("************************************"); 

	}
	
	public static void removeStocks(ArrayList<String> name) { //관심종목 목록 전체를 초기화 하는 함수 생성
		Stocks stocks = new Stocks();
		Scanner input = new Scanner(System.in); //사용자에게 입력을 받기 위해 Scanner 클래스 생성
		System.out.println("*****정말 전체 종목을 지우시겠습니까?*****"); //사용자에게 정말로 목록전체를 초기화 하는지 안내문 출력
		System.out.println("1.예 2.아니오"); //사용자가 실수하지 않게 한번더 초기화 여부 안내문 출력
		stocks.RemoveNum= input.nextInt(); //사용자가 입력한 값을 정수로 받아 stocks클래스의 removenum변수에 저장
		if(stocks.RemoveNum==1) { // 사용자가 입력한 값에 따라 초기화구문 실행 판별
		name.clear(); //clear method을 실행하여 전체 배열값을 삭제
		System.out.println("관심종목이 완전히 초기화 되었습니다."); //사용자에게 초기화 되었다고 안내문 출력
		}
		else { //사용자가 초기화를 안할경우
			System.out.println("매뉴로 돌아갑니다."); //다시돌아가는 안내문구 출력
		}
	}
	
}
