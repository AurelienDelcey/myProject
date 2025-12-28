package ticTacToe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import ticTacToe.Logic.GameStateHolder;
import ticTacToe.Logic.TicTacToeLogic;
import ticTacToe.Logic.TurnStateHolder;
import ticTacToe.Model.ButtonState;
import ticTacToe.Model.GameState;
import ticTacToe.Model.Grid;
import ticTacToe.Model.Turn;

class TicTacToeLogicTest {
	
	private TicTacToeLogic logicToTest;
	private GameStateHolder gameState;
	private TurnStateHolder turnState;
	
	@Mock
	Grid mockedGrid;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		gameState = new GameStateHolder();
		turnState = new TurnStateHolder();
		logicToTest = new TicTacToeLogic(mockedGrid,gameState,turnState);
	}
	
	@Test
	void EmptyGrid_setGameStateHolderToContinue_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.CONTINUE,gameState.getState());
		
	}
	
	@Test
	void FullGrid_setGameStateHolderToNoWinner_CheckGridTest() {
		when(mockedGrid.get(0, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 0)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(2, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(0, 1)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(0, 2)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 1)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(2, 2)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.isFull()).thenReturn(true);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.NO_WINNER,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnFirstRows_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnSecondRows_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnThirdRows_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	@Test
	void victoryCircleOnFirstRows_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 0)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(1, 0)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(2, 0)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_O,gameState.getState());
		
	}
	
	@Test
	void victoryCircleOnSecondRows_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 1)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(2, 1)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_O,gameState.getState());
		
	}
	
	@Test
	void victoryCircleOnThirdRows_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 2)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(1, 2)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(2, 2)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_O,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnFirstColumn_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(0, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(0, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnSecondColumn_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(1, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnThirdColumn_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(2, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnFirstDiagonal_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	
	@Test
	void victoryCrossOnSecondDiagonal_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 2)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.get(2, 0)).thenReturn(ButtonState.CROSS);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_X,gameState.getState());
		
	}
	
	@Test
	void victoryCircleOnFirstDiagonal_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 0)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(2, 2)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_O,gameState.getState());
		
	}
	
	@Test
	void victoryCircleOnSecondDiagonal_CheckGridTest() {
		when(mockedGrid.get(anyInt(), anyInt())).thenReturn(ButtonState.EMPTY);
		when(mockedGrid.get(0, 2)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(1, 1)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.get(2, 0)).thenReturn(ButtonState.CIRCLE);
		when(mockedGrid.isFull()).thenReturn(false);
		when(mockedGrid.size()).thenReturn(3);
		logicToTest.checkGrid();
		assertEquals(GameState.VICTORY_O,gameState.getState());
		
	}
	
	@Test
	void resetGrid_invokeInit() {
		logicToTest.resetGrid();
		verify(mockedGrid).init();
	}
	
	@Test
	void resetGrid_setTurnToO() {
		logicToTest.resetGrid();
		assertEquals(Turn.O_TURN, turnState.getTurn());
	}
}
