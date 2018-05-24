package Assignment8;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics2D;
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
    //colours
    Color nose = new Color(255, 192, 203);
    Color hair = new Color(44, 34, 43);
    Color face = new Color(255, 250, 250);
    Color black = new Color(0, 0, 0);
    Color pink = new Color(254, 127, 156);
    //variables for animation
    //eye movement x and y positions
    boolean moveright = true;
    int eye1x = 200;
    int eye2x = 400;
    int eyesy = 250;
    //move mouth
    boolean mouthmove = true;
    
    int mouth1y = 500;
    int mouth2y = 540;
           
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
        Graphics2D g2d = (Graphics2D) g;
        g.clearRect(0, 0, WIDTH, HEIGHT);

        // GAME DRAWING GOES HERE

        //background
        g.setColor(hair);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        //face
        g.setColor(nose);
        g.fillOval(120, 50, 500, 500);


        // nostrils 
        g.setColor(black);

        g.fillOval(250, 450, 50, 50);
        g.fillOval(400, 450, 50, 50);

        // ears
        g.setColor(nose);

        g2d.translate(70, 220);
        g2d.rotate(Math.toRadians(60));
        g.fillOval(-50, -200, 100, 200);
        g2d.rotate(Math.toRadians(-60));
        g2d.translate(-70, -220);

        g2d.translate(550, 220);
        g2d.rotate(Math.toRadians(110));
        g.fillOval(-110, -120, 100, 200);
        g2d.rotate(Math.toRadians(-110));
        g2d.translate(-550, -220);

        // eyes 
        g.setColor(Color.BLACK);
        g.fillOval(eye1x, eyesy, 100, 150);
        g.fillOval(eye2x, eyesy, 100, 150);

        // mouth
        g.setColor(nose);
        g.fillOval(250, mouth1y, 200, 100);

        g.setColor(pink);
        g.fillOval(270, mouth2y, 150, 50);

        //nose
        g.setColor(pink);
        g.fillOval(160, 350, 400, 200);

        // nostrils 
        g.setColor(black);

        g.fillOval(250, 450, 50, 50);
        g.fillOval(400, 450, 50, 50);







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

        // move the left eye back ad forth
        if (eye1x <= 200) {
            moveright = true;
        }
        if (eye1x >= 250) {
            moveright = false;
        }

        if (moveright) {
            eye1x = eye1x + 3;
        } else {
            eye1x = eye1x - 3;
        }

        // move the right eye back and forth
        if (eye2x <= 400) {
            moveright = true;
        }
        if (eye2x >= 450) {
            moveright = false;
        }

        if (moveright) {
            eye2x = eye2x + 3;
        } else {
            eye2x = eye2x - 3;
        }
        
        //make mouth move
        if (mouth1y >= 500){
            mouthmove = true;
        }
        if (mouth1y <= 400){
            mouthmove = false;
        }
        if (mouthmove){
            mouth1y = mouth1y + 3;
        }
        else {
            mouth1y = mouth1y - 3;
        }


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
