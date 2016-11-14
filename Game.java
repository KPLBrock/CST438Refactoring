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
		
		for (int i = 0; i < i_boardSize; i++){
			if(i % 3 == 0 && board.charAt(i) != '-' 
				&& board.charAt(i) == board.charAt(i + 1) 
		        && board.charAt(i + 1) == board.charAt(i + 2))
				return board.charAt(i);
			
			if(i < 3 && board.charAt(i) != '-' 
					&& board.charAt(i) == board.charAt(i + 3) 
			        && board.charAt(i + 3) == board.charAt(i + 6))
					return board.charAt(i);

		}
		return '-';
	}
}
