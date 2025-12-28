package ticTacToe.Model;


public class Grid {
    
    private ButtonState grid[][];
    private int size;
    
    public Grid(int size){
        this.size = size;
        this.grid = new ButtonState[size][size];
        this.init();
    }
    
    public void init(){
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                this.grid[i][j]=ButtonState.EMPTY;
            }
        }
    }
    
    public ButtonState get(int x, int y){
        return this.grid[x][y];
    }
    
    public void set(int x, int y, ButtonState status){
        this.grid[x][y]=status;
    }
    
    public int size(){
        return this.size;
    }
    public boolean isFull(){
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                if(this.grid[i][j]==ButtonState.EMPTY){
                    return false;
                }
            }
        }
        return true;
    }
}
