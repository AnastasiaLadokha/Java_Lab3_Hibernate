package ua.stu;

import ua.stu.view.MainGui;

import javax.swing.*;
import java.awt.*;

public class TestGui {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                MainGui window = new MainGui();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
