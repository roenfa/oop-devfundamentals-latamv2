package tests;

import java.awt.event.KeyEvent;

public class Game {

    public void keyPressed(KeyEvent e){
        // New key press
        int key = e.getKeyCode();
        // If we press right
        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("The right arrow key is pressed");
            // Or, if we press left
        } else if (key == KeyEvent.VK_LEFT) {
            System.out.println("The left arrow key is pressed");
        }
    }
    public void keyReleased(KeyEvent e){
        // New key has been released
        int key = e.getKeyCode();
        // If we release the right key
        if(key == KeyEvent.VK_RIGHT){
            System.out.println("The right arrow key is released");
        }
        // If we release the left key
        else if(key == KeyEvent.VK_LEFT){
            System.out.println("The left arrow key is released");
        }
    }

}
