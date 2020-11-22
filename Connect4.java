package Core;
import java.util.Scanner;

/**
 * Class which contains a Connect Four Game. This class can activate and 
 * manage the game but not display it.
 * 
 * Completion Time: 8 November 2020
 * 
 * @author Roshan
 * @version 1.8
 * 

 */


public class Connect4 {

    /**
     * @param boardrows holds the width of the game board. Final
     * @param boardcolumns holds the height of the game board. Final
     */
    private final char FirstPlayerPiece = 'X';
    private final char SecondPlayerPiece = 'O';
    protected final int boardrows;
    protected final int boardcolumns;
    /**
     * GameBoard is a 2D array of chars representing this connect4 game board.
     */
    public char[][] GameBoard;
    private Player PlayerX;
    private Player PlayerO;
    
    /**
     * Custom constructor for Connect4 class.
     * 
     * @param X_Piece_Player First Player name in String format
     * @param O_Piece_Player Second Player name in String format
     * @param rows The height of this board
     * @param column The width of this board 
     */
    public Connect4(String X_Piece_Player, String O_Piece_Player, int rows, int column){
        PlayerX = new Player(X_Piece_Player, FirstPlayerPiece);
        PlayerO = new Player(O_Piece_Player, SecondPlayerPiece);
        boardrows = rows;
        boardcolumns = column;
        GameBoard = new char[boardrows][boardcolumns];
        for (int row = 0; row < boardrows; row++){
            for (int col = 0; col < boardcolumns; col++){
                GameBoard[row][col] = ' ';
            }
        }
    }
    
    /**
     * The means to make a move on the board.
     * 
     * @param Input Scanner obj used by player to choose a move
     * @param Current The current player who must make this move
     * @return The chosen column within board bounds.
     */
    public int ChooseMove(Scanner Input, Player Current){
        int output;
        
        System.out.println(Current.PlayerName() + ", Enter a column number");
        output = Input.nextInt();
        
        while (output < 1 || output > boardcolumns){
            System.out.println("Invalid column number, Please enter a number "
                    + "between 1 and " + boardcolumns);
            output = Input.nextInt();
        }
        
        return output - 1;        
    }    
    
    /**
     * Places a piece on the game board, which is an array in implementation.
     * 
     * @param Piece Refers to the current piece being placed
     * @param column The column the player chose for their piece
     * @return an int for the row where the piece landed. 
     * In the event the column is full, return is -1
     * @throws ArrayIndexOutOfBoundsException In the event the player chooses
     * a non-existent column. 
     */
    public int placepiece(char Piece, int column) throws ArrayIndexOutOfBoundsException{
        try {
            for (int itr = 0; itr < boardrows; itr++){
                if (GameBoard[itr][column] == ' '){
                    GameBoard[itr][column] = Piece;
                        return itr;
                    }
                }
            }        
        catch (ArrayIndexOutOfBoundsException e) {
            return -1;
        }
        return -1;
    }
    
    /**
     * Checks whether the game's win condition has been met by the last move made.
     * 
     * @param row The row where the last move made landed
     * @param column The column where the last move landed
     * @return Returns true or false based on connect four win conditions.
     */
    public boolean IsConnect4(int row, int column){
        boolean output = false;
        
        if (!output){
            output = isVertical4(row,column);
        }        
        if (!output){
            output = isHorizontal4(row,column);
        }
        if (!output){
            output = isDiagonalR4(row,column);
        }
        if (!output){
            output = isDiagonalL4(row,column);
        }
        
        return output;
    }
    
    /**
     * A private method called by IsConnect4 to check if the last move resulted
     * in a connect 4 in a vertical line.
     * 
     * @param row The row of where the last move landed
     * @param column The column of where the last move landed
     * @return True if there is 4 in a vertical line
     */
    private boolean isVertical4(int row, int column){
        char Piece = GameBoard[row][column];
        char contents[] = new char[4];
        int rowItr = row, colItr = column;
        
        String WinCondition = "" + Piece + Piece + Piece + Piece;        
        
        for (int itr = 0; itr < 4; itr++){
            if (rowItr > -1 && rowItr < boardrows){
                contents[itr] = GameBoard[rowItr][colItr];
            }
            else {
                contents[itr] = ' ';
            }
            rowItr--;
        }        
        
        String compare = String.copyValueOf(contents);        
        boolean output = compare.contains(WinCondition); 
        return output;
    }
    
