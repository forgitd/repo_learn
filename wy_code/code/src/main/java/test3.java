import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int[] children = new int[s1.length];
        int i = 0;
        HashSet<Integer> set = new HashSet<>();
        for (String s2 : s1) {
            children[i] = Integer.parseInt(s2);
            set.add(Integer.parseInt(s2));
            i += 1;
        }

        int size = set.size();
        int m = 0;
        int[] n = new int[100];
        int p = 0;
        for (int j = 0; j < s1.length; j++) {
            n[j] = m + 1;
            m += 1;
        }
        for (int i1 : n) {
            p = p + i1;
        }
        System.out.println(p);
        System.out.println(p - (s1.length - size) * size);

    }
}
