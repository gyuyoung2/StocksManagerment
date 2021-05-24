package stock;

import java.util.Scanner;

public class KoreaStock extends WorldStock { //KoreaStockŬ������ WorldStock�� ��ӹ���.
	
	public KoreaStock(StockKind kind) { //koreaStock ����
		super(kind);
	}
	
	public void getUserInput(Scanner input) { //������� �Է��� �޴� getUserInput method
		setStockName(input); //setStockName method�� ���� ����ڿ��� �ֽ� ������� �Է¹���
		setStockPrice(input); //setStockPrice method�� ���� ����ڿ��� �ֽ� �ż����� �Է¹���
		setStockGoal(input); //setStockGoal method�� ���� ����ڿ��� �ֽ� ��ǥ���� �Է¹���
		setStockMemowithYN(input); //setStockMemowithYN method�� ���� ����ڿ��� �޸� ���ο� �޸� �Է¹���
	}
	
	public void printInfo() { //�ֽ������� ������ִ� printInfo() method
		String skind = getKindString(); //getKindString method���� ��ȯ���� skind�� ���� skind������ ����
		System.out.println("�ֽ� ����: "+ skind +" �����: "+ StocksName + " �ż���: "+buyStock+"�� ��ǥ��: "+goalPrice+"�� �޸�: "+memo);//�ֽ����� ���
	}
	
	public String getKindString() { //�ֽ������� ���ڿ��� �������� getKindString() method
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
		return skind; //�ֽ� ���� ��ȯ
	}
}
