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
    Color background = new Color(0, 51, 51);
    // costom font type and size
    Font boldfont = new Font("arial", Font.BOLD, 27);
    //create variable for character that will go through the maze
    Rectangle player = new Rectangle(980, 780, 20, 20);
    //create booleans for player movement
    boolean playerup = false;
    boolean playerdown = false;
    boolean playerleft = false;
    boolean playerright = false;
    // speed of player
    int playerspeed = 5;
    // create rectange for the red end square
    Rectangle end = new Rectangle(0, 0, 30, 30);
    //booleans for winning and losing the game
    boolean win = false;
    boolean lose = false;
    //colour for text on the win game + end game screen
    Color text = new Color(120, 249, 133);
    //set custom texts
    Font winner = new Font("arial", Font.BOLD, 150);
    Font playagain = new Font("arial", Font.BOLD, 70);
    //create rectangles for the yes and no options
    Rectangle yes = new Rectangle(600, 450, 50, 50);
    Rectangle no = new Rectangle(600, 550, 50, 50);
    //mouse variables for end game screen
    int mousex = 0;
    int mousey = 0;
    // randomly generate the x and y coordinates of the growing rectangles
    int xposition = (int) (Math.random() * (1000 - 1 + 1)) + 1;
    int yposition = (int) (Math.random() * (800 - 1 + 1)) + 1;
    //make array to save randomly generated numbers
    int[] xposarray = new int[20];
    int[] yposarray = new int[20];
    //make rectangles that make player larger 
    Rectangle big1 = new Rectangle(xposarray[0], yposarray[0], 10, 10);
    Rectangle big2 = new Rectangle(xposarray[1], yposarray[1], 10, 10);
    Rectangle big3 = new Rectangle(xposarray[2], yposarray[2], 10, 10);
    Rectangle big4 = new Rectangle(xposarray[3], yposarray[3], 10, 10);
    Rectangle big5 = new Rectangle(xposarray[4], yposarray[4], 10, 10);
    Rectangle big6 = new Rectangle(xposarray[5], yposarray[5], 10, 10);
    Rectangle big7 = new Rectangle(xposarray[6], yposarray[6], 10, 10);
    Rectangle big8 = new Rectangle(xposarray[7], yposarray[7], 10, 10);
    Rectangle big9 = new Rectangle(xposarray[8], yposarray[8], 10, 10);
    Rectangle big10 = new Rectangle(xposarray[9], yposarray[9], 10, 10);
    //make rectangles that make player smaller 
    Rectangle small1 = new Rectangle(xposarray[10], yposarray[10], 10, 10);
    Rectangle small2 = new Rectangle(xposarray[11], yposarray[11], 10, 10);
    Rectangle small3 = new Rectangle(xposarray[12], yposarray[12], 10, 10);
    Rectangle small4 = new Rectangle(xposarray[13], yposarray[13], 10, 10);
    Rectangle small5 = new Rectangle(xposarray[14], yposarray[14], 10, 10);
    Rectangle small6 = new Rectangle(xposarray[15], yposarray[15], 10, 10);
    Rectangle small7 = new Rectangle(xposarray[16], yposarray[16], 10, 10);
    Rectangle small8 = new Rectangle(xposarray[17], yposarray[17], 10, 10);
    Rectangle small9 = new Rectangle(xposarray[18], yposarray[18], 10, 10);
    Rectangle small10 = new Rectangle(xposarray[19], yposarray[19], 10, 10);
    
    //create boolean to stop geneation of grow larger square/only 10 times
     boolean allgenerated = false;

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public game() {
        // creates a windows to show my game
        JFrame frame = new JFrame(title);

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
        g.setColor(text);
        g.fillRect(xposarray[0], yposarray[0], big1.width, big1.height);
        g.fillRect(xposarray[1], yposarray[1], big2.width, big2.height);
        g.fillRect(xposarray[2], yposarray[2], big3.width, big3.height);
        g.fillRect(xposarray[3], yposarray[3], big4.width, big4.height);
        g.fillRect(xposarray[4], yposarray[4], big1.width, big1.height);
        g.fillRect(xposarray[5], yposarray[5], big2.width, big2.height);
        g.fillRect(xposarray[6], yposarray[6], big3.width, big3.height);
        g.fillRect(xposarray[7], yposarray[7], big4.width, big4.height);
        g.fillRect(xposarray[8], yposarray[8], big3.width, big3.height);
        g.fillRect(xposarray[9], yposarray[9], big4.width, big4.height);
        
         //draw out the squares that make the player smaller 
        g.setColor(Color.WHITE);
        g.fillRect(xposarray[10], yposarray[10], small1.width, small1.height);
        g.fillRect(xposarray[11], yposarray[11], small2.width, small2.height);
        g.fillRect(xposarray[12], yposarray[12], small3.width, small3.height);
        g.fillRect(xposarray[13], yposarray[13], small4.width, small4.height);
        g.fillRect(xposarray[14], yposarray[14], small5.width, small5.height);
        g.fillRect(xposarray[15], yposarray[15], small6.width, small6.height);
        g.fillRect(xposarray[16], yposarray[16], small7.width, small7.height);
        g.fillRect(xposarray[17], yposarray[17], small8.width, small8.height);
        g.fillRect(xposarray[18], yposarray[18], small9.width, small9.height);
        g.fillRect(xposarray[19], yposarray[19], small10.width, small10.height);
        
       


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
            g.setFont(playagain);
            g.drawString("Play Again?", 340, 400);

            //set yes box
            g.drawString("Yes", 450, 500);
            g.fillRect(yes.x, yes.y, yes.width, yes.height);

            //set no box
            g.drawString("No", 450, 600);
            g.fillRect(no.x, no.y, no.width, no.height);
        }







        // GAME DRAWING ENDS HERE  
    }

    // This method is used to do any pre-setup you might need to do
    // This is run before the game loop begins!
    public void preSetup() {
        // Any of your pre setup before the loop starts should go here
    }

    // The main game loop
    // In here is where all the logic for my game will go
    public void gameLoop() {
        moveplayer();
        collisiondetect();
        
        if (allgenerated == false){
        largerBigger();
        }
    }

    private void largerBigger() {

      
        for (int i = 0; i <= 19; i++) {

            yposition = (int) (Math.random() * (800 - 1 + 1)) + 1;
            xposition = (int) (Math.random() * (1000 - 1 + 1)) + 1;


            xposarray[i] = xposition;
            yposarray[i] = yposition;
        }
allgenerated = true; 
       
    }

    private void moveplayer() {
        // move player up contol
        if (playerup) {
            player.y = player.y - playerspeed;

        } else if (playerdown) {
            player.y = player.y + playerspeed;
        }

        //move player left/right
        if (playerright) {
            player.x = player.x + playerspeed;
        } else if (playerleft) {
            player.x = player.x - playerspeed;
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
        //make player win game
        if (player.intersects(end)) {

            win = true;
        }
//re set game if player clicks yes box
        if (yes.contains(mousex, mousey)) {
            win = false;
            player.x = 980;
            player.y = 780;

        }
//exit game if player clicks no box
        if (no.contains(mousex, mousey)) {
            System.exit(0);

        }
        
        //make player grow if it collides with the green squares
        
        if (player.intersects(big1)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big2)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big3)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big4)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big5)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big6)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big7)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big8)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big9)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
        if (player.intersects(big10)){
            player.height = player.height +3;
             player.width = player.width +3;
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            if (win) {
                mousex = e.getX();
                mousey = e.getY();

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
                playerup = true;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                playerdown = true;
            }

            // mover player left/rigth controls
            if (keyCode == KeyEvent.VK_RIGHT) {
                playerright = true;
            } else if (keyCode == KeyEvent.VK_LEFT) {
                playerleft = true;
            }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {

            int keyCode = e.getKeyCode();

            // player up/ down controls
            if (keyCode == KeyEvent.VK_UP) {
                playerup = false;
            } else if (keyCode == KeyEvent.VK_DOWN) {
                playerdown = false;
            }

            // mover player left/rigth controls
            if (keyCode == KeyEvent.VK_RIGHT) {
                playerright = false;
            } else if (keyCode == KeyEvent.VK_LEFT) {
                playerleft = false;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        preSetup();
        gameLoop();
        repaint();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // creates an instance of my game
        game game = new game();
    }
}
