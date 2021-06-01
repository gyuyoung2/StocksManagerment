package GUI;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import StocksManagement.StocksManager;
import stock.StockInput;

public class StockViewer extends JPanel { //JFrame클래스에 상속.
	
	WindowFrame frame; //frame 선언
	
	StocksManager stocksManager; //stocksManager 선언

	public StockViewer(WindowFrame frame, StocksManager stocksManager) { //StockViewer 생성자 생성
		this.frame = frame; //인스턴스로 받은 값을 해당 클래스 변수에 저장
		this.stocksManager = stocksManager; 
		
		DefaultTableModel model = new DefaultTableModel(); //DefaultTableModel 객체 생성
		model.addColumn("Company Name"); //model에 column란에 Company Name 추가
		model.addColumn("Buy Price"); //model에 column란에 Buy Price 추가
		model.addColumn("Goal Price"); //model에 column란에 Goal Price 추가
		model.addColumn("Memo"); //model에 column란에 Goal Price 추가
		
		for(int i=0; i<stocksManager.size(); i++) { //저장된 주식종목들을 보여주기 위해 반복문 사용
			Vector row = new Vector(); //vector 객체 생성
			StockInput si = stocksManager.get(i); 
			row.add(si.getStocksName()); //각 항목에 맞는 정보 추가
			row.add(si.getBuyStock());
			row.add(si.getGoalPrice());
			row.add(si.getMemo());
			model.addRow(row);
		}
		
		JTable table = new JTable(model); //JTable 생성자 생성
		JScrollPane sp = new JScrollPane(table); // JScrollPane 생성자 생성
		
		this.add(sp); // frame에 jscrollpane 추가
	}

}
