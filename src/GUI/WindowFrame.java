package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import StocksManagement.StocksManager;

public class WindowFrame extends JFrame { //JFrame클래스 상속
		
		StocksManager stocksManager; //stocksManager 객체 생성
		MenuSelection menuselction; //MenuSelction 객체 생성
		StockAdder stockadder; //StockAdder 객체 생성
		StockViewer stockviewer; //StockViewer 객체 생성
		
	public WindowFrame(StocksManager stocksManager) { //WindowFrame 생성자 인스턴스에 stocksManager값 지정
		
		this.stocksManager = stocksManager; //인스턴스로 받은 값을 해당클래스 변수에 저장
		menuselction = new MenuSelection(this); //MenuSelction 객체 생성.
		stockadder = new StockAdder(this); //StockAdder 객체 생성
		stockviewer = new StockViewer(this, this.stocksManager); //StockViewer 객체 생성
		this.setSize(500,400); //GUI크기 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //창이 닫히면 프로그램 종료
		
		
		this.setupPanel(menuselction); //setupPanel method
		
		this.setVisible(true); //창이 시각적으로 보임 
	}
	
	public void setupPanel(JPanel panel) { //setupPanel method 생성
		this.getContentPane().removeAll(); 
		this.add(panel);
		this.revalidate();
		this.repaint();
	}

	/**
	 * @return the menuselction
	 */
	public MenuSelection getMenuselction() {
		return menuselction;
	}

	/**
	 * @param menuselction the menuselction to set
	 */
	public void setMenuselction(MenuSelection menuselction) {
		this.menuselction = menuselction;
	}

	/**
	 * @return the stockadder
	 */
	public StockAdder getStockadder() {
		return stockadder;
	}

	/**
	 * @param stockadder the stockadder to set
	 */
	public void setStockadder(StockAdder stockadder) {
		this.stockadder = stockadder;
	}

	/**
	 * @return the stockviewer
	 */
	public StockViewer getStockviewer() {
		return stockviewer;
	}

	/**
	 * @param stockviewer the stockviewer to set
	 */
	public void setStockviewer(StockViewer stockviewer) {
		this.stockviewer = stockviewer;
	}
}
