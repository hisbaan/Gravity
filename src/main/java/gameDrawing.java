//File: gameDrawing.java
//Created: 02/07/2019
//Finished: 02/07/2019
//Name: Hisbaan Noorani
//
//This program 

import javax.swing.*;
import java.awt.*;

public class gameDrawing extends JPanel {
    gameDrawing() {
        repaint();
    }

    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;

        g.fillRect(0, 0, Gravity.FRAME_X, Gravity.FRAME_Y);

        g.setColor(Color.white);
        g.fillOval(Gravity.xPos - 5, Gravity.yPos - 5, 10, 10);

    }
}