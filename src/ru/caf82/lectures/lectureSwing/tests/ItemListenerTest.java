package ru.caf82.lectures.lectureSwing.tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemListenerTest extends JPanel {
    private JLabel label;
    private JCheckBox checkBox;

    public ItemListenerTest() {
        setLayout(new GridLayout(1,1));
        add(createLabel());
        add(createCheckBox());
    }

    private JLabel createLabel() {
        label = new JLabel("Поставь галочку!!!");
        return label;
    }

    private JCheckBox createCheckBox() {
        checkBox = new JCheckBox("Я галочка");
        checkBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkBox.isSelected()) {
                    label.setText("УРААААА");
                }

                else {
                    label.setText("Еще раз поставь!!!");
                }
            }
        });
        return checkBox;
    }
}
