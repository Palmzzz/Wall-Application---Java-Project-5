

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class BrickWallTest.
 *
 * @author  Milan Palmer
 */
public class BrickWallTest
{
    /**
     * Default constructor for test class BrickWallTest
     */
    public BrickWallTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    /**
     * This test checks that the color array has been correctly
     * created and is of the intended length.
     */
    @Test
    public void checkColorsArrayLength(){
        BrickWall wall = new BrickWall(3, 5);
        assertNotNull(wall.getColors());
        assertEquals(6, wall.getColors().length);
    }
    
    
    /**
     * This test checks some of the content of the color array 
     * to verify that it contains the names of colours as expected.
     */
    @Test
    public void checkColorsArrayContent(){
        BrickWall wall = new BrickWall(3, 5);
        assertNotNull(wall.getColors());
        /* 
         * Local reference to the colors array to make code easier
         * to read.
         * English spelling for readability.
         */
        String[] colours = wall.getColors();
        
        assertEquals("red", colours[0]);
        assertEquals("blue", colours[2]);
        assertEquals("black", colours[5]);
    }
    
        
}
