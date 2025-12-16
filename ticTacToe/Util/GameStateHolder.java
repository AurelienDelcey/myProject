/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe.Util;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author aurélien
 */
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
