package ru.caf82.lectures.lectureSwing.tests;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ChangeListenerTest extends JPanel {
    private JLabel label;
    private JButton button;

    public ChangeListenerTest() {
        setLayout(new GridLayout(1,1));
        add(createLabel());
        add(createButton());
    }

    private JLabel createLabel() {
        label = new JLabel("Ничего не происходит");
        return label;
    }

    private JButton createButton() {
        button = new JButton("Кнопка");
        button.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                    label.setText("Изменилось состояние кнопки");
            }
        });
        return button;
    }
}
