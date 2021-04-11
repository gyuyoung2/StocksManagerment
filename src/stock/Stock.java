package stock;


import java.util.Scanner;

public class Stock { //StocksŬ������ ���庯�� �ʵ� ���� 
	protected StockKind kind = StockKind.Korea;
	protected String StocksName; //����ڰ� �Է��� ���� �����ϰ� name�迭�� ����� ���� ��ȯ�� ���� ����
	protected String name; //����ڰ� �ֽ� ���� �Է��� ���� �����ϴ� ���� ����
	protected int buyStock; //����ڰ� �ֽĸ� �ż��� ���� ���� �����ϴ� ���� ����
	protected int goalPrice; //����ڰ� �ֽ��� ��ǥ���� �Է��� ���� �����ϴ� ���� ����
	protected String memo; //����ڰ� �� ���� ���� �޸��� ���� �����ϴ� ���� ����
	
	public Stock() { 
	}
	
	public Stock(String StocksName, int buyStock, int goalPrice, String memo) { 
		//Stock Ŭ���� ���ڰ��ȿ� �ֽ������, �ż���, ��ǥ��, ���� �޸� ���������� ������
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

	public void setBuyStock(int buyStock) { //setBuyStock() method ����
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

	public void setmemo(String memo) { //setmemo() method����
		this.memo = memo; //���ڰ����� ���� �޸� ���� memo�� �Ҵ�
	}
	
	public void printInfo() { //�ֽ������� ������ִ� printInfo() method 
		System.out.println("�����: "+ StocksName + " �ż���: "+buyStock+"�� ��ǥ��: "+goalPrice+"�� �޸�: "+memo);//�ֽ����� ���
	}
	
	public void getUserInput(Scanner input) { //������ �Է��ϴ� getUserInput method ����
		System.out.print("�ֽ� ���� ���� �Է����ּ���: "); //����ڿ��� �ֽ� ������� �Է� �ȳ��� ���
		String StocksName = input.next(); //����ڿ��� ���� ���� �޾� StocksŬ������ StocksName�� ����
		this.setStocksName(StocksName); //�Է¹��� ���� setStocksName method�� ���ڰ����� �� ������� �����
		
		System.out.print("�� ������ �ż����� �Է����ּ��� :"); //����ڿ��� ������ �ż����� �ޱ����� �ȳ��� ���
		int buyStock = input.nextInt(); //����ڿ��� �ż��� ���� �޾� StocksŬ������ buyStock�� ����
		this.setBuyStock(buyStock); //�Է¹��� ���� setBuyStock method�� ���ڰ����� �� �ż��� ���� �����
		
		System.out.print("�� ������ ��ǥ���� �Է����ּ��� :"); //����ڿ��� ��ǥ���� �ޱ����� �ȳ��� ���
		int goalPrice = input.nextInt(); //����ڿ��� ��ǥ�� ���� �޾� StocksŬ������ goalPrice�� ����
		this.setGoalPrice(goalPrice); //�Է¹��� ���� setGoalPrice method�� ���ڰ����� �� ��ǥ�� ���� �����
		
		System.out.print("���� �޸�:"); //����ڰ� �� ������ �޸� �ޱ����� �ȳ��� ���
		String memo = input.next(); //����ڿ��� �޸��� ������ �޾� StocksŬ������ memo�� ����
		this.setmemo(memo); //�Է¹��� ���� setmemo method�� ���ڰ����� �� ����޸� ���� �����
	}
	
	
	
	
}
