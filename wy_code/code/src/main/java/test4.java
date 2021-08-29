public class test4 {
    public static void main(String[] args) {

    }
    public int minSailCost (int[][] input) {
        // write code here
        int m = 0;
        for (int i = input.length - 1; i >= 0; i--) {
            for (int j = input[0].length - 1; j >= 0; j--) {
                if (input[i][j - 1] !=2 || input[i - 1][j] !=2) {

                    int[][] ints = new int[i][j - 1];
                    int[][] ints1 = new int[i - 1][j];
                    for (int k = 0; k < i; k++) {
                        for (int l = 0; l < j - 1; l++) {
                            ints[k][l] = input[k][l];
                        }
                    }
                    for (int k = 0; k < i - 1; k++) {
                        for (int l = 0; l < j; l++) {
                            ints[k][l] = input[k][l];
                        }
                    }
                    m += Math.max(minSailCost(ints),minSailCost(ints1));
                }
            }
        }
        System.out.println(m);
        return m;
    }

}
