package stock;

import java.util.Scanner;

public class OverseaStock extends Stock {
	
	protected int Dollar = 1170; //�޷� ������ ���� �޷� ����
	
	public OverseaStock(StockKind kind) { //OverseaStock ����
		super(kind);
	}

	public void getUserInput(Scanner input) {
		System.out.print("�ֽ� ���� ���� �Է����ּ���: "); //����ڿ��� �ֽ� ������� �Է� �ȳ��� ���
		String StocksName = input.next(); //����ڿ��� ���� ���� �޾� StocksŬ������ StocksName�� ����
		this.setStocksName(StocksName); //�Է¹��� ���� setStocksName method�� ���ڰ����� �� ������� �����
		
		System.out.print("�� ������ �ż����� �Է����ּ��� :"); //����ڿ��� ������ �ż����� �ޱ����� �ȳ��� ���
		int buyStock = input.nextInt(); //����ڿ��� �ż��� ���� �޾� StocksŬ������ buyStock�� ����
		this.setBuyStock(buyStock); //�Է¹��� ���� setBuyStock method�� ���ڰ����� �� �ż��� ���� �����
		
		System.out.print("�� ������ ��ǥ���� �Է����ּ��� :"); //����ڿ��� ��ǥ���� �ޱ����� �ȳ��� ���
		int goalPrice = input.nextInt(); //����ڿ��� ��ǥ�� ���� �޾� StocksŬ������ goalPrice�� ����
		this.setGoalPrice(goalPrice); //�Է¹��� ���� setGoalPrice method�� ���ڰ����� �� ��ǥ�� ���� �����
		
		char answer = 'x'; //����ڿ��� �Է¹��� ���� ������ ���� ����� �ʱ�ȭ
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //����ڰ� �ùٸ� �Է��Ҷ����� �ݺ�
		{
			System.out.print("�޸� �Ͻǲ�����? (Y/N)"); //����ڰ� �� ������ �޸� �ޱ����� �ȳ��� ���
			answer = input.next().charAt(0); //����ڿ��� ���ڿ� �Է¹��� ���� answer�� ����
			if(answer =='y' || answer == 'Y' ) { //y�� �ҹ��� �빮�� ���� �ϳ���
				System.out.print("memo"); //memo ���� ���
				String memo = input.next(); //����ڿ��� �޸��� ������ �޾� StocksŬ������ memo�� ����
				this.setmemo(memo);  //�Է¹��� ���� setmemo method�� ���ڰ����� �� ����޸� ���� �����
				break; //����
			}
			else if(answer=='n' || answer == 'N') { //n�� �ҹ��� �빮�� ���� �ϳ���
				this.setmemo(""); //���� �Ҵ�
				break; //����
			}
			else {
			}
		}
		
		answer = 'x'; //����ڿ��� �Է¹��� ���� ������ ���� ����� �ʱ�ȭ
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //����ڰ� �ùٸ� �Է��Ҷ����� �ݺ�
		{
			System.out.print("�޷��� ����Ͻðڽ��ϱ�? (Y/N)"); //����ڰ� �� ������ ȯ�� ����ϱ� ���� �ȳ��� ���
			answer = input.next().charAt(0); //����ڿ��� ���ڿ� �Է¹��� ���� answer�� ����
			if(answer =='y' || answer == 'Y' ) { //y�� �ҹ��� �빮�� ���� �ϳ���
				System.out.print("Exchange rate of Dollar:"); //ȯ�� ���� ���
				Dollar = getBuyStock() / Dollar; // ȯ�����
				this.setDollar(Dollar);  //�Է¹��� ���� setDollar method�� ���ڰ����� �� ȯ������ �����
				System.out.println(Dollar + "�޷�");
				break; //����
			}
			else if(answer=='n' || answer == 'N') { //n�� �ҹ��� �빮�� ���� �ϳ���
				this.setDollar(0); //���� �Ҵ�
				break; //����
			}
			else {
			}
		}
	}
	
	public void printInfo() { //�ֽ������� ������ִ� printInfo() method
		String skind = "none";
		switch(this.kind) { //�ֽ� ���� �Ǻ�
		case Korea:
			skind = "�����ֽ�";
			break;
		case Oversea:
			skind = "�ؿ��ֽ�";
			break;
		default:
		}
		System.out.println("�ֽ� ����: "+ skind +"�����: "+ StocksName + " �ż���: "+buyStock+"�� ��ǥ��: "+goalPrice+"�� �޸�: "+ memo + "/ ȯ��: " + Dollar + "�޷�");//�ֽ����� ���
	}
}
