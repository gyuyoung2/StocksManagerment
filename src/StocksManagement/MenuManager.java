package StocksManagement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

import GUI.WindowFrame;
import log.EventLogger;
public class MenuManager {
	static EventLogger logger = new EventLogger("log.txt"); //log�� ����ϴ� ������ ����
	
	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in); //����ڿ��� �Է¹ޱ����� ScannerŬ���� ����
		StocksManager stocksManager = getObject("stockmanager.ser"); //����ȭ ó��.(��ü�� ���Ͽ� ����)
		if(stocksManager == null) { //stocksManager�� ���������
			stocksManager = new StocksManager(input);
		} //���� �Ŵ��� ��� method�� Ȱ���ϱ� ����StocksManager Ŭ���� ����
		
		
		WindowFrame frame = new WindowFrame(stocksManager); //WindowFrame ��ü ����
		selectMenu(input, stocksManager); //selectMenu method�� Ȱ���Ͽ� ����ڿ��� �޴������ ���ñ�� �߰�
		putObject(stocksManager, "stockmanager.ser"); //stockmanager.ser ��ü ����
		
	}
	
	public static void selectMenu(Scanner input, StocksManager stocksManager) { //selectMenu method ����
		int num= -1;// ����ڰ� �޴� �Է��� ���� ����� �ʱ�ȭ
		while (num != 5) { //�Ŵ� ����
			try {
			showMenu();//showMenu method�� ���� �޴� ���
			
			num = input.nextInt(); //����ڰ� �Է��� ���� ���������� ������ ����
			switch(num) { //switch������ ���� ����ڰ� ����ϰ��� �ϴ� �޴��� �̵�
			case 1:
				stocksManager.addStocks();//�ֽ� ���� ����ϴ� �Լ� ����
				logger.log("add a Stock"); //�α� ����
				break;
			case 2:
				stocksManager.deleteStocks(); //�ֽ� ���� �����ϴ� �Լ� ����
				logger.log("delete a Stock"); //�α� ����
				break;
			case 3:
				stocksManager.editStocks(); //�������� ��� ������� �����ϴ� �Լ� ����
				logger.log("edit a Stock"); //�α� ����
				break;
			case 4:
				stocksManager.viewStocks(); //���������� �����ִ� �Լ� ����
				logger.log("view a Stocks"); //�α� ����
				break;
			default:
				continue;//���α׷� ����
				}
			}
			catch(InputMismatchException e) { //try/catch���� ����� ����ó��
				System.out.println("Please put an integer between 1 and 4!");
				if(input.hasNext()) {
					input.next();
				}
				num = -1;
			}
		}
	}
	
	public static void showMenu() { //addMenu method ����
		System.out.println("### Stocks Management System Menu ###");
		System.out.println("1. Add Stocks");
		System.out.println("2. Delete Stocks");
		System.out.println("3. Edit Stocks");
		System.out.println("4. View Stocks");
		System.out.println("5. Exit");
		System.out.print("Select one number between 1 - 5:");
	}
	
	public static StocksManager getObject(String fileName) { //getObject method ����
		StocksManager stocksManager = null; //stocksManager �ʱ�ȭ
		
		
		try { //try/catch�� ����
			FileInputStream file = new FileInputStream(fileName); //FileInputStream Ŭ���� ������ ����
			ObjectInputStream in = new ObjectInputStream(file); //ObjectInputStream Ŭ���� ������ ����
			
			stocksManager = (StocksManager) in.readObject(); //readObject method�� �̿��� ������ �о��
			
			in.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			return stocksManager; //stocksManger�� ��ȯ��
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManger�� ��ȯ��
		
	}
	
	public static StocksManager putObject(StocksManager stocksManager ,String fileName) { //putObject method ����
		try {
			FileOutputStream file = new FileOutputStream(fileName); //FileOutputStream Ŭ���� ������ ����
			ObjectOutputStream out = new ObjectOutputStream(file); //ObjectOutputStream Ŭ���� ������ ����
			
			out.writeObject(stocksManager); //writeObject method�� ���� ������ ��ü�� ����.
			
			out.close(); //close
			file.close(); //close
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stocksManager; //stocksManager�� ��ȯ
		
	}
}



		
		