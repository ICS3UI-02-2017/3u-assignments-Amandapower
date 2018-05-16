package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
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
public class A8 extends JComponent implements ActionListener {

    // Height and Width of our game
    static final int WIDTH = 800;
    static final int HEIGHT = 600;
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
    Color skin = new Color(239, 214, 189);
    Color hair = new Color(44, 34, 43);

    // GAME VARIABLES END HERE    
    // Constructor to create the Frame and place the panel in
    // You will learn more about this in Grade 12 :)
    public A8() {
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

        // GAME DRAWING GOES HERE
        //hair
        g.setColor(hair);
        g.fillRect(200, 200, 400, 600);

        // make face of person
        g.setColor(skin);
        g.fillOval(200, 100, 400, 430);
        //ears
        g.fillOval(170, 260, 100, 100);
        g.fillOval(530, 260, 100, 100);
        //hair
        g.setColor(hair);
        g.fillOval(210, 110, 100, 100);
        g.fillOval(180, 140, 100, 100);
        g.fillOval(160, 180, 100, 100);
        g.fillOval(160, 220, 100, 100);
        g.fillOval(160, 260, 100, 100);
        g.fillOval(160, 300, 100, 100);
        g.fillOval(160, 340, 100, 100);
        g.fillOval(160, 380, 100, 100);
        g.fillOval(160, 400, 100, 100);
        g.fillOval(160, 440, 100, 100);
        g.fillOval(160, 480, 100, 100);
        g.fillOval(160, 500, 100, 100);
        g.fillOval(160, 540, 100, 100);
        g.fillOval(220, 100, 100, 100);
        g.fillOval(240, 90, 100, 100);
        g.fillOval(280, 70, 100, 100);
        g.fillOval(320, 70, 100, 100);
        g.fillOval(360, 70, 100, 100);
        g.fillOval(390, 70, 100, 100);
        g.fillOval(420, 80, 100, 100);
        g.fillOval(450, 100, 100, 100);
        g.fillOval(490, 130, 100, 100);
        g.fillOval(510, 160, 100, 100);
        g.fillOval(530, 200, 100, 100);
        g.fillOval(530, 230, 100, 100);
        g.fillOval(540, 270, 100, 100);
        g.fillOval(540, 310, 100, 100);
        g.fillOval(540, 340, 100, 100);
        g.fillOval(540, 380, 100, 100);
        g.fillOval(540, 410, 100, 100);
        g.fillOval(540, 440, 100, 100);
        g.fillOval(540, 480, 100, 100);
        g.fillOval(540, 500, 100, 100);
        g.fillOval(540, 530, 100, 100);
        // neck
        g.setColor(skin);
        g.fillRect(300, 400, 200, 600);

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
    }

    // Used to implement any of the Mouse Actions
    private class Mouse extends MouseAdapter {

        // if a mouse button has been pressed down
        @Override
        public void mousePressed(MouseEvent e) {
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
        }

        // if a key has been released
        @Override
        public void keyReleased(KeyEvent e) {
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
        A8 game = new A8();
    }
}
