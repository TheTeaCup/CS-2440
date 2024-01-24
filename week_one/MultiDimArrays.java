public class MultiDimArrays {
    private int[][][] a;

    public MultiDimArrays() {
        this.a = build3dArray(3, 3, 3);
    }

    public void increment (int i, int j, int k) {
        this.a[i][j][k]++;
    }

    public int[] getArray(int i, int j) {
        return this.a[i][j];
    }

    public static void main(String[] args) {

        MultiDimArrays m = new MultiDimArrays();
        int[] x = m.getArray(0, 0);
        x[x.length - 1] = 9;
        m.print();
    }

    public int[][][] build3dArray(int dim1, int dim2, int dim3) {
        int [][][] words2 = new int[dim1][dim2][dim3];
        for (int i = 0; i < words2.length; i++) {
            for (int j = 0; j < words2[i].length; j++) {
                for (int k = 0; k < words2[i][j].length; k++) {
                    words2[i][j][k] = 0; //Math.random() < 0.5 ? 0 : 1;
                }
            }
        }

        return words2;
    }

    public void print() {
        for (int[][] twoDim : a) {
            for (int[] oneDim : twoDim) {
                for (int elem : oneDim) {
                    System.out.print(elem + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}
