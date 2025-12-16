package ticTacToe.UserInterface;

/**
 *
 * @author aurélien
 */

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ticTacToe.DAO.ButtonState;
import ticTacToe.DAO.Grid;
import ticTacToe.Util.*;


public class UserInterface extends Application{
    
    private Logic logic;
    private Grid grid;
    private TurnStateHolder turnStateHolder;
    private GameStateHolder gameStateHolder;

    public void init() {
        this.turnStateHolder = new TurnStateHolder();
        this.gameStateHolder = new GameStateHolder();
        this.turnStateHolder.setTurn(Turn.O_TURN);
        this.gameStateHolder.setState(GameState.CONTINUE);
        this.grid = new Grid(3);
        this.logic = new Logic(this.grid, this.gameStateHolder);
    }
    
    
    public void start(Stage stage){
        
        BorderPane layout = new BorderPane();
        
        GridPane graphicGrid = gridFactory(this.grid.size());
        
        Label turnMessage = new Label("Turn: O");
        turnMessage.setAlignment(Pos.CENTER);
        turnMessage.setFont(Font.font("Monospaced", 30));
        
        turnStateHolder.turnProperty().addListener((obs, oldTurn, newTurn) -> {
            turnMessage.setText("Turn: " + (newTurn == Turn.O_TURN ? "O":"X"));
        });
        gameStateHolder.gameStateProperty().addListener((change,old,newState)->{
            switch(newState){
                case NO_WINNER :
                    turnMessage.setText("DRAW");
                    disableButtons(graphicGrid);
                    break;
                case VICTORY_O :
                    turnMessage.setText("O is the winner!");
                    disableButtons(graphicGrid);
                    break;
                case VICTORY_X :
                    turnMessage.setText("X is the winner!");
                    disableButtons(graphicGrid);
                    break;
                default :
                    break;
            }
        });
        
        graphicGrid.setPrefSize(400, 400);
        graphicGrid.setAlignment(Pos.CENTER);
        graphicGrid.setVgap(10);
        graphicGrid.setHgap(10);
        
        layout.setTop(turnMessage);
        layout.setCenter(graphicGrid);
        
        Scene scene = new Scene(layout);
        stage.setScene(scene);
        stage.show();
        
    }
    
    private GridPane gridFactory(int size){
        GridPane result = new GridPane();
        
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                Button button = new Button();
                final int row = i;
                final int col = j;
                
                button.setOnAction(e->buttonReaction(row, col, button));
                button.setFont(Font.font("Monospaced", 40));
                button.setPrefSize(80, 80);
                result.add(button,i,j); 
            }
        }
        
        return result;
    }
        
    private void buttonReaction(int row, int col, Button button){
        
        if(this.grid.get(row, col)!=ButtonState.EMPTY){
            return;
        }
        
        if(this.turnStateHolder.getTurn() == Turn.O_TURN){
            button.setText("O");
            this.grid.set(row,col,ButtonState.CIRCLE);
            this.turnStateHolder.setTurn(Turn.X_TURN);
        }else if(this.turnStateHolder.getTurn() == Turn.X_TURN){
            button.setText("x");
            this.grid.set(row,col,ButtonState.CROSS);
            this.turnStateHolder.setTurn(Turn.O_TURN);
        }
        
        this.logic.checkGrid();
    }
    
    private void disableButtons(GridPane graphicGrid){
        graphicGrid.getChildren().stream()
                .filter(i->i instanceof Button)
                .map(i->(Button)i)
                .forEach(i->i.setDisable(true));
    }
    
    
}

