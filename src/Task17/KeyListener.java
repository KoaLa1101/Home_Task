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
        if (e.getKeyCode() == KeyEvent.VK_A) new Piano(Piano.keys.get("a")).start();
        if (e.getKeyCode() == KeyEvent.VK_B) new Piano(Piano.keys.get("b")).start();
        if (e.getKeyCode() == KeyEvent.VK_C) new Piano(Piano.keys.get("c")).start();
        if (e.getKeyCode() == KeyEvent.VK_D) new Piano(Piano.keys.get("d")).start();
        if (e.getKeyCode() == KeyEvent.VK_E) new Piano(Piano.keys.get("e")).start();
        if (e.getKeyCode() == KeyEvent.VK_F) new Piano(Piano.keys.get("f")).start();
        if (e.getKeyCode() == KeyEvent.VK_G) new Piano(Piano.keys.get("g")).start();

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
