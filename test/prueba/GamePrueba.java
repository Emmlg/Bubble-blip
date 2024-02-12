/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

/**
 *
 * @author EMmanuel
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GamePrueba extends JPanel {

int x = 135;
int y = 0;

private void moveBall() {
    y = y + 1;
}

@Override
public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 50, 40);
}

public static void main(String[] args) throws InterruptedException {
    JFrame frame = new JFrame("Meteorites");
    GamePrueba game = new GamePrueba();
    frame.add(game);
    frame.setSize(300, 400);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    while (true) {
        game.moveBall();
        game.repaint();
        Thread.sleep(10);
    }
}
}
