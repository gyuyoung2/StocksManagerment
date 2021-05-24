package stock;

import java.util.Scanner;

public class OverseaStock extends WorldStock { //OverseaStock Ŭ������ WorldStockŬ������ ���
	
	
	public OverseaStock(StockKind kind) { //OverseaStock ����
		super(kind);
	}

	public void getUserInput(Scanner input) {
		setStockName(input); //setStockName method�� ���� ����ڿ��� �ֽ� ������� �Է¹���
		
		setStockPrice(input); //setStockPrice method�� ���� ����ڿ��� �ֽ� �ż����� �Է¹���
		
		setStockGoal(input); //setStockGoal method�� ���� ����ڿ��� �ֽ� ��ǥ���� �Է¹���
		
		setStockMemowithYN(input); //setStockMemowithYN method�� ���� ����ڿ��� �޸� ���ο� �޸� �Է¹���
		
		setStockDollarwithYN(input); //setStockDollarwithYN method�� ���� ����ڿ��� ȯ�� ���ο� ȯ�������� �Է¹���
	}
	
	
	public void printInfo() { //�ֽ������� ������ִ� printInfo() method.
		String skind = getKindString(); //getKindString method�� ���� �ֽ������� ������.
		System.out.println("�ֽ� ����: "+ skind +"�����: "+ StocksName + " �ż���: "+buyStock+"�� ��ǥ��: "+goalPrice+"�� �޸�: "+ memo + "/�ż�($): " + Dollar + "�޷�");//�ֽ����� ���
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
		return skind;
	}
}
