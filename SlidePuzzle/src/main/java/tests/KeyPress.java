package tests;


import java.awt.*;
import java.awt.event.*;

public class KeyPress extends Frame{
    Label label;
    TextField txtField;
    public static void main(String[] args) {
        KeyPress k = new KeyPress();
    }

    public KeyPress(){
        super("Key Press Event Frame");
        Panel panel = new Panel();
        label = new Label();
        txtField = new TextField(20);
        txtField.addKeyListener(new MyKeyListener());
        add(label, BorderLayout.NORTH);
        panel.add(txtField, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                System.exit(0);
            }
        });
        setSize(400,400);
        setVisible(true);
    }

    public class MyKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent ke){
            char i = ke.getKeyChar();
            String str = Character.toString(i);
            label.setText(str);
        }
    }
}
