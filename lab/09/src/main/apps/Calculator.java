package apps;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

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
        initializeButtons();
        initializeInput();
        initializeResult();
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

    }

    private void displayFrame()
    {

    }

    private void initializeInput()
    {

    }

    private void initializeResult()
    {

    }

    private void initializeButtons()
    {

    }

    private String calculate()
    {
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        return "";
    }

    private void updateResult(String result)
    {

    }
}