package ticTacToe.Logic;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import ticTacToe.Model.Turn;

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

