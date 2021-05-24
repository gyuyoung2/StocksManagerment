package stock;

import java.util.Scanner;

public class OverseaStock extends WorldStock { //OverseaStock 클래스가 WorldStock클래스에 상속
	
	
	public OverseaStock(StockKind kind) { //OverseaStock 생성
		super(kind);
	}

	public void getUserInput(Scanner input) {
		setStockName(input); //setStockName method를 통해 사용자에게 주식 종목명을 입력받음
		
		setStockPrice(input); //setStockPrice method를 통해 사용자에게 주식 매수가를 입력받음
		
		setStockGoal(input); //setStockGoal method를 통해 사용자에게 주식 목표가를 입력받음
		
		setStockMemowithYN(input); //setStockMemowithYN method를 통해 사용자에게 메모를 여부와 메모를 입력받음
		
		setStockDollarwithYN(input); //setStockDollarwithYN method를 통해 사용자에게 환율 여부와 환율정보를 입력받음
	}
	
	
	public void printInfo() { //주식정보를 출력해주는 printInfo() method.
		String skind = getKindString(); //getKindString method를 통해 주식종류를 가져옴.
		System.out.println("주식 종류: "+ skind +"종목명: "+ StocksName + " 매수가: "+buyStock+"원 목표가: "+goalPrice+"원 메모: "+ memo + "/매수($): " + Dollar + "달러");//주식정보 출력
	}
	
	public String getKindString() { //주식종류의 문자열을 가져오는 getKindString() method
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
		return skind;
	}
}
