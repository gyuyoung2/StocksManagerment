package GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StockViewer extends JFrame {

	public StockViewer() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Companay Name");
		model.addColumn("Buy Price");
		model.addColumn("Goal Price");
		model.addColumn("Memo");
		
		JTable table = new JTable(model);
		JScrollPane sp = new JScrollPane(table);
		
		this.add(sp);
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

}
