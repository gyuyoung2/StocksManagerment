package StocksManagement;

import java.util.ArrayList;
import java.util.Scanner;	

public class StocksManager {
	
	public static ArrayList<String> addStocks(){ //�ڷ��� ArrayList<String>���� ��ȯ�� ���� �� �ֽ�'����'�߰��ϴ� �Լ� ����
		Stocks stocks = new Stocks(); //���� ���� ������ �ޱ� ���� Stocks Ŭ���� ����
		ArrayList<String> addname = new ArrayList<String>();//���ϰ��� ��� ���� �Լ��ȿ� ArrayList 'addname' ����
		Scanner input = new Scanner(System.in); //����ڿ��� �Է¹ޱ����� ScannerŬ���� ����
		System.out.print("Stocks Id:"); //����ڿ��� ID�� �Է¹ޱ� ���� �ȳ��� ���
		stocks.StocksId = input.nextInt(); //input���� ������ �޾Ƽ� StocksId������ ����
		System.out.println("How many add StocksName?"); //����ڿ��� ��� �ֽ� ������ �߰����� �˷��ֱ�
		stocks.StocksNum = input.nextInt(); //input���� ������ �޾Ƽ� Stocks Ŭ������ Stocksnum������ ����
		for (int i = 0; i <stocks.StocksNum; i++) { //����ڰ� �Է��� ���� ������ŭ for�ݺ����� ���� loop����
			System.out.print("���������� �Է����ּ���."); //����ڿ��� ������ �Է¹������� �ȳ��� ���
			stocks.name = input.next(); //����ڰ� ���� ������ �Է°��� name������ ����
			addname.add(stocks.name); //ArrayList addname�� add�޼ҵ带 ����Ͽ� �ֽ�'����'�߰�
		}
		return addname; //ArrayList addname ���ϰ����� ��ȯ
	}
	
	public static void deleteStocks(ArrayList<String> name){
		Stocks stocks = new Stocks(); //���� ���� ������ �ޱ� ���� Stocks Ŭ���� ����
		Scanner input = new Scanner(System.in); //����ڿ��� �Է¹ޱ����� ScannerŬ���� ����
		System.out.println("� ������ �����Ͻðڽ��ϱ�?"); // ����Ǿ� �ִ� ��� �̸��� String���� ��ȯ�Ͽ� ���
		for(int i=0; i<name.size(); i++) { //name�迭�� �Էµ� ũ�⸸ŭ for�ݺ��� �����ϰ� loop����
	    stocks.StocksName = (String)name.get(i); //name�迭�� �Էµ� ���� INDEX���������� get method�� ����� ������ ����
	    System.out.println(stocks.StocksName); //������ ����� ���� ����ڿ��� ���
	} //����ڿ��� ������ ����Ȱ��� �����Ͽ� �����ֹǷν� ������ �ϱ⿡ �ð������� ������
		System.out.println("������ ������ �Է��ϼ���"); //����ڿ��� '�����ȳ�'���� ���
		stocks.StocksName = input.next(); // �Է¹��� �̸��� ArrayList name���� ����
		name.remove(stocks.StocksName); //remove method�� ����� ����ڰ� �Է��� ���� ����
		System.out.println("���������� �����Ϸ� �Ǿ����ϴ�."); //����ڿ��� ������ ���������� �̷�����ٴ� ���� �ȳ�
	}
	
	public static void viewStocks(ArrayList<String> name) { //�������� ����� ������� �����ִ� �Լ� ����
		System.out.println("*****���� ����ڰ� �����־��ϴ� �����Դϴ�*****"); //����ڿ��� ����� ������� �ð������� �����ִ� �ȳ��� ���
	    for(int i=0; i<name.size(); i++) { //for�ݺ����� ���� name�迭 ũ�⸸ŭ �ݺ��ǰ� loop����
	        System.out.println("ȸ��� : " + name.get(i)); //name�迭 �ݺ������̹Ƿ� INDEX��ȣ��� ���������� ���
	    }
	    if(name.size()==0) { //���� �迭�ȿ� �ƹ��͵� ���ٸ�?
	        System.out.println("����� �����ϴ�."); //����ڿ��� �迭�ȿ� ����� ������ ���ٰ� �ȳ��� ���
	        System.out.println("�������� �߰����ּ���."); //����ڿ��� �������� �߰��ش޶�� �ȳ��� ���
	    }
	    System.out.println("************************************"); 

	}
	
	public static void removeStocks(ArrayList<String> name) { //�������� ��� ��ü�� �ʱ�ȭ �ϴ� �Լ� ����
		Stocks stocks = new Stocks();
		Scanner input = new Scanner(System.in); //����ڿ��� �Է��� �ޱ� ���� Scanner Ŭ���� ����
		System.out.println("*****���� ��ü ������ ����ðڽ��ϱ�?*****"); //����ڿ��� ������ �����ü�� �ʱ�ȭ �ϴ��� �ȳ��� ���
		System.out.println("1.�� 2.�ƴϿ�"); //����ڰ� �Ǽ����� �ʰ� �ѹ��� �ʱ�ȭ ���� �ȳ��� ���
		stocks.RemoveNum= input.nextInt(); //����ڰ� �Է��� ���� ������ �޾� stocksŬ������ removenum������ ����
		if(stocks.RemoveNum==1) { // ����ڰ� �Է��� ���� ���� �ʱ�ȭ���� ���� �Ǻ�
		name.clear(); //clear method�� �����Ͽ� ��ü �迭���� ����
		System.out.println("���������� ������ �ʱ�ȭ �Ǿ����ϴ�."); //����ڿ��� �ʱ�ȭ �Ǿ��ٰ� �ȳ��� ���
		}
		else { //����ڰ� �ʱ�ȭ�� ���Ұ��
			System.out.println("�Ŵ��� ���ư��ϴ�."); //�ٽõ��ư��� �ȳ����� ���
		}
	}
	
}
