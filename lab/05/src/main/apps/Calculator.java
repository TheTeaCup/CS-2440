package apps;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator 
{
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private static final String NAME = "hunters calculator";
    private static final String RESULT_PREAMBLE = "Result = ";
    private static final String ERROR_MESSAGE = "Error";
    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JLabel resultLabel;

    public Calculator()
    {
        createFrame();
        initializeComponents();
        displayFrame();
    }

    public JFrame getFrame()
    {
        return this.frame;
    }

    private void createFrame()
    {
        this.frame = new JFrame(Calculator.NAME);
        this.frame.setSize(Calculator.WIDTH, Calculator.HEIGHT);
        this.frame.setLocation(Calculator.X_LOC, Calculator.Y_LOC);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents()
    {
        initializeInputs();
        initializeResults();
        initializeButtons();
    }

    private void displayFrame()
    {
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void initializeInputs ()
    {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        leftOpField = new JTextField(10);
        leftOpField.setName("leftOperand");
        inputPanel.add(leftOpField);
    
        rightOpField = new JTextField(10);
        rightOpField.setName("rightOperand");
        inputPanel.add(rightOpField);
    
        frame.add(inputPanel, BorderLayout.NORTH); 
    }

    private void initializeResults()
    {
        JPanel resultPanel = new JPanel(new BorderLayout());
        
        resultLabel = new JLabel(RESULT_PREAMBLE);
        resultLabel.setName("resultLabel");
        resultPanel.add(resultLabel, BorderLayout.CENTER);

        frame.add(resultPanel, BorderLayout.CENTER);
    }

    private void initializeButtons()
    {
        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

        // add button
        JButton addButton = new JButton("ADD");
        addButton.setName("addButton");
        addButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                double result = getLeftNum() + getRightNum();
                updateResult(result);
            }
        });
        buttonPanel.add(addButton);

        // subtract button
        JButton subButton = new JButton("SUB");
        subButton.setName("subButton");
        subButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                double result = getLeftNum() - getRightNum();
                updateResult(result);
            }
        });
        buttonPanel.add(subButton);

        // multiply button
        JButton multButton = new JButton("MULT");
        multButton.setName("multButton");
        multButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                double result = getLeftNum() * getRightNum();
                updateResult(result);
            }
        });
        buttonPanel.add(multButton);

        // divide button
        JButton divButton = new JButton("DIV");
        divButton.setName("divButton");
        divButton.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                double rightNum = getRightNum();

                if (rightNum == 0) 
                {
                    updateResult(Double.NaN);
                } else 
                {
                    double result = getLeftNum() / rightNum;
                    updateResult(result);
                }
            }
        });
        buttonPanel.add(divButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private double getLeftNum()
    {
        try 
        {
            String leftText = leftOpField.getText();

            if (leftText.isEmpty()) 
            {
                return Double.NaN;
            }

            return Double.parseDouble(leftText);
        } 
        catch (NumberFormatException e) 
        {
            return Double.NaN;
        }
    }

    private double getRightNum()
    {
        try 
        {
            String rightText = rightOpField.getText();

            if (rightText.isEmpty()) 
            {
                return Double.NaN;
            }

            return Double.parseDouble(rightText);
        } catch (NumberFormatException e) 
        {
            return Double.NaN;
        }
    }

    private void updateResult(double result)
    {
        if (Double.isNaN(result)) 
        {
            resultLabel.setText(RESULT_PREAMBLE + ERROR_MESSAGE);
        } 
        else 
        {
            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }
}
