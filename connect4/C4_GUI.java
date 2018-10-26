package connect4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C4_GUI extends JFrame{
	public static final int BOTTOM_ROW = 5;
	
	private JPanel jpMain;
	private BtnRow btnRow;
	private Board board;
	private displayName name;
	
	private Player currPlayer;
	private Player player1;
	private Player player2;
	
	public C4_GUI() {
		player1 = new Player("Mario", "M");
		player1 = new Player("Luigi", "L");
		currPlayer = player1;
		
		jpMain = new JPanel();
		jpMain.setLayout(new BorderLayout());
		
		btnRow = new BtnRow();
		board = new Board();
		name = new displayName();
		
		add(jpMain);
		
		jpMain.add(btnRow);
		jpMain.add(BorderLayout.NORTH, btnRow);
		btnRow.setBackground(Color.YELLOW);
		
		jpMain.add(board);
		jpMain.add(BorderLayout.CENTER, board);
		
		
		
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private class BtnRow extends JPanel implements ActionListener{
		private JButton [] colSelect;
		private final int COLS = 7;
		int [] nextRowAvail = {5,5,5,5,5,5,5};
		
		public BtnRow() {
			setLayout(new GridLayout(1, COLS));
			colSelect = new JButton[COLS];
			for(int i = 0; i < COLS; i++) {
				colSelect[i] = new JButton(""+ i);
				colSelect[i].setEnabled(true);
				colSelect[i].addActionListener(this);
				add(colSelect[i]);
			}
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btnClicked = (JButton) e.getSource();
			if (currPlayer == player1) {
				for (int i = 0; i < colSelect.length; i++) {
					if (btnClicked.equals(colSelect[i])) {
						int rowToPlace = nextRowAvail[i];
						board.board[rowToPlace][i].setText("M");
						nextRowAvail[i]--;
					}
				}
			}
			else if (currPlayer == player2) {
				for (int i = 0; i < colSelect.length; i++) {
					if (btnClicked.equals(colSelect[i])) {
						int rowToPlace = nextRowAvail[i];
						board.board[rowToPlace][i].setText("L");
						nextRowAvail[i]--;
					}
				}
			}
			
			takeTurn();
			
		}
		
		
		public void takeTurn() {
			if(currPlayer.equals(player1)) {
				currPlayer = player2;
			}
			else if(currPlayer.equals(player2)){
				currPlayer = player1;
			}
			
		}
		
	}
	
	private class Board extends JPanel{
		private JLabel [][] board;
		private final int ROWS = 6;
		private final int COLS = 7;
		
		public Board() {

			setLayout(new GridLayout(6,7));
			board = new JLabel[6][7];
			for(int rows = 0; rows < ROWS; rows++) {
				for (int cols = 0; cols < COLS; cols++) {
					board[rows][cols] = new JLabel("*");
					add(board[rows][cols]);
				}
				
				
			}
			
			
		}
		
	}
	
	private class displayName extends JPanel {
		private JLabel name;
		
		public displayName() {
			setLayout(new GridLayout(1, 1));
			name = new JLabel();
			if (currPlayer == player1) {
				name.setText("Current player: Mario");
			} else if (currPlayer == player2) {
				name.setText("Current player: Luigi");
			}
		}
	}
	
}
/*
//parallel tracker

int [] nextRowAvail = {5,5,5,5,5,5,5};

public void actionPerformed (ActionEvent e) {
	JButton btnClicked = e.getSource();
	for (int i = 0; i < btn.length(); i++) {
		if (btnClicked.equals(btns[i]) {
			int rowToPlace = nextRowAvail[i];
			board[rowToPlace][i].setText(setPlayerSymbol());
			nextRowAvail[i]--;
		}
	}
}

Consecutive matches

for (int row = 0; row < 6; row++) {
	int matches = 0;
	for (int col = 0; col < 7; col++) {
		if(board[row][col].equals(symbol) {
			matches++;
		}
		else {
			matches = 0; //reset
		}
		if (matches = 4) {
			return true;
		}
	}
}
*/