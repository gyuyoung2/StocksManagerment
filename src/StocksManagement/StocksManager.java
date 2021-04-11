package StocksManagement;

import java.util.ArrayList;
import java.util.Scanner;

import stock.KoreaStock;
import stock.Stock;	

public class StocksManager { 
	ArrayList<Stock> stocks = new ArrayList<Stock>(); //ArrayList�� Ȱ���ϱ� ���� stocks ��ü ����
	Scanner input; //input ������ ����
	StocksManager(Scanner input){ //������ ���ڰ��� Scanner input�� �����Ƿν� 
		this.input = input; //����ڰ� �Է��ϴ� �� ������ �����ִ� input ����
	}
	
	
	public void addStocks(){ //�ֽ�'���� ����'�߰��ϴ� �Լ� ����
		int kind = 0; //����ڰ� �޴� �Է��� ���� ����� �ʱ�ȭ
		Stock stock; //Stock Ŭ���� ������ ����
		while(kind != 1 && kind != 2) { //����ڰ� 1,2 �̿ܿ� ���ڸ� �Է��Ҷ����� �ݺ�
			System.out.print("1. �����ֽ�"); //�����ֽ� ���� �߰� �ȳ�
			System.out.println(" 2. �ؿ��ֽ�"); //�ؿ��ֽ� ���� �߰� �ȳ�
			System.out.print("�ֽ������� �������ּ��� between 1 - 2: "); //����ڿ��� ���������� �Է¹������� �ȳ��� ���
			kind = input.nextInt(); //����ڰ� �Է��� ���� kind������ �Ҵ�
			if (kind == 1) { //����ڰ� �����ֽ��� ����
				stock = new KoreaStock(); // ������ ����
				stock.getUserInput(input); //Stock Ŭ������ getUserInput() method ����
				stocks.add(stock); //�ڷ���ArrayList Stocks Ŭ������ �� �Ӽ��鿡 �� add�Լ��� �Ҵ� 
				break;// ����
			}
			else if (kind == 2) { //����ڰ� �ؿ��ֽ��� ����
				stock = new Stock(); //������ ����
				stock.getUserInput(input); //Stock Ŭ������ getUserInput() method ����
				stocks.add(stock); //�ڷ���ArrayList Stocks Ŭ������ �� �Ӽ��鿡 �� add�Լ��� �Ҵ�  
				break; //����
			}
			else {
				System.out.print("�ֽ������� �������ּ���: "); //����ڿ��� �ùٸ� ���� �Է��Ҷ����� ���
			}
		}
	}
	
