package week_two.client;

import week_two.processors.HaikuProcessor;

public class Demo {
     public static void main(String[] args) {
        HaikuProcessor HP = new HaikuProcessor();
        HP.readFile("week_two/data/haiku1.txt");
        HP.printPoem();
        HP.getWord(2, 2);
    }
}
