package Core;

import org.junit.*;
import static org.junit.Assert.*;

/** 
 * A JUnit4 Test class implementation to test the Player class in Core
 * 
 * Completion Time: 21 November 2020
 *  *
 * @author Roshan Bhimani
 * @version 1.0
 */
public class PlayerTest {
    private static String LiteralName, VarName, InputName;
    private static char PieceX, PieceO;
    private static Player PlayerOne, PlayerTwo, Computer;     
    
    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        LiteralName = "Roshan"; VarName = "Marissa"; InputName = "Alex";
        PieceX = 'X'; PieceO = 'O';
        
        String temp = "Marissa";
        PlayerOne = new Player("Roshan", 'X');
        
        PlayerTwo = new Player(temp, 'X');
        
        
        String tempInput = InputName;
        Computer = new Player(tempInput, 'O');
        Computer.setComputer(true);
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        LiteralName = null; VarName = null; InputName = null;
        PieceX = ' '; PieceO = ' '; 
        PlayerOne = null; PlayerTwo = null; Computer = null;        
    }
    
    /**
     * Test of PlayerName method, of class Player.
     */
    @Test
    public void testPlayerName() {
        assertTrue(PlayerOne.PlayerName().equals(LiteralName));
        assertTrue(PlayerTwo.PlayerName().equals(VarName));
        assertTrue(Computer.PlayerName().equals(InputName));
    }

    /**
     * Test of PlayerPiece method, of class Player.
     */
    @Test
    public void testPlayerPiece() {
        assertEquals(PlayerOne.PlayerPiece(), PieceX);
        assertEquals(PlayerTwo.PlayerPiece(), PieceX);
        assertEquals(Computer.PlayerPiece(), PieceO);
    }

    /**
     * Test of setComputer method, of class Player.
     */
    @Test
    public void testSetComputer() {
        Computer.setComputer(true);
        assertTrue(Computer.ComputerState());
        Computer.setComputer(false);
        assertFalse(Computer.ComputerState());
        Computer.setComputer(true);
    }

    /**
     * Test of ComputerState method, of class Player.
     */
    @Test
    public void testComputerState() {
        assertFalse(PlayerOne.ComputerState());
        assertFalse(PlayerTwo.ComputerState());
        assertTrue(Computer.ComputerState());
    }
}