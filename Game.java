public class Game {
	public StringBuffer board;
	public int i_boardSize = 3;
	public Game(String s){
		board = new StringBuffer(s);
	
	}

	public Game(StringBuffer s, int position, char player, int boardSize) {
		board = new StringBuffer(s);
		board.append(s);
		board.setCharAt(position, player);
		i_boardSize = boardSize;
	}

	public int move(char player) {
		for (int i = 0; i < i_boardSize * i_boardSize; i++) {
			if (board.charAt(i) == '-') 
				return i;
		}	
		return -1;
	}
	
	public int winningMove(char player){
		for (int i = 0; i < i_boardSize * i_boardSize; i++) {
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
	
	public boolean checkWinnerRowsVertical(int startPosition)
	{
		for (int i = 0; i < (i_boardSize); i++)
		{
			if(board.charAt(startPosition) != board.charAt(startPosition + (i_boardSize * i)))
			{
				return false;
			}

		}
		return true;
	}
	
	public boolean checkWinnerRows(int startPosition)
	{
		for (int i = 0; i < (i_boardSize); i++)
		{
			if(board.charAt(startPosition) != board.charAt(startPosition + (i)))
			{
				return false;
			}

		}
		return true;
	}

	public char winner() {
		
		for (int i = 0; i < i_boardSize * i_boardSize; i++)
		{
			if((i % i_boardSize == 0) && board.charAt(i) != '-' && checkWinnerRows(i))
			{
					return board.charAt(i);
			}
			
			if(i < i_boardSize  && board.charAt(i) != '-' && checkWinnerRowsVertical(i))
			{
					return board.charAt(i);
			}

		}
		return '-';
	}
}
