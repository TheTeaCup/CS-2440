package apps;

import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class ExpressionEvaluator {
    private static final Pattern UNSIGNED_DOUBLE = Pattern.compile("((\\d+\\.?\\d*)|(\\.\\d+))([Ee][-+]?\\d+)?.*?");
    private static final Pattern CHARACTER = Pattern.compile("\\S.*?");

    public static String toPostfix(String expression)
    {
        return "";
    }

    // need to use this method here...
    private static boolean higherPrecedence(char current, char top)
    {
        return (top >= current);
    }
}
