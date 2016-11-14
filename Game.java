public class Game {
	public StringBuffer board;
	public int i_boardSize = 9;
	public Game(String s) {board = new StringBuffer(s);}

	public Game(StringBuffer s, int position, char player, int boardSize) {
		board = new StringBuffer();
		board.append(s);
		board.setCharAt(position, player);
		i_boardSize = boardSize;
	}

	public int move(char player) {
		for (int i = 0; i < i_boardSize; i++) {
			if (board.charAt(i) == '-') 
				return i;
		}	
		return -1;
	}
	
	public int winningMove(char player){
		for (int i = 0; i < i_boardSize; i++) {
			if (board.charAt(i) == '-') {
				Game game = play(i, player);
				if (game.winner() == player) 
					return i;
			}
			
		}
		return -1;
	}

	public Game play(int position, char player) {
		return new Game(this.board, position, player, i_boardSize);
	}

	public char winner() {
		if (board.charAt(0) != '-' 
            && board.charAt(0) == board.charAt(1) 
            && board.charAt(1) == board.charAt(2))
			return board.charAt(0);
		if (board.charAt(3) != '-' 
            && board.charAt(3) == board.charAt(4) 
            && board.charAt(4) == board.charAt(5))
			return board.charAt(3);
		if (board.charAt(6) != '-' 
            && board.charAt(6) == board.charAt(7) 
            && board.charAt(7) == board.charAt(8))
			return board.charAt(6);
		
		if (board.charAt(0) != '-' 
	            && board.charAt(0) == board.charAt(3) 
	            && board.charAt(3) == board.charAt(6))
				return board.charAt(0);
		if (board.charAt(1) != '-' 
	            && board.charAt(1) == board.charAt(4) 
	            && board.charAt(4) == board.charAt(7))
				return board.charAt(1);
		if (board.charAt(2) != '-' 
	            && board.charAt(2) == board.charAt(5) 
	            && board.charAt(5) == board.charAt(8))
				return board.charAt(2);
		return '-';
	}
}
