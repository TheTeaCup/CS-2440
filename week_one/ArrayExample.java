public class ArrayExample {
    public static void main(String[] args) {
        int[] myArrary = new int[5];

        for (int i : myArrary) {
            System.out.println(i);
        }

        System.out.println();

        String[] strArray = new String[5];

        for (String str : strArray) {
            System.out.println(str);
        }

        System.out.println();

        int[][] my2DArray = new int[5][5];

        for (int[] row : my2DArray) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }

        System.out.println();

        my2DArray = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 } };

        for (int i = 0; i < my2DArray.length; i++) {
            for (int j = 0; j < my2DArray[i].length; j++) {
                System.out.print(++my2DArray[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();

        int[][] jaggedArray = new int[5][];

        for (int i = 0; i < jaggedArray.length; i++) {
            jaggedArray[i] =  getRandomArray();
        }

        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                System.out.print(jaggedArray[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static int[] getRandomArray() {
        int[] a = new int[(int) (Math.random() * 10) + 1];

        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }

        return a;
    }

    public static void printEvens(int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[j].length; j++) {
                if (i % 2 == 0 && numbers[i][j] % 2 == 0) {
                    System.out.println(numbers[i][j] + "\t");
                }
            }
        }
    }
}