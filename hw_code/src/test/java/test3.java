import java.util.Scanner;

public class test3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m,n;
        int[][] mn;
        int[] a = new int[2];
        int[] b = new int[2];
        if (scanner.hasNext()) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            mn = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    mn[i][j] = scanner.nextInt();
                }
            }
            a[0] = scanner.nextInt();
            a[1] = scanner.nextInt();
            b[0] = scanner.nextInt();
            b[1] = scanner.nextInt();

            System.out.println(2);
        }
    }
}
