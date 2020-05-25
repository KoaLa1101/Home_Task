package Task17;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class KeyListener extends JFrame implements java.awt.event.KeyListener {
    public static void main(String[] args) {
        JFrame jFrame = new KeyListener();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    public KeyListener(){
        this.setSize(100,100);
        this.addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) new Piano(Keys.get("a")).start();
        if (e.getKeyCode() == KeyEvent.VK_B) new Piano(Keys.get("b")).start();
        if (e.getKeyCode() == KeyEvent.VK_C) new Piano(Keys.get("c")).start();
        if (e.getKeyCode() == KeyEvent.VK_D) new Piano(Keys.get("d")).start();
        if (e.getKeyCode() == KeyEvent.VK_E) new Piano(Keys.get("e")).start();
        if (e.getKeyCode() == KeyEvent.VK_F) new Piano(Keys.get("f")).start();
        if (e.getKeyCode() == KeyEvent.VK_G) new Piano(Keys.get("g")).start();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        return;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        return;
    }
}
