package ticTacToe.Logic;

import ticTacToe.Model.Grid;
import ticTacToe.Model.GameState;
import ticTacToe.Model.ButtonState;
import ticTacToe.Model.Turn;

public class TicTacToeLogic {
    
    private Grid grid;
    private GameStateHolder gameStateHolder;
    private TurnStateHolder turnStateHolder;

    public TicTacToeLogic(Grid grid, GameStateHolder gameStateHolder, TurnStateHolder turnStateHolder) {
        this.grid = grid;
        this.gameStateHolder = gameStateHolder;
        this.turnStateHolder = turnStateHolder;
    }
    
    public void checkGrid(){
        GameState result = checkRows();
        
        if(result != GameState.CONTINUE){
            gameStateHolder.setState(result);
            return;
        }
        
        result = checkColumns();
        if(result != GameState.CONTINUE){
            gameStateHolder.setState(result);
            return;
        }
        
        result = checkDiagonals();
        if(result != GameState.CONTINUE){
            gameStateHolder.setState(result);
            return;
        }
        
        if(grid.isFull()){
            gameStateHolder.setState(GameState.NO_WINNER);
            return;
        }
        
        gameStateHolder.setState(result);
    }
    
    private GameState checkRows(){
        int count = 0;
        
        for(int i=0; i<grid.size(); i++){
            count=0;
            for(int j=0; j<grid.size(); j++){
                if(grid.get(i, j)==ButtonState.CIRCLE){
                    count++;
                }else if(grid.get(i, j)==ButtonState.CROSS){
                    count--;
                }
            }
            if(count == grid.size()){
                return GameState.VICTORY_O;
            }else if(count == -grid.size()){
                return GameState.VICTORY_X;
            }
        }
        
        return GameState.CONTINUE;
    }
    
    private GameState checkColumns(){
        int count = 0;
        
        for(int i=0; i<grid.size(); i++){
            count=0;
            for(int j=0; j<grid.size(); j++){
                if(grid.get(j, i)==ButtonState.CIRCLE){
                    count++;
                }else if(grid.get(j, i)==ButtonState.CROSS){
                    count--;
                }
            }
            if(count == grid.size()){
                return GameState.VICTORY_O;
            }else if(count == -grid.size()){
                return GameState.VICTORY_X;
            }
        }
        
        return GameState.CONTINUE;
    }
    
    private GameState checkDiagonals(){
        int count = 0;
        
        for(int i=0; i<grid.size(); i++){
            if(grid.get(i, i)==ButtonState.CIRCLE){
                count++;
            }else if(grid.get(i, i)==ButtonState.CROSS){
                count--;
            }
            
            if(count == grid.size()){
                return GameState.VICTORY_O;
            }else if(count == -grid.size()){
                return GameState.VICTORY_X;
            }
        }
        
        count = 0;
        
        for(int i=grid.size()-1; i>=0; i--){
            if(grid.get(i, grid.size()-1-i)==ButtonState.CIRCLE){
                count++;
            }else if(grid.get(i, grid.size()-1-i)==ButtonState.CROSS){
                count--;
            }
            
            if(count == grid.size()){
                return GameState.VICTORY_O;
            }else if(count == -grid.size()){
                return GameState.VICTORY_X;
            }
        }
        
        return GameState.CONTINUE;
    }
    
    public void resetGrid(){
        grid.init();
        turnStateHolder.setTurn(Turn.O_TURN);
    }
}
