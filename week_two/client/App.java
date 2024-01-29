package week_two.client;

import week_two.processors.GridProcessor;

public class App {
    public static void main(String[] args) {
        GridProcessor gp = new GridProcessor();
        gp.readInGrid("week_two/data/grid1.txt");
        gp.printGrid();
    }
}
