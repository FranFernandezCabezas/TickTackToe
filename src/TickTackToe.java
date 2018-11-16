
public class TickTackToe {

	
	private static final int NUM_ROWS = 3;
	private static final int NUM_COLS = 3;
	public static final char PLAYER1 = 'X';
	public static final char PLAYER2 = 'O';
	public static final char VOID = ' ';
	
	private int[][] board;
	private int turn;
	
	public TickTackToe() {
		
		board = new int [NUM_COLS][NUM_ROWS];
		
		for (int i = 0; i < NUM_COLS; i++) {
			
			for (int j = 0; j < NUM_ROWS; j++) {
				
				board[j][i] = 0;
			}
		}
		
		turn = 1;
	}
	
	@Override
	public String toString() {
		
		String s = "";
		s += "\n";	
		for (int i = 0; i < NUM_COLS; i++) {
			
			for (int j = 0; j < NUM_ROWS; j++) {
				
				if (board[i][j] == 0) {
				
				s += "[" + VOID + "]";
				}
				if (board[i][j] == 1) {
					
					s += "[" + PLAYER1 + "]";
				}
				if (board[i][j] == 2) {
					
					s+= "[" + PLAYER2 + "]";
				}
			}
			s += "\n";
		}
		return s;
	}
	
	public void shot(int row, int col) {
		
		if (board[row][col] != 0) {
			
			System.out.println();
			System.out.println("Spot already selected");
			
			return;
		}
		
		if (turn == 1) {
			
			board[row][col] = 1;
			turn = 2;
			
		} else {
			
			board[row][col] = 2;
			turn = 1;
		}

	}
	
	
	public boolean checkGameOver() {
		
		int numOfX = 0;
		int numOfO = 0;
		
		for (int i = 0; i < NUM_COLS; i++) {
			
			numOfX = 0;
			numOfO = 0;
			
			for (int j = 0; j < NUM_ROWS; j++) {
				
				if (board[i][j] == 1) {
					
					numOfX++;
					
				}
				
				if (board[i][j] == 2) {
					
					numOfO++;
				}
				
			}
			if (numOfX == NUM_COLS || numOfO == NUM_ROWS) {
				
				 return true;
			}
		}

		for (int i = 0; i < NUM_ROWS; i++) {
			
			numOfX = 0;
			numOfO = 0;
			
			for (int j = 0; j < NUM_COLS; j++) {
				
				if (board[j][i] == 1) {
					
					numOfX++;
					
				}
				
				if (board[j][i] == 2) {
					
					numOfO++;
				}
				
			}
			if (numOfX == NUM_COLS || numOfO == NUM_COLS) {
				
				 return true;
			}
		}
		
		numOfX = 0;
		numOfO = 0;
		
		for (int i = 0; i < NUM_COLS; i++) {
			
			if (board[i][i] == 1) {
				
				numOfX++;
				
			}
			
			if (board[i][i] == 2) {
				
				numOfO++;
			}
			
		}
		if (numOfX == NUM_COLS || numOfO == NUM_COLS) {
			
			 return true;
		}
		
		numOfX = 0;
		numOfO = 0;
		
		
		for (int i = 0; i < NUM_COLS; i++) {
			
			if (board[i][NUM_COLS - i - 1] == 1) {
				
				numOfX++;
				
			}
			
			if (board[i][NUM_COLS - i - 1] == 2) {
				
				numOfO++;
			}
		}
		
		if (numOfX == NUM_COLS || numOfO == NUM_COLS) {
			
			 return true;
		}	
	
		return false;
	}

	public String getPlayer() {
		
		char c = 'a'; 
		
		if (turn == 1) {
			
			c = PLAYER1;
		}
		
		if (turn == 2) {
			
			c = PLAYER2;
		}
		
		
		return turn + "(" + c + ")" ;
	}
	
	public void changeTurn() {
		
		if (turn == 1) {

			turn = 2;
		} else {
			
			turn = 1;
		}
	}
}


