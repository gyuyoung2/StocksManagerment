package stock;

import java.util.Scanner;

public abstract class WorldStock extends Stock { //WorldStockŬ������ StockŬ������ ���.

	public WorldStock(StockKind kind) { //OverseaStock ����
		super(kind);
	}
	
	@Override
	public abstract void getUserInput(Scanner input);

	@Override
	public abstract void printInfo();

	public void setStockMemowithYN(Scanner input) { //setStockMemowithYN method ����
		char answer = 'x'; //����ڿ��� �Է¹��� ���� ������ ���� ����� �ʱ�ȭ
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //����ڰ� �ùٸ� �Է��Ҷ����� �ݺ�
		{
			System.out.print("�޸� �Ͻǲ�����? (Y/N)"); //����ڰ� �� ������ �޸� �ޱ����� �ȳ��� ���
			answer = input.next().charAt(0); //����ڿ��� ���ڿ� �Է¹��� ���� answer�� ����
			if(answer =='y' || answer == 'Y' ) { //y�� �ҹ��� �빮�� ���� �ϳ���
				setStockMemo(input); //setStockMemo method�� ���� ����ڿ��� �޸� �Է¹���				
				break; //����
			}
			else if(answer=='n' || answer == 'N') { //n�� �ҹ��� �빮�� ���� �ϳ���
				this.setmemo(""); //���� �Ҵ�
				break; //����
			}
			else {
			}
		}
	}
	
	public void setStockDollarwithYN(Scanner input) { //setStockDollarwithYN method ����
		char answer = 'x'; //����ڿ��� �Է¹��� ���� ������ ���� ����� �ʱ�ȭ
		while (answer != 'y' && answer != 'Y' && answer != 'n' && answer != 'N') //����ڰ� �ùٸ� �Է��Ҷ����� �ݺ�
		{
			System.out.print("�޷��� ����Ͻðڽ��ϱ�? (Y/N)"); //����ڰ� �� ������ ȯ�� ����ϱ� ���� �ȳ��� ���
			answer = input.next().charAt(0); //����ڿ��� ���ڿ� �Է¹��� ���� answer�� ����
			if(answer =='y' || answer == 'Y' ) { //y�� �ҹ��� �빮�� ���� �ϳ���
				Dollar = setStockDollar(input); //setStockDollar method�� ���� ����ڿ��� �޷� ȯ���� ����
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
}
