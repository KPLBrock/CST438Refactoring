import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {
	@Test
	public void testDefaultMove() {
		Game game = new Game("XOXOX-OXO");
		assertEquals(5, game.move('X'));

		game = new Game("XOXOXOOX-");
		assertEquals(8, game.move('O'));

		game = new Game("---------");
		assertEquals(0, game.move('X'));

		game = new Game("XXXXXXXXX");
		assertEquals(-1, game.move('X'));
	}

	@Test
	public void testFindWinningMove() {
		Game game = new Game("XO-XX-OOX");
		assertEquals(5, game.winningMove('X'));
	}

	@Test
	public void testWinConditions() {
		Game game = new Game("---XXX---");
		assertEquals('X', game.winner());
	}
	
	@Test
	public void testVerticalWinConditions(){
		Game game = new Game("-X--X--X-");
		assertEquals('X', game.winner());
	}
	
	@Test
	public void testSizedGameBoards(){
		StringBuffer board = new StringBuffer("-X-X");
		Game game = new Game(board, 0, '-', 2);
		assertEquals('X', game.winner());
		
		board = new StringBuffer("-X-X-X-X-X-X-X-X");
		game = new Game(board, 0, '-', 4);
		assertEquals('X', game.winner());
	}
}