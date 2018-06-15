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
    Rectangle player = new Rectangle(980, 780, 20, 20);
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
            g.drawString("WELCOME TO THE GAME", 8, 100);

            //controls section
            g.setFont(controls);
            g.setColor(text);
            g.drawString("CONTROLS", 450, 200);

            g.drawString("LEFT ARROW - GO LEFT", 100, 270);

            g.drawString("RIGHT ARROW - GO RIGHT", 100, 340);

            g.drawString("UP ARROW - GO UP", 100, 410);

            g.drawString("DOWN ARROW - GO DOWN", 600, 410);

            g.drawString("GREEN SQUARE - GROW LARGER", 600, 270);

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




        list.add(new Block(20, 50));
        list.add(new Block(20, 70));
        list.add(new Block(20, 90));
        list.add(new Block(20, 110));
        list.add(new Block(20, 130));
        list.add(new Block(20, 150));
        list.add(new Block(20, 170));
        list.add(new Block(20, 190));
        list.add(new Block(20, 110));
        list.add(new Block(20, 130));
        list.add(new Block(20, 150));
        list.add(new Block(20, 170));
        list.add(new Block(20, 190));
        list.add(new Block(20, 210));
        list.add(new Block(20, 230));
        list.add(new Block(20, 250));
        list.add(new Block(20, 270));
        list.add(new Block(20, 290));

        list.add(new Block(0, 330));
        list.add(new Block(20, 350));
        list.add(new Block(40, 370));
        list.add(new Block(100, 370));

        list.add(new Block(60, 310));
        list.add(new Block(80, 330));

        list.add(new Block(100, 330));
        list.add(new Block(120, 330));
        list.add(new Block(140, 330));
        list.add(new Block(160, 330));
        list.add(new Block(180, 330));
        list.add(new Block(200, 330));
        list.add(new Block(220, 330));
        list.add(new Block(240, 330));
        list.add(new Block(260, 330));
        list.add(new Block(280, 330));
        list.add(new Block(300, 330));
        list.add(new Block(320, 330));


        list.add(new Block(40, 290));
        list.add(new Block(60, 290));
        list.add(new Block(80, 290));

        list.add(new Block(120, 290));
        list.add(new Block(140, 290));
        list.add(new Block(160, 290));
        list.add(new Block(180, 290));
        list.add(new Block(200, 290));

        list.add(new Block(40, 70));
        list.add(new Block(60, 70));
        list.add(new Block(80, 70));
        list.add(new Block(100, 70));

        list.add(new Block(100, 50));
        list.add(new Block(100, 30));
        list.add(new Block(100, 20));

        list.add(new Block(120, 20));
        list.add(new Block(140, 20));
        list.add(new Block(160, 20));
        list.add(new Block(180, 20));


        list.add(new Block(180, 40));
        list.add(new Block(180, 60));
        list.add(new Block(180, 80));
        list.add(new Block(180, 100));

        list.add(new Block(220, 140));
        list.add(new Block(200, 140));
        list.add(new Block(180, 140));
        list.add(new Block(160, 140));
        list.add(new Block(140, 140));
        list.add(new Block(120, 140));
        list.add(new Block(100, 140));

        list.add(new Block(100, 160));
        list.add(new Block(100, 180));
        list.add(new Block(100, 200));
        list.add(new Block(100, 220));
        list.add(new Block(100, 240));

        list.add(new Block(160, 240));
        list.add(new Block(180, 240));
        list.add(new Block(160, 220));
        list.add(new Block(180, 220));
        list.add(new Block(160, 200));
        list.add(new Block(180, 200));

        list.add(new Block(200, 240));
        list.add(new Block(220, 240));
        list.add(new Block(240, 240));

        list.add(new Block(200, 220));
        list.add(new Block(220, 220));
        list.add(new Block(240, 220));

        list.add(new Block(260, 240));
        list.add(new Block(260, 220));


        list.add(new Block(260, 200));

        list.add(new Block(260, 180));
        list.add(new Block(260, 160));
        list.add(new Block(260, 140));
        list.add(new Block(260, 120));
        list.add(new Block(260, 100));
        list.add(new Block(260, 80));

        list.add(new Block(280, 80));
        list.add(new Block(300, 80));
        list.add(new Block(320, 80));
        list.add(new Block(340, 80));
        list.add(new Block(360, 80));
        list.add(new Block(380, 80));
        list.add(new Block(400, 80));
        list.add(new Block(420, 80));
        list.add(new Block(440, 80));

        list.add(new Block(440, 60));
        list.add(new Block(440, 40));
        list.add(new Block(440, 20));

        list.add(new Block(480, 20));
        list.add(new Block(480, 40));
        list.add(new Block(480, 60));
        list.add(new Block(480, 80));
        list.add(new Block(480, 100));
        list.add(new Block(480, 120));

        list.add(new Block(460, 120));
        list.add(new Block(440, 120));
        list.add(new Block(420, 120));
        list.add(new Block(400, 120));
        list.add(new Block(380, 120));
        list.add(new Block(360, 120));
        list.add(new Block(340, 120));
        list.add(new Block(320, 120));
        list.add(new Block(300, 120));

        list.add(new Block(300, 140));
        list.add(new Block(300, 160));
        list.add(new Block(300, 180));
        list.add(new Block(300, 200));
        list.add(new Block(300, 220));
        list.add(new Block(300, 240));
        list.add(new Block(300, 260));
        list.add(new Block(300, 280));
        list.add(new Block(300, 300));

        list.add(new Block(320, 300));
        list.add(new Block(340, 300));
        list.add(new Block(360, 300));
        list.add(new Block(380, 300));

        list.add(new Block(380, 320));
        list.add(new Block(380, 340));
        list.add(new Block(380, 360));

        list.add(new Block(360, 360));
        list.add(new Block(340, 360));
        list.add(new Block(320, 360));
        list.add(new Block(300, 360));
        list.add(new Block(280, 360));
        list.add(new Block(260, 360));
        list.add(new Block(240, 360));
        list.add(new Block(220, 360));
        list.add(new Block(200, 360));
        list.add(new Block(180, 360));
        list.add(new Block(160, 360));
        list.add(new Block(140, 360));


        list.add(new Block(140, 380));
        list.add(new Block(140, 400));
        list.add(new Block(140, 420));
        list.add(new Block(140, 440));
        list.add(new Block(140, 460));
        list.add(new Block(140, 480));
        list.add(new Block(140, 500));
        list.add(new Block(140, 520));

        list.add(new Block(100, 380));
        list.add(new Block(100, 400));
        list.add(new Block(100, 420));
        list.add(new Block(100, 440));
        list.add(new Block(100, 460));
        list.add(new Block(100, 480));
        list.add(new Block(100, 500));
        list.add(new Block(100, 520));

        list.add(new Block(40, 380));
        list.add(new Block(40, 400));
        list.add(new Block(40, 420));
        list.add(new Block(40, 440));

        list.add(new Block(60, 440));
        list.add(new Block(80, 440));

        list.add(new Block(0, 440));
        list.add(new Block(0, 420));
        list.add(new Block(0, 400));
        list.add(new Block(0, 380));
        list.add(new Block(0, 360));
        list.add(new Block(0, 340));

        list.add(new Block(20, 440));
        list.add(new Block(20, 420));
        list.add(new Block(20, 400));
        list.add(new Block(20, 380));
        list.add(new Block(20, 360));
        list.add(new Block(20, 340));

        list.add(new Block(80, 480));
        list.add(new Block(60, 480));
        list.add(new Block(40, 480));
        list.add(new Block(20, 480));

        list.add(new Block(20, 500));
        list.add(new Block(20, 520));
        list.add(new Block(20, 540));
        list.add(new Block(20, 560));
        list.add(new Block(20, 580));


        list.add(new Block(60, 520));
        list.add(new Block(60, 540));
        list.add(new Block(60, 560));
        list.add(new Block(60, 580));

        list.add(new Block(80, 560));
        list.add(new Block(100, 560));

        list.add(new Block(160, 520));         

        list.add(new Block(220, 520));
        list.add(new Block(220, 500));
        list.add(new Block(220, 480));
        list.add(new Block(220, 460));
        list.add(new Block(220, 440));
        list.add(new Block(220, 420));
        

        list.add(new Block(200, 200));
        list.add(new Block(220, 200));
        list.add(new Block(240, 200));
        list.add(new Block(180, 200));


        list.add(new Block(220, 120));
        list.add(new Block(220, 100));
        list.add(new Block(220, 80));
        list.add(new Block(220, 60));
        list.add(new Block(220, 40));
        list.add(new Block(220, 20));

        list.add(new Block(240, 20));
        list.add(new Block(260, 20));
        list.add(new Block(280, 20));
        list.add(new Block(300, 20));
        list.add(new Block(320, 20));
        list.add(new Block(340, 20));
        list.add(new Block(360, 20));

        list.add(new Block(140, 100));
        list.add(new Block(140, 80));
        list.add(new Block(140, 60));

        list.add(new Block(30, 0));
        list.add(new Block(50, 0));
        list.add(new Block(60, 0));

        list.add(new Block(60, 30));




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
                player.height = player.height - 3;
                player.width = player.width - 3;
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
        player.height = 20;
        player.width = 20;
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

        public Block(int x, int y) {

            block = new Rectangle(x, y, diameter, diameter);

        }

        public void render(Graphics g) {

            for (int i = 0; i < 10; i++) {
                //draw a rectangle
                g.setColor(maze);
                g.fillRect(block.x, block.y, block.width, block.height);
            }
        }

        public void collisions(Rectangle player) {
            if (player.intersects(block)) {
                lose = true;
            }
        }
    }
}