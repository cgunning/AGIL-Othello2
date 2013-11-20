package kth.game.othello;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import junit.framework.Assert;
import kth.game.othello.board.Node;
import kth.game.othello.board.OthelloBoard;
import kth.game.othello.player.HumanPlayer;

import org.junit.Test;
/**
 * Test the whole Othello implementation
 * @author Nils Dahlbom Norgren, Christoffer Gunning
 *
 */
@SuppressWarnings("deprecation")
public class OthelloTest {

	/**
	 * Method to create a mocked board with mocked nodes, all nodes are marked.
	 * @return Mocked board with all nodes marked
	 */
	private OthelloBoard createBoard() {
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		for(int i = 0; i < 64; i++) {
			Node node = mock(Node.class);
			when(node.isMarked()).thenReturn(true);
			nodes.add(node);
		}
		
		OthelloBoard board = mock(OthelloBoard.class);
		when(board.getNodes()).thenReturn(nodes);
		return board;
	}
	
	/**
	 * 
	 */
	@Test
	public void testOthello() {
		//OthelloBoard board = createBoard();
		OthelloBoard board = new OthelloBoard(8);
		HumanPlayer p1 = new HumanPlayer("Black");
		HumanPlayer p2 = new HumanPlayer("White");
		OthelloImpl othello = new OthelloImpl(p1, p2, board);
		othello.start(p1.getId());
		Assert.assertEquals(64, othello.getBoard().getNodes().size());
		Assert.assertEquals(true, othello.isMoveValid(p2.getId(), "2:3"));
		Assert.assertEquals(false, othello.isMoveValid(p1.getId(), "2:3"));
		Assert.assertEquals(true, othello.hasValidMove(p2.getId()));
		Assert.assertEquals(true, othello.hasValidMove(p1.getId()));
		
		OthelloBoard board2 = createBoard();
		
		OthelloImpl othello2 = new OthelloImpl(p1, p2, board2);
		Assert.assertEquals(false, othello2.isActive());
		
	}
	
	
}
