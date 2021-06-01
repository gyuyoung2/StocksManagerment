package GUI;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import StocksManagement.StocksManager;
import stock.StockInput;

public class StockViewer extends JPanel { //JFrameŬ������ ���.
	
	WindowFrame frame; //frame ����
	
	StocksManager stocksManager; //stocksManager ����

	public StockViewer(WindowFrame frame, StocksManager stocksManager) { //StockViewer ������ ����
		this.frame = frame; //�ν��Ͻ��� ���� ���� �ش� Ŭ���� ������ ����
		this.stocksManager = stocksManager; 
		
		DefaultTableModel model = new DefaultTableModel(); //DefaultTableModel ��ü ����
		model.addColumn("Company Name"); //model�� column���� Company Name �߰�
		model.addColumn("Buy Price"); //model�� column���� Buy Price �߰�
		model.addColumn("Goal Price"); //model�� column���� Goal Price �߰�
		model.addColumn("Memo"); //model�� column���� Goal Price �߰�
		
		for(int i=0; i<stocksManager.size(); i++) { //����� �ֽ�������� �����ֱ� ���� �ݺ��� ���
			Vector row = new Vector(); //vector ��ü ����
			StockInput si = stocksManager.get(i); 
			row.add(si.getStocksName()); //�� �׸� �´� ���� �߰�
			row.add(si.getBuyStock());
			row.add(si.getGoalPrice());
			row.add(si.getMemo());
			model.addRow(row);
		}
		
		JTable table = new JTable(model); //JTable ������ ����
		JScrollPane sp = new JScrollPane(table); // JScrollPane ������ ����
		
		this.add(sp); // frame�� jscrollpane �߰�
	}

}
