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
     int playerspeed = 50;
     
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
     
     //make rectangles that make player larger
     Rectangle big1 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big2 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big3 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big4 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big5 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big6 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big7 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big8 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big9 = new Rectangle(600, 450, 50, 50);
     
     Rectangle big10 = new Rectangle(600, 450, 50, 50);
     

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
        g.setColor(Color.GREEN);
        g.fillRect(970, 770, 30, 30);

        //ending point of the game 

        //red rectangle in top lefhand corner
        g.setColor(Color.RED);
        g.fillRect(end.y, end.x, end.width, end.height);

        
        // draw character to go through the maze
       g.setColor(Color.BLACK);
       g.fillRect(player.x, player.y, player.width, player.height);
       
       
// type out you win if player wins the game 
       if (win){
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
    }
    
    private void moveplayer(){
        // move player up contol
        if (playerup){
            player.y = player.y - playerspeed;
            
        }else if (playerdown){
            player.y = player.y + playerspeed;
        }
        
        //move player left/right
        if (playerright){
            player.x = player.x + playerspeed;
        }else if (playerleft){
            player.x = player.x - playerspeed;
        }
        
        // make the player unable to go off the screen
        // too far up
        if (player.y <0){
            player.y = 0;
        }
        //player gone too far dow
        
        if (player.y + player.height > HEIGHT){
            player.y = HEIGHT - player.height;
        }
        
        // too far left
        if (player.x <0){
            player.x = 0;
        }
        //player gone too far right
        
        if (player.x + player.width > WIDTH){
            player.x = WIDTH - player.width;
        }
        
        
    }
    
    private void collisiondetect (){
        if (player.intersects(end)){
            
            win = true;
        }
        
        if (yes.contains(mousex, mousey)){
            win = false;
           player.x = 980;
           player.y = 780;
            
        }
        
        if (no.contains(mousex, mousey)){
            System.exit(0);
            
        }
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
            if (win){
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
            if (keyCode == KeyEvent.VK_UP){
                playerup = true;
            }else if (keyCode == KeyEvent.VK_DOWN){
                playerdown = true;
            }
            
            // mover player left/rigth controls
            if (keyCode == KeyEvent.VK_RIGHT){
                playerright = true;
            }else if (keyCode == KeyEvent.VK_LEFT){
                playerleft = true;
        }
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
            
            int keyCode = e.getKeyCode();
            
            // player up/ down controls
            if (keyCode == KeyEvent.VK_UP){
                playerup = false;
            }else if (keyCode == KeyEvent.VK_DOWN){
                playerdown = false;
            }
            
               // mover player left/rigth controls
            if (keyCode == KeyEvent.VK_RIGHT){
                playerright = false;
            }else if (keyCode == KeyEvent.VK_LEFT){
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
