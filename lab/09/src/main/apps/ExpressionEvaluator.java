package apps;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressionEvaluator 
{
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");

    public static String toPostfix(String expression)
    {
        Scanner input = new Scanner(expression);
        String next;
        char symbol;
        Stack<Character> stack = new Stack<Character>(); 
        StringBuilder postfixExpression = new StringBuilder();
        int countOperand = 0;
        int countOperator = 0;
    
        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                countOperand++;
                postfixExpression.append(next).append(" ");
            }
            else
            {
                next = input.findInLine(CHARACTER);
                symbol = next.charAt(0);
    
                if (symbol == '(')
                {
                    stack.push(symbol); 
                }
                else if (symbol == '*' || symbol == '/')
                {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || higherPrecedence(symbol, stack.peek())))
                    {
                        countOperator++;
                        postfixExpression.append(stack.pop()).append(" ");
                    }
                    stack.push(symbol);
                }
                else if (symbol == '+' || symbol == '-')
                {
                    while (!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/' || stack.peek() == '+' || stack.peek() == '-' || higherPrecedence(symbol, stack.peek())))
                    {
                        countOperator++;
                        postfixExpression.append(stack.pop()).append(" ");
                    }
                    stack.push(symbol);
                }
                else if (symbol == ')')
                {
                    while (!stack.isEmpty() && stack.peek() != '(')
                    {
                        countOperator++;
                        postfixExpression.append(stack.pop()).append(" ");
                    }
                    
                    if (!stack.isEmpty() && stack.peek() == '(')
                    {
                        stack.pop();
                    }
                    else
                    {
                        input.close();
                        return null;
                    }
                }
                else
                {
                    postfixExpression = null;
                } 
            } 
        }
        while (!stack.empty())
        {
            symbol = stack.pop();
            if (symbol != '(')
            {
                countOperator++;
                postfixExpression.append(symbol).append(" ");    
            }
        }
        if (countOperand - 1 != countOperator)
        {
            input.close();
            return null;
        }
        input.close();
        return postfixExpression.toString();
    }      

    public static double evaluate(String postfixExpression)
    {
        Scanner input = new Scanner(postfixExpression);
        String next;
        char operator;
        double answer = Double.NaN;
        Stack<Double> stack = new Stack<Double>();
        
        while (input.hasNext())
        {
            if (input.hasNext(UNSIGNED_DOUBLE))
            {
                next = input.findInLine(UNSIGNED_DOUBLE);
                stack.push(Double.parseDouble(next));
            }
            else
            {
                next = input.findInLine(CHARACTER);
                operator = next.charAt(0);
                double operand2 = 0.0;
                double operand1 = 0.0;
                  
                if (operator == '*' || operator == '/' || operator == '+' || operator == '-')
                {
                    operand2 = stack.pop();
                    operand1 = stack.pop();
                    double result;
                    if (operator == '*')
                    {
                        result = operand1 * operand2;
                    }
                    else if (operator == '/')
                    {
                        result = operand1 / operand2;
                    }
                    else if (operator == '+')
                    {
                        result = operand1 + operand2;
                    }
                    else
                    {
                        result = operand1 - operand2;
                    }
                    stack.push(result);
                }
            } 
        }
        answer = stack.pop();
        input.close();
        return answer;
    }

    private static boolean higherPrecedence(char current, char top)
    {
        return (top == '*' || top == '/') && (current == '+' || current == '-');
    }
}
