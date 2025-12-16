/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ticTacToe.Util;

/**
 *
 * @author aurélien
 */
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import ticTacToe.UserInterface.Turn;

public class TurnStateHolder {
    private ObjectProperty<Turn> turn = new SimpleObjectProperty<>(Turn.O_TURN);

    public ObjectProperty<Turn> turnProperty() {
        return turn;
    }

    public Turn getTurn() {
        return turn.get();
    }

    public void setTurn(Turn newTurn) {
        turn.set(newTurn);
    }
}

