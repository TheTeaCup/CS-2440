import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JFrameExample 
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("I Love CS2");
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        Button button = new Button("Button");
        panel.add(button);

        JTextArea text = new JTextArea();

        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                text.append("Done");
                panel.add(text);
            }
            
        });

        panel.setBackground(Color.GREEN);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        frame.add(panel, BorderLayout.CENTER);
    }
}