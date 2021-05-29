package GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StockViewer extends JFrame { //JFrameŬ������ ���.

	public StockViewer() { //StockViewer ������ ����
		DefaultTableModel model = new DefaultTableModel(); //DefaultTableModel ��ü ����
		model.addColumn("Company Name"); //model�� column���� Company Name �߰�
		model.addColumn("Buy Price"); //model�� column���� Buy Price �߰�
		model.addColumn("Goal Price"); //model�� column���� Goal Price �߰�
		model.addColumn("Memo"); //model�� column���� Goal Price �߰�
		
		JTable table = new JTable(model); //JTable ������ ����
		JScrollPane sp = new JScrollPane(table); // JScrollPane ������ ����
		
		this.add(sp); // frame�� jscrollpane �߰�
		this.setSize(500,500); //GUIâ ũ�⸦ ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�ݱ� �ϸ� ���α׷� ����
		this.setVisible(true); //setVisible�� ���� �ð������� ������
	}

}
