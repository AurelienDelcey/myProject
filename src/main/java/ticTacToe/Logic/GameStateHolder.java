package ticTacToe.Logic;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import ticTacToe.Model.GameState;

public class GameStateHolder {
    
    private ObjectProperty<GameState> gameStateHolder = new SimpleObjectProperty<>(GameState.CONTINUE);
    
    public ObjectProperty<GameState> gameStateProperty(){
        return this.gameStateHolder;
    }
    
    public GameState getState(){
        return this.gameStateHolder.get();
    }
    
    public void setState(GameState newState){
        this.gameStateHolder.set(newState);
    }
}
