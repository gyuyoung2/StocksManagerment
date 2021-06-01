package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

import StocksManagement.StocksManager;

public class WindowFrame extends JFrame { //JFrameŬ���� ���
		
		StocksManager stocksManager; //stocksManager ��ü ����
		MenuSelection menuselction; //MenuSelction ��ü ����
		StockAdder stockadder; //StockAdder ��ü ����
		StockViewer stockviewer; //StockViewer ��ü ����
		
	public WindowFrame(StocksManager stocksManager) { //WindowFrame ������ �ν��Ͻ��� stocksManager�� ����
		
		this.stocksManager = stocksManager; //�ν��Ͻ��� ���� ���� �ش�Ŭ���� ������ ����
		menuselction = new MenuSelection(this); //MenuSelction ��ü ����.
		stockadder = new StockAdder(this); //StockAdder ��ü ����
		stockviewer = new StockViewer(this, this.stocksManager); //StockViewer ��ü ����
		this.setSize(500,400); //GUIũ�� ����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â�� ������ ���α׷� ����
		
		
		this.setupPanel(menuselction); //setupPanel method
		
		this.setVisible(true); //â�� �ð������� ���� 
	}
	
	public void setupPanel(JPanel panel) { //setupPanel method ����
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
