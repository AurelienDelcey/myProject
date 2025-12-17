package ticTacToe.Util;

import ticTacToe.DAO.ButtonState;
import ticTacToe.DAO.Grid;

/**
 *
 * @author aurélien
 */
public class Logic {
    
    private Grid grid;
    private GameStateHolder gameStateHolder;

    public Logic(Grid grid, GameStateHolder gameStateHolder) {
        this.grid = grid;
        this.gameStateHolder = gameStateHolder;
    }
    
    public void checkGrid(){
        GameState result = checkRows();
        if(result == GameState.CONTINUE){
            result = checkColumns();
            if(result==GameState.CONTINUE){
                result = checkDiagonals();
                if(result==GameState.CONTINUE){
                    if(this.grid.isFull()){
                        gameStateHolder.setState(GameState.NO_WINNER);
                        return;
                    }
                }
            }
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
}

