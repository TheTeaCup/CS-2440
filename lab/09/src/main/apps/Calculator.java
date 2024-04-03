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
    private JTextField infixExpression;
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
        initializeButtons();
        initializeInput();
        initializeResult();
    }

    private void displayFrame()
    {
        this.frame.pack();
        this.frame.setVisible(true);
    }

    private void initializeInput()
    {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        infixExpression = new JTextField(20);
        infixExpression.setName("infixExpression");
        inputPanel.add(infixExpression);

        frame.add(inputPanel, BorderLayout.NORTH); 
    }

    private void initializeResult()
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

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setName("calculateButton");
        calculateButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                String result = calculate();
                updateResult(result); 
            }
        });
        buttonPanel.add(calculateButton);

        JButton clearButton = new JButton("Clear");
        clearButton.setName("clearButton");
        clearButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                infixExpression.setText("");
                resultLabel.setText(RESULT_PREAMBLE);
            }
        });
        buttonPanel.add(clearButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);
    }

    private String calculate()
    {
        String postfixExpression = ExpressionEvaluator.toPostfix(infixExpression.getText());
        
        if (postfixExpression == null) 
        {
            return ERROR_MESSAGE;
        }
    
        double result = ExpressionEvaluator.evaluate(postfixExpression);
        if (Double.isNaN(result)) 
        {
            return ERROR_MESSAGE; // do i make it say Error NaN ??
        }
    
        return "Result = " + result;
    }

    private void updateResult(String result)
    {
        resultLabel.setText(result);
    }
}