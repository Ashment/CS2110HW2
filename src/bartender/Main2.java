package bartender;

import java.awt.*;
import java.io.File;
import javax.swing.*;

public class Main2 {

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel();
        frame.add(new JLabel(new ImageIcon("OccHappy.png")));
        emptyLabel.setPreferredSize(new Dimension(700, 400));
        frame.getContentPane().add(emptyLabel, BorderLayout.PAGE_START);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
        createAndShowGUI();
    }
});
}
}