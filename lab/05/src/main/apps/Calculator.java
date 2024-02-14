import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Calculator {
    private static int X_LOC;
    private static int Y_LOC;
    private static int WIDTh;
    private static int HEIGHT;
    private static String NAME;
    private static String RESULT_PREAMBLE;
    private static String ERROR_MESSAGE;
    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JLabel resultLabel;

    public Calculator()
    {
        createFrame();
        initalizeComponents();
        displayFrame();
    }

    public JFrame getFrame()
    {
        return this.frame;
    }

    private void createFrame()
    {
        this.frame = new JFrame(Calculator.NAME);
        this.frame.setSize(Calculator.WIDTh, Calculator.HEIGHT);
        this.frame.setLocation(Calculator.X_LOC, Calculator.Y_LOC);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initalizeComponents()
    {
        initalizeInputs();
        initalizeResults();
        initalizeButtons();
    }

    private void displayFrame()
    {
        this.frame.setVisible(true);
    }

    private void initalizeInputs()
    {

    }

    private void initalizeResults()
    {

    }

    private void initalizeButtons()
    {

    }

    private double getLeftNum()
    {

    }

    private double getRightNum()
    {

    }

    private void updateResult(double result)
    {

    }
}