	public void deleteStocks(){ //�ֽ�'���� ����'�����ϴ� �Լ� ����
		System.out.println("� ������ �����Ͻðڽ��ϱ�?"); // ����ڿ��� ���� �� ���� �Է� �ȳ��� ���
		String name = input.next(); //������ ����� �Է°��� name�� �Ҵ�
		int index = -1; //array�� index�� ��ã�°��� ���� �ϱ� ���� index�� -1 �Ҵ�
		for(int i = 0; i<stocks.size(); i++) { //name�迭�� �Էµ� ũ�⸸ŭ for�ݺ��� �����ϰ� loop����
			if(stocks.get(i).getStocksName().equals(name)) { //�Է��� ������ ���� ������ ���� ������ index�� �Ҵ�
				index = i; //index�� �Ҵ�
				break; //����
			}
		}
			
		if(index >= 0) { //index���� 0�̻�
				stocks.remove(index); //�迭 index�� ���� ����
				System.out.println("�Էµ� ���� " + name + "��(��) �����Ǿ����ϴ�."); //����ڰ� �Է��� ���� ���� �ȳ��� ���
			} 
		else { //index���� �����ϰ��
				System.out.println("�Էµ� ������ ������ �����ϴ�."); //����ڿ��� �Է��� ���� ���� �ȳ��� ���
				return;
			}
		
	}
	
	
	public void editStocks() { //�ֽ�'���� ����' �����ϴ� �Լ� ����
		System.out.print("���� �̸�: "); //����ڿ��� ������ �ֽ� ���� �Է� �ȳ��� ���
		String name = input.next(); //����ڰ� �Է��� ���� name�� �Ҵ�
		for(int i = 0; i<stocks.size(); i++) { //name�迭�� �Էµ� ũ�⸸ŭ for�ݺ��� �����ϰ� loop����
			Stock stock = stocks.get(i); //stocks��������� �ִ� �ε��� ���� stock�� �Ҵ�
			if(stock.getStocksName().equals(name)) { //���� �Է°��� ���� ����Ǿ��ִ� �ֽ����� ���� ���� ��� ���ڿ��̹Ƿ� equals() method�� Ȱ�� 
				int num = -1; // ����ڰ� �޴� �Է��� ���� ����� �ʱ�ȭ
				while (num != 5) { //edit �Ŵ� ����
					System.out.println("### Stocks Info Edit Menu ###");
					System.out.println("1. Edit StocksName");
					System.out.println("2. Edit Price Stocks");
					System.out.println("3. Edit Goal Price");
					System.out.println("4. Edit Memo");
					System.out.println("5. Exit");
					System.out.print("Select one number between 1 - 5:");
					num = input.nextInt(); //����ڿ��� �Է¹��� ���� num�� �Ҵ�
					
				switch(num) { //switch���� Ȱ���� ����� ���� ����
					case 1: System.out.print("���� �̸�: "); //����ڿ��� �����̸��� �Է� �ȳ��� ���
							String StocksName = input.next(); //�Է��� �����̸��� StocksName�� �Ҵ�
							stock.setStocksName(StocksName); //�� �Է��Ȱ��� StockŬ������ �ִ� StocksName�� �Ҵ�
							break;//����
					case 2: System.out.print("���� �ż���: "); //����ڿ��� ���� �ż����� �Է� �ȳ��� ���
							int buyStock = input.nextInt(); //�Է��� �ż����� buyStock�� �Ҵ�
							stock.setBuyStock(buyStock); //�� �ԷµȰ��� StockŬ������ �ִ� buyStock�� �Ҵ�
							break;//����
					case 3: System.out.print("���� ��ǥ��: "); //����ڿ��� ���� ��ǥ���� �Է� �ȳ��� ���
							int goalPrice = input.nextInt(); //�Է��� ��ǥ���� goalPrice�� �Ҵ�
							stock.setGoalPrice(goalPrice); //�� �ԷµȰ��� StockŬ������ �ִ� goalPrice�� �Ҵ�
							break;//����
					case 4: System.out.print("���� �޸�: "); //����ڿ��� ���� �޸� �Է� �ȳ��� ���
							String memo = input.next(); //�Է��� ��ǥ���� memo�� �Ҵ�
							stock.setmemo(memo); //�� �Էµ� ���� StockŬ������ �ִ� memo�� �Ҵ�
							break;//����
					case 5: continue; //loop�� Ż��
					} //swtich
			    }break; //while //����
			}//if
		}//for
	}
	
	public void viewStocks() { //�������� ����� ������� �����ִ� �Լ� ����
		System.out.println("*****���� ����ڰ� �����־��ϴ� �����Դϴ�*****"); //����ڿ��� ����� ������� �ð������� �����ִ� �ȳ��� ���
		System.out.println("����ڲ��� ����� ���� ������ " + stocks.size()+" ���Դϴ�.");
	    for(int i=0; i<stocks.size(); i++) { //for�ݺ����� ���� name�迭 ũ�⸸ŭ �ݺ��ǰ� loop����
	        stocks.get(i).printInfo();//����ڿ��� �ֽ� ������ ���
	    }
	    if(stocks.size()==0) { //���� �迭�ȿ� �ƹ��͵� ���ٸ�?
	        System.out.println("����� �����ϴ�."); //����ڿ��� �迭�ȿ� ����� ������ ���ٰ� �ȳ��� ���
	        System.out.println("�������� �߰����ּ���."); //����ڿ��� �������� �߰��ش޶�� �ȳ��� ���
	    }
	    System.out.println("************************************"); 

	}
	
	
	
}
