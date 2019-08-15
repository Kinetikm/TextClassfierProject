package ru.caf82.lectures.lectureSwing.tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerTest extends JPanel {
    private JButton button;
    private JLabel label;
    public ActionListenerTest() {
        add(createButton());
        add(createLabel());
    }

    private JButton createButton() {
        setLayout(new GridLayout(1,1));
        button = new JButton("Нажми меня");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (label.getText().equals("Я метка")) {
                   label.setText("Спасибо, что нажали!!!");
               }
               else {
                   label.setText("Я метка");
               }
            }
        });
        return button;
    }

    private JLabel createLabel() {
        label = new JLabel("Я метка");
        return label;
    }
}
