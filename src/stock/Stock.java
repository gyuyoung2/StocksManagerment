package stock;


import java.io.Serializable;
import java.util.Scanner;

import exception.SellException;

public abstract class Stock implements StockInput, Serializable { /** //StocksŬ������ ���庯�� �ʵ� ���� , Stocks�� ��ü�� �������� ����.
	 * 
	 */
	private static final long serialVersionUID = 8737937472405928517L;

private static final int Null = 0;
	
	protected StockKind kind = StockKind.Korea; //�ֽ� ����
	protected String StocksName; //����ڰ� �Է��� ���� �����ϰ� name�迭�� ����� ���� ��ȯ�� ���� ����
	protected String name; //����ڰ� �ֽ� ���� �Է��� ���� �����ϴ� ���� ����
	protected int buyStock; //����ڰ� �ֽĸ� �ż��� ���� ���� �����ϴ� ���� ����
	protected int goalPrice; //����ڰ� �ֽ��� ��ǥ���� �Է��� ���� �����ϴ� ���� ����
	protected String memo; //����ڰ� �� ���� ���� �޸��� ���� �����ϴ� ���� ����
	protected int Dollar; //����ڰ� �ؿ��ֽ��� �Է��� ��� ��ȭ���� �޷��� ������ ���� �����ϴ� ���� ����
	
	public Stock() { 
	}
	
	public Stock(StockKind kind) { //method overloading (����)
		this.kind = kind;
	}
	
	public Stock(StockKind kind, String StocksName, int buyStock, int goalPrice, String memo) {  //Stock Ŭ���� ���ڰ� �ȿ� �ֽ� ����, �ֽ������, �ż���, ��ǥ��, ���� �޸� ���������� ������
		this.kind = kind; //�ֽ� ������ kind�� �Ҵ�
		this.StocksName = StocksName; //�ֽ�������� StocksName�� �Ҵ�
		this.buyStock = buyStock; //�ż����� buyStock�� �Ҵ� 
		this.goalPrice = goalPrice; //��ǥ���� goalPrice�� �Ҵ�
		this.memo = memo; //���� �޸� memo�� �Ҵ�
	}
	
	public StockKind getKind() { //getKind() method ����
		return kind; //��ȯ������ ���� kind �� ��ȯ
	}

	public void setKind(StockKind kind) { //setKind() method ����
		this.kind = kind; //���ڰ����� ���� �ֽ� ���� ���� kind�� �Ҵ�
	}

	public String getStocksName() { //getStocksName() method ����
		return StocksName; //��ȯ������ ���� StocksName �� ��ȯ
	}

	public void setStocksName(String stocksName) { //setStocksName() method ����
		this.StocksName = stocksName; //���ڰ����� ���� ���� �̸��� StocksName�� �Ҵ�
	}

	public int getBuyStock() { //getBuyStock() method ����
		return buyStock; //��ȯ������ ���� buyStock �� ��ȯ
	}

	public void setBuyStock(int buyStock) throws SellException { //setBuyStock() method ����
		if (buyStock<=0 || buyStock == Null) {
			throw new SellException();
		}
		
		this.buyStock = buyStock; //���ڰ����� ���� �ż��� ���� buyStock�� �Ҵ�
	}

	public int getGoalPrice() { //getGoalPrice() method ����
		return goalPrice; //��ȯ������ ���� goalPrice �� ��ȯ
	}

	public void setGoalPrice(int goalPrice) { //setGoalPrice() method ����
		this.goalPrice = goalPrice; //���ڰ����� ���� ��ǥ�� ���� goalPrice�� �Ҵ�
	}
	
	public String getMemo() { //getMemo() method ����
		return memo; //��ȯ������ ���� memo �� ��ȯ
	}

	public void setmemo(String memo) { //setmemo() method����.
		this.memo = memo; //���ڰ����� ���� �޸� ���� memo�� �Ҵ�
	}
	
	public int getDollar() { //getDollar() method ����
		return Dollar; //��ȯ������ ���� Dollar �� ��ȯ
	}
	
	public void setDollar(int Dollar) { //setDollar() method����
		this.Dollar = Dollar; //���ڰ����� ���� �޷� ���� Dollar�� �Ҵ�
	}
	
	
	public abstract void printInfo(); //������ Ŭ������ printInfo�� �����Ƿ�, �߻�ȭ method ����.
	
	public void setStockName(Scanner input) { //setStockName method ����
		System.out.print("���� �̸�: "); //����ڿ��� �����̸��� �Է� �ȳ��� ���
		String StocksName = input.next(); //�Է��� �����̸��� StocksName�� �Ҵ�
		this.setStocksName(StocksName); //�� �ԷµȰ��� setStocksName method�� ���ڰ����� �� �̸��� �����
	}	
	
	public void setStockPrice(Scanner input) { //setStockPrice method ����
		int buyStock = 0;
		while (buyStock <= 0) {
			System.out.print("���� �ż���: "); //����ڿ��� ���� �ż����� �Է� �ȳ��� ���
			buyStock = input.nextInt(); //�Է��� �ż����� buyStock�� �Ҵ�
			try {
				this.setBuyStock(buyStock);
			} catch (SellException e) { //try/catch���� Ȱ�������ν� ����ó��
				System.out.println("�ż����� 0���̻����� �����ּ���."); //���� �ȳ��� ���
			}//�� �ԷµȰ��� setBuyStock method�� ���ڰ����� �� �ż��� ���� �����
		}
	}
	
	public void setStockGoal(Scanner input) { //setStckGoal method ����
		System.out.print("�� ������ ��ǥ���� �Է����ּ��� :"); //����ڿ��� ��ǥ���� �ޱ����� �ȳ��� ���
		int goalPrice = input.nextInt(); //����ڿ��� ��ǥ�� ���� �޾� StocksŬ������ goalPrice�� ����
		this.setGoalPrice(goalPrice); //�Է¹��� ���� setGoalPrice method�� ���ڰ����� �� ��ǥ�� ���� �����
	}
	
	public void setStockMemo(Scanner input) { //setStockMemo method ����
		System.out.print("memo"); //memo ���� ���
		String memo = input.next(); //����ڿ��� �޸��� ������ �޾� StocksŬ������ memo�� ����
		this.setmemo(memo);  //�Է¹��� ���� setmemo method�� ���ڰ����� �� ����޸� ���� �����
	}
	
	public int setStockDollar(Scanner input) { //setStockDollar method ����
		int Dollar = 1170; //�޷� ������ ���� �޷� ����
		System.out.print("Exchange rate of Dollar:"); //ȯ�� ���� ���
		int Dollar1 = getBuyStock() / Dollar; // �ż��� ȯ�����
		int Dollar2 = getGoalPrice() / Dollar; //��ǥ�� ȯ�����
		this.setDollar(Dollar1);  //�Է¹��� ���� setPriceDollar method�� ���ڰ����� �� �ż��� ȯ������ �����
		System.out.print("�ż��� ȯ��: " + Dollar1 + "�޷�"); //�ż��� �޷� ���
		System.out.println("��ǥ�� ȯ��: " + Dollar2 + "�޷�"); // ��ǥ�� �޷� ���
		return Dollar1; //�ż��� �޷� ��ȯ
	}
	
}
