package lala;

import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Scanner;

public class KeyListenerExample implements KeyListener
{
    Scanner sc = new Scanner(System.in);
    public static int[][] board;
    public static int size;
    static int hole = 0;
    int cnt = 1;
    int x;
    int y;

    KeyListenerExample()
    {
        //Initializing the Matrix
        System.out.println("Board Creation: Please, type desired tile grid size (e.g. 4, to create 4x4 tile)");
        size = Integer.parseInt(sc.nextLine());
//        int size = sel * sel;
        board = new int[size][size];
        System.out.println("\nGrid size selected: " + size + " x " + size);
        System.out.println(printBoard()); // LEO CAPO


    }

    public String printBoard(){
        StringBuilder sb = new StringBuilder(size * size * 4);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = cnt;
                board[size-1][size-1] = 0; //Always return 0 on last index from array.
                sb.append(String.format("%s", (board[i][j] == 0) ? "" : board[i][j])).append("\t");
                cnt++;
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    //keyPressed() method takes care of moving the zero according to the key pressed
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(x != 3) {
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
            if(y != 3) {
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
        StringBuilder sb = new StringBuilder(size * size * 4);
        board[y][x] = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(String.format("%s", (board[i][j] == 0) ? "" : board[i][j])).append("\t");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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

    }
}