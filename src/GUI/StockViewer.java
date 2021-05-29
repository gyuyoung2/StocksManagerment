package GUI;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class StockViewer extends JFrame { //JFrame클래스에 상속.

	public StockViewer() { //StockViewer 생성자 생성
		DefaultTableModel model = new DefaultTableModel(); //DefaultTableModel 객체 생성
		model.addColumn("Company Name"); //model에 column란에 Company Name 추가
		model.addColumn("Buy Price"); //model에 column란에 Buy Price 추가
		model.addColumn("Goal Price"); //model에 column란에 Goal Price 추가
		model.addColumn("Memo"); //model에 column란에 Goal Price 추가
		
		JTable table = new JTable(model); //JTable 생성자 생성
		JScrollPane sp = new JScrollPane(table); // JScrollPane 생성자 생성
		
		this.add(sp); // frame에 jscrollpane 추가
		this.setSize(500,500); //GUI창 크기를 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창닫기 하면 프로그램 종료
		this.setVisible(true); //setVisible를 통해 시각적으로 보여줌
	}

}
