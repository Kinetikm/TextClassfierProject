package ru.caf82.lectures.lectureSwing.tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListenerTest extends JPanel {
    private JLabel label1;
    private JLabel label2;
    private JButton button;

    public MouseListenerTest() {
        setLayout(new GridLayout(1,2));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                String word = "Привет";
                label1.setText(word);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                label1.setText("");
            }

        });
        add(createLabel1());
        add(createLabel2());
        add(createButton());

    }

    private JLabel createLabel1() {
        label1 = new JLabel();
        return label1;
    }

    private JLabel createLabel2() {
        label2 = new JLabel();
        return label2;
    }

    private JButton createButton() {
        button = new JButton("Click me!");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                label2.setText("LOL))00)))))))000))");
            }

            @Override
            public void mouseReleased(MouseEvent e) {

                label2.setText("");
            }
        });
        return button;
    }
}
