package StocksManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager {
	
	public static void main(String[] args) {
		int num= 0;// ����ڰ� �޴� �Է��� ���� ����� �ʱ�ȭ 
		Stocks stocks = new Stocks();
		Scanner input = new Scanner(System.in); //����ڿ��� �Է¹ޱ����� ScannerŬ���� ����
		ArrayList<String> name = new ArrayList<String>(); //�ֽ��̸� ������ ArrayList name ����
		ArrayList<String> price = new ArrayList<String>(); //�ֽİ��� ������ ArrayList price ����
		String StocksName=null , StocksPrice = null; //�ֽ��̸�, �ֽİ��� �Է¹��� ���� ����
		
		while (num != 5) { //�Ŵ� ����
			System.out.println("### Stocks Management System Menu ###");
			System.out.println("1. Add Stocks");
			System.out.println("2. Delete Stocks");
			System.out.println("3. View Stocks");
			System.out.println("4. All remove Stocks");
			System.out.println("5. Exit");
			System.out.print("Select one number between 1 - 5:");
			num = input.nextInt(); //����ڰ� �Է��� ���� ���������� ������ ����
			
		switch(num) { //switch������ ���� ����ڰ� ����ϰ��� �ϴ� �޴��� �̵�
		
		case 1:
			name = StocksManager.addStocks(); //�ֽ� ���� �߰��ϴ� �Լ� ���ϰ��� name�迭�� ����
			System.out.println("�������� ����� ������"+name+"�Դϴ�."); //����ڿ��� ����� ������� �˷��ִ� �ȳ��� ���
			break;
		case 2:
			StocksManager.deleteStocks(name); //�ֽ� ���� �����ϴ� �Լ� ����
			break;
		case 3:
			StocksManager.viewStocks(name); //�������� ��� ������� ����� �����ִ� �Լ� ����
	        break;
	        
		case 4:
			StocksManager.removeStocks(name); //����������ü�� �����ϴ� �Լ� ����
			break;
		}

	}
	}
}


		
		