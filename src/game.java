package game;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author powea5594
 */
public class game extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 1000;
    static final int HEIGHT = 800;
    //Title of the window
    String title = "My Game";
    // sets the framerate and delay for our game
    // this calculates the number of milliseconds per frame
    // you just need to select an approproate framerate
    int desiredFPS = 60;
    int desiredTime = Math.round((1000 / desiredFPS));
    // timer used to run the game loop
    // this is what keeps our time running smoothly :)
    Timer gameTimer;
    // YOUR GAME VARIABLES WOULD GO HERE
    //background colour (green/blue)
    Color background = new Color(8, 170, 170);
    // costom font type and size
    Font boldFont = new Font("arial", Font.BOLD, 27);
    //create variable for character that will go through the maze
    Rectangle player = new Rectangle(980, 780, 15, 15);
    //create booleans for player movement       
    boolean playerUp = false;
    boolean playerDown = false;
    boolean playerLeft = false;
    boolean playerRight = false;
    // speed of player
    int playerSpeed = 4;
    // create rectange for the red end square
    Rectangle end = new Rectangle(0, 0, 30, 30);
    //booleans for winning and losing the game
    boolean win = false;
    boolean lose = false;
    //colour for text on the win game + end game screen
    Color text = new Color(88, 211, 211);
    //set custom texts
    Font winner = new Font("arial", Font.BOLD, 150);
    Font playAgain = new Font("arial", Font.BOLD, 70);
    Font welcome = new Font("arial", Font.BOLD, 80);
    Font controls = new Font("arial", Font.BOLD, 20);
    //create rectangles for the yes and no options
    Rectangle yes = new Rectangle(600, 450, 50, 50);
    Rectangle no = new Rectangle(600, 550, 50, 50);
    //rectangles fpr enter maze and exit
    Rectangle exit = new Rectangle(700, 700, 300, 100);
    Rectangle enter = new Rectangle(0, 700, 530, 100);
    //loose game options
    Rectangle quitGame = new Rectangle(180, 350, 60, 60);
    Rectangle tryAgain = new Rectangle(180, 550, 60, 60);
    //mouse variables for end game screen
    int mouseX = 0;
    int mouseY = 0;
    // randomly generate the x and y coordinates of the growing rectangles
    int xPosition = (int) (Math.random() * (1000 - 1 + 1)) + 1;
    int yPosition = (int) (Math.random() * (800 - 1 + 1)) + 1;
    //make array to save randomly generated numbers
    int[] xPosArray = new int[20];
    int[] yPosArray = new int[20];
    //make rectangles that make player larger 
    Rectangle[] bigRecs = new Rectangle[10];
    //create boolean to rneder the rectangles
    boolean[] lRenderable = new boolean[10];
    //make rectangles that make player smaller 
    Rectangle[] smallRecs = new Rectangle[10];
    //create another boolean to render the smaller squares
    boolean[] sRenderable = new boolean[10];
    //maze colour
    Color maze = new Color(2, 105, 107);
    //smaller colour
    Color smaller = new Color(205, 241, 241);
    //arger colour
    Color larger = new Color(0, 250, 255);
    List<Block> list = new ArrayList<Block>();
    List<Block> upDownList = new ArrayList<Block>();
    List<Block> sidewaysList = new ArrayList<Block>();
    //boolean for start screen
    boolean start = true;
    //create boolean to stop geneation of grow larger square/only 10 times
    boolean allGenerated = false;
    JFrame frame;
    static game game;
    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)

    public game() {
        preSetup();
        // creates a windows to show my game
        frame = new JFrame(title);

        // sets the size of my game
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        // adds the game to the window
        frame.add(this);

        // sets some options and size of the window automatically
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        // shows the window to the user
        frame.setVisible(true);

        // add listeners for keyboard and mouse
        frame.addKeyListener(new Keyboard());
        Mouse m = new Mouse();
        this.addMouseMotionListener(m);
        this.addMouseWheelListener(m);
        this.addMouseListener(m);

        gameTimer = new Timer(desiredTime, this);
        gameTimer.setRepeats(true);
        gameTimer.start();
    }

    // drawing of the game happens in here
    // we use the Graphics object, g, to perform the drawing
    // NOTE: This is already double buffered!(helps with framerate/speed)
    @Override
    public void paintComponent(Graphics g) {
        // always clear the screen first!
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE]
        // set the background to a grey colour 
        g.setColor(background);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // create the starting point of the game
        //green rectangle in bottom righthand corner
        g.setColor(text);
        g.fillRect(970, 770, 30, 30);

        //ending point of the game 
        //red rectangle in top lefhand corner
        g.setColor(text);
        g.fillRect(end.y, end.x, end.width, end.height);

        // draw character to go through the maze
        g.setColor(Color.BLACK);
        g.fillRect(player.x, player.y, player.width, player.height);

        //draw out the squares that make the player grow 
        g.setColor(larger);

        for (int i = 0; i < 10; i++) {

            if (lRenderable[i]) {

                g.fillRect(bigRecs[i].x, bigRecs[i].y, bigRecs[i].width, bigRecs[i].height);
            }
        }
        //draw out the squares that make the player smaller 
        g.setColor(smaller);

        for (int i = 0; i < 10; i++) {

            if (sRenderable[i]) {
                g.fillRect(smallRecs[i].x, smallRecs[i].y, smallRecs[i].width, smallRecs[i].height);
            }
        }

        //
        for (Block block : list) {
            
            block.render(g);

        }
        
        for (Block block : sidewaysList ) {
            int displacement = (int) (20 * Math.sin((System.nanoTime() / 100000000) + block.displace));
            block.render(g, displacement, 0);
        }
        
        
        for (Block block : upDownList) {
            int displacement = (int) (20 * Math.sin((System.nanoTime() / 100000000) + block.displace));
            block.render(g, 0, displacement);

        }

        //create the starting screen of game
        if (start) {
            player.x = 980;
            player.y = 780;
            //set background to blank screen
            g.setColor(background);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            //text on start screen
            g.setFont(welcome);
            g.setColor(text);
            g.drawString("WELCOME TO THE MAZE", 8, 100);

            //controls section
            g.setFont(controls);
            g.setColor(text);
            g.drawString("CONTROLS", 450, 200);

            g.drawString("LEFT ARROW - GO LEFT", 100, 270);

            g.drawString("RIGHT ARROW - GO RIGHT", 100, 340);

            g.drawString("UP ARROW - GO UP", 100, 410);

            g.drawString("DOWN ARROW - GO DOWN", 600, 410);

            g.drawString("BLUE SQUARE - GROW LARGER", 600, 270);

            g.drawString("WHITE SQUARE - GROW SMALLER", 600, 340);

            //play and exit options
            g.setFont(welcome);

            g.drawString("ENTER MAZE", 10, 670);
            g.fillRect(enter.x, enter.y, enter.width, enter.height);

            g.drawString("EXIT", 700, 670);
            g.fillRect(exit.x, exit.y, exit.width, exit.height);

        }

