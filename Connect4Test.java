
package Core;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * A JUnit4 Test implementation to test the Connect4 class in Core.
 * 
 * Completion Time: 21 November 2020
 * 
 * @author Roshan Bhimani
 * @version 1.0
 */
public class Connect4Test {
    private static Player Player1, Player2;
    private static char PieceX, PieceO;
    private static char[][] Board1, Board2;
    private static String PlayerOne, PlayerTwo;
    private static int boardrows, boardcolumns;
    private static Connect4 Game1, Game2; 
    private static int Testrow1 = 0, Testrow2 = 4;
    private static int Testcol1 = 0, Testcol2 = 4;
    
    
    
    
    public Connect4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        PlayerOne = "Roshan"; PlayerTwo = "OtherGuy";
        boardrows = 6; boardcolumns = 9;
        PieceX = 'X'; PieceO = 'O';
        Player1 = new Player(PlayerOne,PieceX);
        Player2 = new Player(PlayerTwo,PieceO);
        
        char temp = 'X';
        Game1 = new Connect4(PlayerOne, PlayerTwo, boardrows, boardcolumns);        
        for (int itr = 0; itr < boardcolumns; itr++){
            for (int itr2 = 0; itr2 < boardrows; itr2++){
            Game1.Gameboard()[itr2][itr] = temp;
            temp = changechar(temp);
            }            
        }
                
        Game2 = new Connect4(PlayerOne, PlayerTwo, boardrows, boardcolumns);
        for (int itr1 = Testrow1; itr1 < Testrow2; itr1++){
            Game2.Gameboard()[itr1][Testcol1] = PieceX;
        }
        for (int itr1 = Testcol1; itr1 < Testcol2; itr1++){
            Game2.Gameboard()[Testrow2][itr1] = PieceO;
        }        
        
        int itr1 = Testrow1, itr2 = Testcol2, itr = 0;
        while (itr < 4){
            Game2.Gameboard()[itr1++][itr2++] = PieceX;
            itr++;
        }
        itr1 = Testrow2; itr2 = Testcol1; itr = 0;
        while (itr < 4){
            Game2.Gameboard()[itr1--][itr2++] = PieceO;
            itr++;
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        Player1 = null; Player2 = null;
        Board1 = null; Board2 = null;
        PlayerOne = null; PlayerTwo = null;
        Game1 = null; Game2 = null; 
    }

    /**
     * Test of ChooseMove method, of class Connect4.
     */
    @Test
    public void testChooseMove() {
    }

    /**
     * Test of placepiece method, of class Connect4.
     */
    @Test
    public void testPlacepiece() {
        int temp = -1, Test;
        Test = Game1.placepiece(PieceX, -1);
        assertEquals(Test, temp);
        Test = Game1.placepiece(PieceX, 0);
        assertEquals(Test, temp);
        Test = Game1.placepiece(PieceX, 9);
        assertEquals(Test, temp);
        
        Test = Game2.placepiece(PieceO, -1);
        assertEquals(Test, temp);
        Test = Game2.placepiece(PieceO, 0);
        assertNotEquals(Test, temp);
        Test = Game2.placepiece(PieceO, 9);
        assertEquals(Test,temp);
    }

    /**
     * Test of IsConnect4 method, of class Connect4.
     */
    @Test
    public void testIsConnect4() {
        assertTrue(Game2.IsConnect4(Testrow1+3, Testcol1));
        assertTrue(Game2.IsConnect4(Testrow2, Testcol1));
        assertTrue(Game2.IsConnect4(Testrow2, Testcol1));
        assertTrue(Game2.IsConnect4(Testrow2, Testcol2));
        
        assertFalse(Game1.IsConnect4(Testrow1, Testcol1));
        assertFalse(Game1.IsConnect4(Testrow2, Testcol2));
    }

    /**
     * Test of IsDraw method, of class Connect4.
     */
    @Test
    public void testIsDraw() {
        assertTrue(Game1.IsDraw());
        assertFalse(Game2.IsDraw());
    }

    /**
     * Test of FirstPlayer method, of class Connect4.
     */
    @Test
    public void testFirstPlayer() {
        Player1 = Game1.FirstPlayer();
        assertEquals(Game1.FirstPlayer(), Player1);
        assertNotEquals(Game1.SecondPlayer(), Player1);
    }

    /**
     * Test of SecondPlayer method, of class Connect4.
     */
    @Test
    public void testSecondPlayer() {
        Player2 = Game2.SecondPlayer();
        assertEquals(Game2.SecondPlayer(), Player2);
        assertNotEquals(Game2.FirstPlayer(), Player2);
    }

    /**
     * Test of Gameboard method, of class Connect4.
     */
    @Test
    public void testGameboard() {
        Board1 = Game1.Gameboard();
        Board2 = Game2.Gameboard();
        assertArrayEquals(Game1.Gameboard(), Board1);
        assertArrayEquals(Game2.Gameboard(), Board2);        
    }

    /**
     * Test of SwitchPlayer method, of class Connect4.
     */
    @Test
    public void testSwitchPlayer() {
        Player Test, Current = Game1.FirstPlayer();
        Test = Game1.SwitchPlayer(Current);
        assertEquals(Game1.SecondPlayer(), Test);
        Current = Game1.SecondPlayer();
        Test = Game1.SwitchPlayer(Current);
        assertEquals(Game1.FirstPlayer(), Test);
    }
    
    private static char changechar(char current)    {
        if (current == PieceX){
            return PieceO;
        }
        else if (current == PieceO){
            return 'U';
        }
        else if (current == 'U'){
            return 'T';
        }
        else {
            return PieceX;
        }
    }
}