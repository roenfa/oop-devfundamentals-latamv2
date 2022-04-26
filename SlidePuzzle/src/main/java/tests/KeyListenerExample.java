package tests;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
public class KeyListenerExample implements KeyListener
{
    //Matrix and x, y coordinates of 0
    int[][] matrix;
    int x;
    int y;
    KeyListenerExample()
    {
        //Initializing the Matrix
        matrix = new int[3][3];
        matrix[0] = new int[] {1, 1, 1};
        matrix[1] = new int[] {1, 0, 1};
        matrix[2] = new int[] {1, 1, 1};

        x = 1;
        y = 1;

        //Printing the Matrix
        for(int i=0; i<3; i++)
            System.out.println(Arrays.toString(matrix[i]));
        System.out.println();
    }
    //keyPressed() method takes care of moving the zero according to the key pressed
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(x != 2) {
                x +=1;
                System.out.println("Moving Right");
            }
            else
                System.out.println("Cannot Move Right");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(x != 0) {
                x-=1;
                System.out.println("Moving Left");
            }
            else
                System.out.println("Cannot Move Left");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(y != 2) {
                y+=1;
                System.out.println("Moving Down");
            }
            else
                System.out.println("Cannot Move Down");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            if(y != 0) {
                y-=1;
                System.out.println("Moving Up");
            }
            else
                System.out.println("Cannot Move Up");
        }
        matrix[0] = new int[]{1, 1, 1};
        matrix[1] = new int[]{1, 1, 1};
        matrix[2] = new int[]{1, 1, 1};
        matrix[y][x] = 0;
        for(int i=0; i<3; i++)
            System.out.println(Arrays.toString(matrix[i]));
        System.out.println();
    }
    //We don't need the other two methods
    @Override
    public void keyReleased(KeyEvent e)
    {}
    @Override
    public void keyTyped(KeyEvent e)
    {}
    public static void main(String[] args)
    {
        //Setting the frame and labels
        Frame f = new Frame("Demo");
        f.setLayout(new FlowLayout());
        f.setSize(200, 200);
        Label l = new Label();
        l.setText("This is a Game");
        f.add(l);
        f.setVisible(true);

        //Creating and adding the key listener
        KeyListenerExample k = new KeyListenerExample();
        f.addKeyListener(k);
//        k.getKeyCode();
    }
}