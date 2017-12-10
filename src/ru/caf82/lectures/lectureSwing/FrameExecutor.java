package ru.caf82.lectures.lectureSwing;

import javax.swing.*;

public class FrameExecutor {
    private static JFrame frame = new JFrame("SwingTest");

    public static void run(JPanel panel) {
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
    }
}
