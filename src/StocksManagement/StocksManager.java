package StocksManagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import stock.KoreaStock;
import stock.OverseaStock;
import stock.Stock;
import stock.StockInput;
import stock.StockKind;	

public class StocksManager implements Serializable { //Serializable ����
	/**
	 * 
	 */
	private static final long serialVersionUID = 8934422693209771066L;
	
	ArrayList<StockInput> stocks = new ArrayList<StockInput>(); //ArrayList�� Ȱ���ϱ� ���� stocks ��ü ����
	transient Scanner input; //input ������ ����
	StocksManager(Scanner input){ //������ ���ڰ��� Scanner input�� �����Ƿν� 
		this.input = input; //����ڰ� �Է��ϴ� �� ������ �����ִ� input ����
	}
	
	public void addStocks(String Name, String Price, String Goal, String Memo) {
		StockInput stockInput = new KoreaStock(StockKind.Korea); // ������ ����
		stockInput.getUserInput(input); //Stock Ŭ������ getUserInput() method ����
		stocks.add(stockInput);
	}
	
	public void addStocks(StockInput stockInput) {
		stocks.add(stockInput);
	}
	
	public void addStocks(){ //�ֽ�'���� ����'�߰��ϴ� �Լ� ����
		Scanner input = new Scanner(System.in);
		int kind = 0; //����ڰ� �޴� �Է��� ���� ����� �ʱ�ȭ
		StockInput stockInput; //Stock Ŭ���� ������ ����
		while(kind != 1 || kind != 2) { //����ڰ� 1,2 �̿ܿ� ���ڸ� �Է��Ҷ����� �ݺ�
			try {
			System.out.print("1. �����ֽ�"); //�����ֽ� ���� �߰� �ȳ�
			System.out.println(" 2. �ؿ��ֽ�"); //�ؿ��ֽ� ���� �߰� �ȳ�
			System.out.print("�ֽ������� �������ּ��� between 1 - 2: "); //����ڿ��� ���������� �Է¹������� �ȳ��� ���
			kind = input.nextInt(); //����ڰ� �Է��� ���� kind������ �Ҵ�
			if (kind == 1) { //����ڰ� �����ֽ��� ����
				stockInput = new KoreaStock(StockKind.Korea); // ������ ����
				stockInput.getUserInput(input); //Stock Ŭ������ getUserInput() method ����
				stocks.add(stockInput); //�ڷ���ArrayList Stocks Ŭ������ �� �Ӽ��鿡 �� add�Լ��� �Ҵ� 
				break;// ����
			}
			else if (kind == 2) { //����ڰ� �ؿ��ֽ��� ����
				stockInput = new OverseaStock(StockKind.Oversea); //������ ����
				stockInput.getUserInput(input); //Stock Ŭ������ getUserInput() method ����
				stocks.add(stockInput); //�ڷ���ArrayList Stocks Ŭ������ �� �Ӽ��鿡 �� add�Լ��� �Ҵ�  
				break; //����
			}
			else {
				System.out.print("�ֽ������� �������ּ��� 1 or 2: "); //����ڿ��� �ùٸ� ���� �Է��Ҷ����� ���
			}
		}
			catch(InputMismatchException e) { //try/catch���� ���� ����ó��
				System.out.println("Please put an integer between 1 and 2f!"); //���� �ȳ��� ���
				if(this.input.hasNext()) { 
					this.input.next();
				}
				kind = -1;
			}
		}
	}
	
	public void deleteStocks(){ //�ֽ�'���� ����'�����ϴ� �Լ� ����
		Scanner input = new Scanner(System.in);
		System.out.println("� ������ �����Ͻðڽ��ϱ�?"); // ����ڿ��� ���� �� ���� �Է� �ȳ��� ���
		String name = input.next(); //������ ����� �Է°��� name�� �Ҵ�
		int index = findIndex(name); //findIndex method���� ��ȯ�� index���� index������ ����
		removefromStocks(index, name); //removefromStocks method�� ���� �ش� index������ ����
		
	}
	
	public int findIndex(String name) { //findIndex method ����
		int index = -1; //array�� index�� ��ã�°��� ���� �ϱ� ���� index�� -1 �Ҵ�.
		for(int i = 0; i<stocks.size(); i++) { //name�迭�� �Էµ� ũ�⸸ŭ for�ݺ��� �����ϰ� loop����
			if(stocks.get(i).getStocksName().equals(name)) { //�Է��� ������ ���� ������ ���� ������ index�� �Ҵ�
				index = i; //index�� �Ҵ�
				break; //����
			}
		}
		return index; //index�� ��ȯ
	}
	
	public int removefromStocks(int index, String name) { //removefromStocks method ����
		if(index >= 0) { //index���� 0�̻�
			stocks.remove(index); //�迭 index�� ���� ����
			System.out.println("�Էµ� ���� " + name + "��(��) �����Ǿ����ϴ�."); //����ڰ� �Է��� ���� ���� �ȳ��� ���
			return 1;
		} 
	else { //index���� �����ϰ��
			System.out.println("�Էµ� ������ ������ �����ϴ�."); //����ڿ��� �Է��� ���� ���� �ȳ��� ���
			return -1;
		}
	}
	
	
	public void editStocks() { //�ֽ�'���� ����' �����ϴ� �Լ� ����
		Scanner input = new Scanner(System.in);
		System.out.print("���� �̸�: "); //����ڿ��� ������ �ֽ� ���� �Է� �ȳ��� ���
		String name = input.next(); //����ڰ� �Է��� ���� name�� �Ҵ�
		for(int i = 0; i<stocks.size(); i++) { //name�迭�� �Էµ� ũ�⸸ŭ for�ݺ��� �����ϰ� loop����
			StockInput stock = stocks.get(i); //stocks��������� �ִ� �ε��� ���� stock�� �Ҵ�
			if(stock.getStocksName().equals(name)) { //���� �Է°��� ���� ����Ǿ��ִ� �ֽ����� ���� ���� ��� ���ڿ��̹Ƿ� equals() method�� Ȱ�� 
				int num = -1; // ����ڰ� �޴� �Է��� ���� ����� �ʱ�ȭ
				while (num != 5) { //edit �Ŵ� ����
					showEditMenu(); //showEditMenu method�� ���� ����ڿ��� �������� �޴� ����
					num = input.nextInt(); //����ڿ��� �Է¹��� ���� num�� �Ҵ�
					
					switch(num) { //switch���� Ȱ���� ����� ���� ����
						case 1: 
							stock.setStockName(input); //setStockName()�� ���� �ֽ��̸� ����
							break;//����
						case 2: 
							stock.setStockPrice(input); //setStockPrice()�� ���� �ֽĸż��� ����
							break;//����
						case 3: 
							stock.setStockGoal(input); //setStockGoal()�� ���� �ֽĸ�ǥ�� ����
							break;//����
						case 4: 
							stock.setStockMemo(input); //setStockMemo()�� ���� �ֽĸ޸� ����
							break;//����
						default: 
							continue; //loop�� Ż��
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
	
	
	public void showEditMenu() { //showEditMenu method ����
		System.out.println("### Stocks Info Edit Menu ###");
		System.out.println("1. Edit StocksName");
		System.out.println("2. Edit Price Stocks");
		System.out.println("3. Edit Goal Price");
		System.out.println("4. Edit Memo");
		System.out.println("5. Exit");
		System.out.print("Select one number between 1 - 5:");
	}
	
	public int size() {
		return stocks.size();
	}
	
	public StockInput get(int index) {
		return (Stock) stocks.get(index);
	}
	
}
