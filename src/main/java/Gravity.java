//File: Gravity.java
//Created: 02/07/2019
//Finished: 02/07/2019
//Name: Hisbaan Noorani
//
//This program 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gravity implements MouseListener {

    JFrame simulationFrame = new JFrame("Gravity");
    gameDrawing board = new gameDrawing();

    public static final int FRAME_X = 800;
    public static final int FRAME_Y = 800;

    public static final double GRAVITY = 9.8;

    public static int xInitial = 0;
    public static int yInitial = 0;

    public static int xFinal = 0;
    public static int yFinal = 0;

    public static int xDragDelta = 0;
    public static int yDragDelta = 0;

    public static double angleRadian = 0.0;

    public static int xPos = 400;
    public static int yPos = 0;

    public static int xVelocity = 0;
    public static int yVelocity = 0;

    Timer movement;

    public static void main(String[] args) {
        new Gravity();
    }

    Gravity() {
        movement = new Timer(10, e -> {
            move();
        });

        simulation();
    }

    public void simulation() {
        movement.start();
        simulationFrame.setSize(FRAME_X, FRAME_Y);
        simulationFrame.setLayout(new BorderLayout());

        if (simulationFrame.getMouseListeners().length < 1) simulationFrame.addMouseListener(this);

        simulationFrame.add(board, BorderLayout.CENTER);
        board.setSize(FRAME_X, FRAME_Y);

        simulationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        simulationFrame.setVisible(true);
    }

    public void move() {
            xPos += xVelocity;
            yPos += yVelocity;

            board.validate();
            board.repaint();
    }

    public void getAngle() {
        if (xDragDelta != 0 && yDragDelta != 0) {
            xDragDelta = xFinal - xInitial;
            yDragDelta = yFinal - yInitial;

            angleRadian = Math.tan(yDragDelta / xDragDelta);

//        if (angleRadian < 0) {
//            angleRadian += 360;
//        } else if (angleRadian > 360) {
//            angleRadian -= 360;
//        }

            xVelocity = (int) (5 * Math.cos(angleRadian));
            yVelocity = (int) (5 * Math.sin(angleRadian));

            System.out.println("angle: " + Math.toDegrees(angleRadian) + " | xVel: " + xVelocity + " | yVel: " + yVelocity + "");
        } else {
            System.out.println("xDelta: " + xDragDelta + " | yDelta: " + yDragDelta);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == simulationFrame) {
            xInitial = xPos;
            yInitial = yPos;
//            xInitial = e.getX();
//            yInitial = e.getY();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == simulationFrame) {
            xFinal = e.getX();
            yFinal = e.getY();

            getAngle();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
