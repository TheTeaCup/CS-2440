package week_eight;

import java.util.Arrays;

public class ExamPractice {
    public enum Day {
        SUN, MON, TUE, WED, THU, FRI, SAT
    };

    public static void main(String[] args) {

        // question 1
        char[] letters = { 'a', 'b', 'c', 'd', 'e', 'f' };
        char[] moreLetters = letters;

        // change the last letter to 'z'
        moreLetters[letters.length - 1] = 'z';

        // question 2
        int[] x = { 23, 55, 83, 19 };
        int[] y = { 36, 78, 12, 24 };
        x = y;
        y = x;

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println();

        // question 3
        int[] a, b;
        a = new int[10];

        a[5] = 15;
        b = a.clone();

        a[5] = 30;

        System.out.println(b[5]);
        System.out.println();

        // question 4
        int[][] grid = new int[3][4];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = i * 4 + j;
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // question 8
        Day d1 = Day.FRI;
        Day d2 = Day.MON;
        System.out.println(d1.compareTo(d2));
        if (d1.compareTo(d2) < 0)
            System.out.println("true");
        else
            System.out.println("false");

        System.out.println();

        // question 9
        System.out.println(Day.WED); // WED
    }
}
