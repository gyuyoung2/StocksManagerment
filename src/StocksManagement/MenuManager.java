package StocksManagement;

import java.util.Scanner;

public class MenuManager {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //����ڿ��� �Է¹ޱ����� ScannerŬ���� ����
		StocksManager stocksManager = new StocksManager(input); //���� �Ŵ��� ��� method�� Ȱ���ϱ� ����StocksManager Ŭ���� ����
				
		int num= -1;// ����ڰ� �޴� �Է��� ���� ����� �ʱ�ȭ
		while (num != 5) { //�Ŵ� ����
			System.out.println("### Stocks Management System Menu ###");
			System.out.println("1. Add Stocks");
			System.out.println("2. Delete Stocks");
			System.out.println("3. Edit Stocks");
			System.out.println("4. View Stocks");
			System.out.println("5. Exit");
			System.out.print("Select one number between 1 - 5:");
			num = input.nextInt(); //����ڰ� �Է��� ���� ���������� ������ ����
			
			if (num == 1 ) { //switch������ ���� ����ڰ� ����ϰ��� �ϴ� �޴��� �̵�
				stocksManager.addStocks();//�ֽ� ���� ����ϴ� �Լ� ����
			}
			else if (num == 2) {
				stocksManager.deleteStocks(); //�ֽ� ���� �����ϴ� �Լ� ����
			}
			else if (num == 3) {
				stocksManager.editStocks(); //�������� ��� ������� �����ϴ� �Լ� ����
			}
			else if (num == 4){
				stocksManager.viewStocks(); //���������� �����ִ� �Լ� ����
			}
			else if (num == 5) { 
				break;//���α׷� ����
			}
		}
	}
	
}


		
		