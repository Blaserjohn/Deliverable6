package Core;

/**
 * Player class meant to contain a player's name and play piece. 
 * Separated into it's own file in the event the game board is expanded and 
 * multiple players need to be added with more attributes/behaviors. 
 * 
 * Has ability to initialize a player as a computer player.
 * 
 * Completion: 31 October 2020
 * 
 * @author Roshan
 * @version 1.5
 */

public class Player {
    private final String PlayerName;
    private char Piece;
    private boolean ComputerState;
    
    /**
     * Custom constructor for this class. Initializes the variables with passed
     * values. Default player is a human player.
     * 
     * @param Name Name of player in string format
     * @param AssignedPiece This player's assigned play piece (cannot be 'X')
     */
    public Player(String Name, char AssignedPiece){
        PlayerName = Name;
        Piece = AssignedPiece;
        ComputerState = false;
    }
    
    /**
     * Access method for player's name
     * @return PlayerName
     */
    public String PlayerName(){
        return PlayerName;
    }
    
    /**
     * Access method for player's piece. Used when checking for win condition
     * and switching between players.
     * 
     * @return PlayerPiece
     */
    public char PlayerPiece(){
        return Piece;
    } 
    
    /**
     * Modifier method for player's computer state. Used in 
     * Connect4ComputerPlayer games. 
     * 
     * @param state Passing true designates this player as a computer. 
     * Default is false.
     */
    public void setComputer(boolean state){
        ComputerState = state;
    }
    
    /**
     * Access method to check if this player is a computer
     * @return true if this player is a computer. false otherwise.
     */
    public boolean ComputerState(){
        return ComputerState;
    }
}
    