// type out you win if player wins the game 
        if (win) {
            // set background forblank screen
            g.setColor(background);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            //set main bold tst for "Maze Complete"
            g.setFont(winner);
            g.setColor(text);
            g.drawString("YOU WIN", 175, 200);

            //set text to ask player if they want to play again
            g.setFont(playAgain);
            g.drawString("Play Again?", 340, 400);

            //set yes box
            g.drawString("Yes", 450, 500);
            g.fillRect(yes.x, yes.y, yes.width, yes.height);

            //set no box
            g.drawString("No", 450, 600);
            g.fillRect(no.x, no.y, no.width, no.height);
        }

        //create a screen for losing the game
        if (lose) {
            // make screen go blank 
            g.setColor(background);
            g.fillRect(0, 0, WIDTH, HEIGHT);

            //set you lose text
            g.setFont(winner);
            g.setColor(text);
            g.drawString("MAZE FAILED", 0, 150);

            //create exit game option
            g.setFont(playAgain);
            g.drawString("QUIT MAZE?", 310, 400);
            g.fillRect(quitGame.x, quitGame.y, quitGame.width, quitGame.height);
            //create exit game option
            g.setFont(playAgain);
            g.drawString("PLAY AGAIN?", 310, 600);
            g.fillRect(tryAgain.x, tryAgain.y, tryAgain.width, tryAgain.height);

        }

        // GAME DRAWING ENDS HERE  
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
        largerBigger();
        for (int i = 0; i < 10; i++) {
            lRenderable[i] = true;
            bigRecs[i] = new Rectangle(xPosArray[i], yPosArray[i], 10, 10);

        }
        for (int i = 0; i < 10; i++) {
            sRenderable[i] = true;
            smallRecs[i] = new Rectangle(xPosArray[10 + i], yPosArray[10 + i], 10, 10);

        }
        
        int xSlots = 50;          
        int ySlots = 40;
        int[][] maze = new int[][]{
            {0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0},
            {0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 0, 1, 0, 1, 3, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 3, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 3, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0},
            {3, 0, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 3, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0},
            {1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 3, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
            {1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 3, 1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 3, 0, 1, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0},
            {0, 1, 0, 1, 3, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
        Random random = new Random();
        for (int y = 0; y<40; y++){
            for (int x = 0; x<50; x++){
                if (maze[y][x] == 1){
                    list.add(new Block (x*20, y*20));
                }
                if (maze[y][x] == 2){
                    upDownList.add(new Block (x*20, y*20, random.nextInt(40) - 20));
                }
                if (maze[y][x] == 3){
                    sidewaysList.add(new Block (x*20, y*20, random.nextInt(40) - 20));
                }
            }
        }



    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {

        moveplayer();
        collisiondetect();

        if (allGenerated == false) {
            largerBigger();
            preSetup();
        }
        if (yes.contains(mouseX, mouseY)) {

            reset();

        }

    }

    private void largerBigger() {

        for (int i = 0; i <= 19; i++) {

            yPosition = (int) (Math.random() * (800 - 1 + 1)) + 1;
            xPosition = (int) (Math.random() * (1000 - 1 + 1)) + 1;

            xPosArray[i] = xPosition;
            yPosArray[i] = yPosition;
        }
        allGenerated = true;

    }

    private void moveplayer() {
        // move player up contol
        if (playerUp) {
            player.y = player.y - playerSpeed;

        } else if (playerDown) {
            player.y = player.y + playerSpeed;
        }

        //move player left/right
        if (playerRight) {
            player.x = player.x + playerSpeed;
        } else if (playerLeft) {
            player.x = player.x - playerSpeed;
        }

        // make the player unable to go off the screen
        // too far up
        if (player.y < 0) {
            player.y = 0;
        }
        //player gone too far dow

        if (player.y + player.height > HEIGHT) {
            player.y = HEIGHT - player.height;
        }

        // too far left
        if (player.x < 0) {
            player.x = 0;
        }
        //player gone too far right

        if (player.x + player.width > WIDTH) {
            player.x = WIDTH - player.width;
        }

    }

    private void collisiondetect() {

        for (Block block : list) {
            block.collisions(player);
        }
        
        for (Block block : upDownList) {
            block.collisions(player);
        }
        
        for (Block block : sidewaysList) {
            block.collisions(player);
        }
        //make player win game
        if (player.intersects(end)) {

            win = true;             
        }
//re set game if player clicks yes box
        if (yes.contains(mouseX, mouseY)) {

            reset();

        }
//exit game if player clicks no box
        if (no.contains(mouseX, mouseY)) {
            System.exit(0);
        }
        if (enter.contains(mouseX, mouseY)) {
            start = false;
        }
        if (exit.contains(mouseX, mouseY)) {
            System.exit(0);
        }

        if (tryAgain.contains(mouseX, mouseY)) {
            reset();
        }

        if (quitGame.contains(mouseX, mouseY)) {
            System.exit(0);
        }

        //make player grow if it collides with the green squares
        for (int i = 0; i < 10; i++) {
            if (player.intersects(bigRecs[i]) && lRenderable[i]) {
                player.height = player.height + 4;
                player.width = player.width + 4;
                lRenderable[i] = false;
            }
        }
        for (int i = 0; i < 10; i++) {
            if (player.intersects(smallRecs[i]) && sRenderable[i]) {
                player.height = player.height - 1;
                player.width = player.width - 1;
                sRenderable[i] = false;
            }
        }

    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            if (win) {
                mouseX = e.getX();
                mouseY = e.getY();

            }
            if (start) {
                mouseX = e.getX();
                mouseY = e.getY();

            }

            if (lose) {
                mouseX = e.getX();
                mouseY = e.getY();

            }
        }

        // if a mouse button has been released
        @Override
        public void mouseReleased(MouseEvent e) {
        }

        // if the scroll wheel has been moved
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
        }

        // if the mouse has moved positions
        @Override
        public void mouseMoved(MouseEvent e) {
        }
    }

    // Used to implements any of the Keyboard Actions
    private class Keyboard extends KeyAdapter {

        // if a key has been pressed down
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            // player up/ down controls
            if (keyCode == KeyEvent.VK_UP) {
                playerUp = true;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                playerDown = true;
            }

            // mover player left/rigth controls
            if (keyCode == KeyEvent.VK_RIGHT) {
                playerRight = true;
            } else if (keyCode == KeyEvent.VK_LEFT) {
                playerLeft = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

            int keyCode = e.getKeyCode();

            // player up/ down controls
            if (keyCode == KeyEvent.VK_UP) {
                playerUp = false;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                playerDown = false;
            }

            // mover player left/rigth controls
            if (keyCode == KeyEvent.VK_RIGHT) {
                playerRight = false;
            } else if (keyCode == KeyEvent.VK_LEFT) {
                playerLeft = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        gameLoop();
        repaint();      
    }

    private void reset() {
        //frame.dispose();
        preSetup();
        //make it so the player hasn't won or lost yet
        win = false;
        lose = false;
        //place player back at the start of the maze
        player.setLocation(980, 780);
        //reset controls for movement
        playerUp = false;
        playerDown = false;
        playerLeft = false;
        playerRight = false;
        //reset players speed to 5
        playerSpeed = 5;
        //reset mouse cooridinates to 0, 0
        mouseX = 0;
        mouseY = 0;
        //reset the player to the original size
        player.height = 15;
        player.width = 15;
        //allgenerated = false;

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        game = new game();
    }

    class Block {

        Rectangle block;
        int diameter = 20;
        int displace;

        public Block(int x, int y) {
            block = new Rectangle(x, y, diameter, diameter);
        }
        
        public Block(int x, int y, int displace) {
            this.displace = displace;
            block = new Rectangle(x, y, diameter, diameter);
        }

        public void render(Graphics g) {           
                //draw a rectangle
                g.setColor(maze);
                g.fillRect(block.x, block.y, block.width, block.height);
            
        }
        
        public void render(Graphics g, int x, int y) {           
                //draw a rectangle
                g.setColor(maze);
                g.fillRect(block.x + x, block.y + y, block.width, block.height);                            
        }

        public void collisions(Rectangle player) {
            if (player.intersects(block)) {
                lose = true;
            }
        }
    }
}