    /**
     * A private method called by IsConnect4 to check if the last move resulted
     * in a connect 4 on the horizontal line.
     * 
     * @param row The row of where the last move landed
     * @param column The column of where the last move landed
     * 
     * @return True if there is 4 on the horizontal line
     */
    private boolean isHorizontal4(int row, int column){
        char Piece = GameBoard[row][column];
        char contents[] = new char[7];
        int rowItr = row, colItr = column - 3;
        
        String WinCondition = "" + Piece + Piece + Piece + Piece;        
        
        for (int itr = 0; itr < contents.length; itr++){
            if (colItr > -1 && colItr < boardcolumns){
                contents[itr] = GameBoard[rowItr][colItr];
            }
            else {
                contents[itr] = ' ';
            }
            colItr++;
        }        
        
        String compare = String.copyValueOf(contents);        
        boolean output = compare.contains(WinCondition); 
        return output;
    }
    
    /**
     * A private method called by IsConnect4 to check if the last move resulted
     * in a connect 4 in a right bound diagonal (from bottom left to upper right)
     * 
     * @param row The row of where the last move landed
     * @param column The column of where the last move landed
     * 
     * @return True if there is 4 on the diagonal
     */    
    private boolean isDiagonalR4(int row, int column){
        char Piece = GameBoard[row][column];
        char contents[] = new char[7];
        int rowItr = row - 3, colItr = column - 3;
        
        String WinCondition = "" + Piece + Piece + Piece + Piece;        
        
        for (int itr = 0; itr < contents.length; itr++){
            if ((colItr > -1 && colItr < 7) && (rowItr > -1 && rowItr < 6)) {
                contents[itr] = GameBoard[rowItr][colItr];
            }
            else {
                contents[itr] = ' ';
            }
            rowItr++;
            colItr++;
        }        
        
        String compare = String.copyValueOf(contents);        
        boolean output = compare.contains(WinCondition); 
        return output;
    }
    
    /**
     * A private method called by IsConnect4 to check if the last move resulted
     * in a connect 4 in a left bound diagonal (from top left to bottom right)
     * 
     * @param row The row of where the last move landed
     * @param column The column of where the last move landed
     * 
     * @return True if there is 4 on the diagonal
     */        
    private boolean isDiagonalL4(int row, int column){
        char Piece = GameBoard[row][column];
        char contents[] = new char[7];
        int rowItr = row + 3, colItr = column - 3;
        
        String WinCondition = "" + Piece + Piece + Piece + Piece;        
        
        for (int itr = 0; itr < contents.length; itr++){
            if ((colItr > -1 && colItr < 7) && (rowItr > -1 && rowItr < 6)) {
                contents[itr] = GameBoard[rowItr][colItr];
            }
            else {
                contents[itr] = ' ';
            }
            rowItr--;
            colItr++;
        }        
        
        String compare = String.copyValueOf(contents);        
        boolean output = compare.contains(WinCondition); 
        return output;
    }
    
    /**
     * Checks whether Connect-four's draw conditions have been met.
     * 
     * @return True if the last move ends the game in a draw, false otherwise
     */
    public boolean IsDraw(){
        for (int col = 0; col < boardcolumns; col++){
            if (GameBoard[boardrows-1][col] == ' '){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Access method for first player. Default char for first player is 'X'
     * 
     * @return Player Obj for PlayerX
     */
    public Player FirstPlayer(){
        return PlayerX;
    }
    
    /**
     * Access method for second player. Default char for second player is 'O'
     * 
     * @return Player Obj for PlayerO
     */
    public Player SecondPlayer(){
        return PlayerO;
    }
    
    /**
     * Access method for this game's board.
     * @return 2D char array of this board.
     */
    public char[][] Gameboard(){
        return GameBoard;
    }
    
    /**
     * Helper method to switch active player between the two players of the game
     * 
     * @param Current Refers to who's turn it was.
     * @return The player who's turn it is now.
     */
    public Player SwitchPlayer(Player Current){
        if (Current.PlayerPiece() == SecondPlayerPiece){
            return PlayerX;
        }
        else {        
            return PlayerO;
        }
    }
}
