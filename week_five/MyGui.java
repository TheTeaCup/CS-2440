package week_five;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGui 
{
    private JFrame frame;
    private JLabel label;
    private JTextField input;

    private ActionListener listener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonLabel = ((Button) e.getSource()).getLabel();
            if (buttonLabel.equals("Uppercase"))
            {
                label.setText(input.getText().toUpperCase());
            }
            else if (buttonLabel.equals("Lowercase"))
            {
                label.setText(input.getText().toLowerCase());
            }
            else 
            {
                label.setText("Invalid Button Clicked");
            }
        }
    };
    
    public MyGui(int width, int height, int x, int y)
    {
        this.frame = new JFrame("My Gui");
        this.frame.setSize(width, height);
        this.frame.setLocation(x, y);
        initalize();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public void initalize()
    {
        JPanel panel = new JPanel();
        this.input = new JTextField(20);
        this.label = new JLabel("Hello World");
        panel.add(label);
        panel.add(input);
        this.frame.add(panel, BorderLayout.PAGE_END);
        addButtons();
    }

    public void addButtons()
    {
        JPanel panel2 = new JPanel();
        Button button = new Button("Click Me");

        button.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                String text = input.getText();
                try 
                {
                    int num = Integer.parseInt(text);
                    label.setText("Number Entered: " + num);
                }
                catch (NumberFormatException ex)
                {
                    label.setText("Not a Number");
                }
            }
        });

        // or
        // button.addActionListener(new MyListener());

        panel2.add(button);
        this.frame.add(panel2, BorderLayout.CENTER);
    }

    // private class MyListener implements ActionListener
    // {

    //     @Override
    //     public void actionPerformed(ActionEvent e) {
    //         label.setText("Clicked");
    //     }
        
    // }
}
