import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10000];
        int f = 0;
        String s = "";
        if (scanner.hasNext()) {
            s = scanner.nextLine();
            f = scanner.nextInt();
        }
        char[] chars = s.toCharArray();
        String[] s1 = s.split(" ");
        int i = 0;
        for (String s2 : s1) {
            arr[i] = Integer.parseInt(s2);
            i += 1;
        }
        int m = 0;
        /*
        错误点: f 没有等于
               冒泡排序并没有得到所有的 选出2个组合
         */
        for (int j = 0; j < s1.length; j++) {
            for (int k = 0; k < s1.length - 1 - j; k++) {
                if (arr[k] + arr[k + 1] < f) {
                    m += 1;
                }
            }
        }
        System.out.println(m);
     }
}
