import java.util.ArrayList;

/**
 * A Java tool to draw brick walls
 * 
 * @author Milan Palmer
 */
public class BrickWall
{
    private int wallHeight;
    private int wallWidth;

    private String[] colors;
    private int currentColor;
    
    private int brickWidth; // individual brick width
    private int brickHeight; // individual brick height
    
    private int startx; // starting x co ordinate
    private int starty; // starting y co ordinate
    
    private int Height; // drawWall height
    private int Length; // drawWall length

    private ArrayList<Rectangle> bricks;

    private boolean itsDecreasing; // true or false method for decreasing
    private boolean itsSymmetrical; // true or false method for symmetrical
    private boolean itsMulticoloured; // true or false method for multicoloured

    //complete with remaining field declarations
    /**
     * Constructor for objects of class BrickWall.
     * @param rows The number of rows in the wall
     * @param rowlen The maximum number of bricks in a row
     */
    public BrickWall(int wallHeight, int wallWidth)
    {
        setUpColors();
        currentColor = 0;
        brickWidth = 52;
        brickHeight = 15;
        startx = 20; // start as requested
        starty = 500; // start as requested
        Length = 24; // max 24 brick wide
        Height = 31; // max 31 bricks high

        bricks = new ArrayList<Rectangle>();
        this.wallHeight = wallHeight;
        this.wallWidth = wallWidth;
        itsMulticoloured = true; // relevant true or false for above
        itsDecreasing = true; // relevant true or false for above
        itsSymmetrical = true; // relevant true or false for above

    }

    private void setUpColors() {
        colors = new String[6];
        colors[0] = "red";
        colors[1] = "yellow";
        colors[2] = "blue";
        colors[3] = "green";
        colors[4] = "magenta";
        colors[5] = "black";    
    }

    /**
     * Draw the wall.  The first brick will be positioned at the coordinates (10, 550).  
     * The number of bricks in a row is specified by setRowLength().  The maximum number of rows
     * is specified by setNumRows().  If decrease is true, each subsequent row of bricks 
     * contains one brick less than the previous row.  If symmetric is true AND decrease is true then
     * the wall is pyramid shaped.  If symmetric is false AND decrease is true then the wall is shaped
     * like a right angle triangle.
     */
    public void draw()
    {
        drawWall(startx,starty,Height,Length); // taken from above

    }

    public void drawBrick(int x, int y)
    {
        Rectangle brick = new Rectangle(brickWidth, brickHeight);
        brick.setPosition(x,y); // always at position requested
        brick.changeColor (colors[currentColor]);
        brick.makeVisible();
        bricks.add (brick);
    }

    public void drawRow (int x, int y, int Length){
        for (int index=0;index<Length; index++){
            int xPosistion= startx + (brickWidth * index);
            drawBrick (xPosistion, y);
            if (itsMulticoloured) {
                nextColour();
            }

        }

    }

    public void drawWall(int x, int y, int Height, int Length) {
        if (Length <= 24 || Height <=31);{ // max parameters allowed
            // I tried to issue a 'print' for this, saying 'Choose within parameters' when people had not chosen correct
            // for some reason my print method then stopped this working, e.g. it printed my text
            // but people could then size it however they wanted
            int currentLength=Length;

            for (int index=0;index<Height; index++){
                int yPosition = starty - (brickHeight * index);
                drawRow (startx, yPosition, currentLength);

                if (itsDecreasing){
                    currentLength--;

                    if (itsSymmetrical){
                        startx = startx + (brickWidth/2);
                    }
                }
            }
        }
    }


    public void decrease(){ // as above
        itsDecreasing = !itsDecreasing;
    }

    public void symmetrical(){ // as above
        itsSymmetrical = !itsSymmetrical;
    }

    public void eraseWall() { // method below, so don't need to restart bluej to erase
        Canvas canvas = Canvas.getCanvas();

        for (int index = 0; index < bricks.size(); index++) {
            canvas.erase(bricks.get(index));
        }
        bricks = new ArrayList<Rectangle>();
    }

    public void toggleMulticolour (){ // as above, choosing multicolored
        itsMulticoloured = !itsMulticoloured;
    }

    public void nextColour(){
        currentColor++;

        if (currentColor == colors.length) {
            currentColor = 0;
        }
    }

    /**
     * Accessor for the colors array
     */
    public String[] getColors(){
        return colors;
    }
}
