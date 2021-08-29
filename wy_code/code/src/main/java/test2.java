public class test2 {
    public static void main(String[] args) {
        test2 t = new test2();
        System.out.println(t.findKthBit(4, 11));
    }
    public char findKthBit (int n, int k) {
        // write code here

        // n:生成字符串              k:第几个
        String S = "";
        S = t(n);
        char[] chars = S.toCharArray();
        return chars[k -1];
    }
    public String t(int n) {
        char[] L = new char[26];
        L[0] = 'a';
        L[1] = 'b';
        L[2] = 'c';
        L[3] = 'd';
        L[4] = 'e';
        L[5] = 'f';
        L[6] = 'g';
        L[7] = 'h';
        L[8] = 'i';
        L[9] = 'j';
        L[10] = 'k';
        L[11] = 'l';
        L[12] = 'm';
        L[13] = 'n';
        L[14] = 'o';
        L[15] = 'p';
        L[16] = 'q';
        L[17] = 'r';
        L[18] = 's';
        L[19] = 't';
        L[20] = 'u';
        L[21] = 'v';
        L[22] = 'w';
        L[23] = 'x';
        L[24] = 'y';
        L[25] = 'z';
        String t1 = "";
        if (n == 1) {
            return String.valueOf(L[n - 1]);
        } else {
            t1 = t(n -1) + L[n] + invert(n - 1);
            return t1;
        }

    }
    public String invert(int n) {
        char[] L = new char[26];
        L[0] = 'a';
        L[1] = 'b';
        L[2] = 'c';
        L[3] = 'd';
        L[4] = 'e';
        L[5] = 'f';
        L[6] = 'g';
        L[7] = 'h';
        L[8] = 'i';
        L[9] = 'j';
        L[10] = 'k';
        L[11] = 'l';
        L[12] = 'm';
        L[13] = 'n';
        L[14] = 'o';
        L[15] = 'p';
        L[16] = 'q';
        L[17] = 'r';
        L[18] = 's';
        L[19] = 't';
        L[20] = 'u';
        L[21] = 'v';
        L[22] = 'w';
        L[23] = 'x';
        L[24] = 'y';
        L[25] = 'z';
        if (n == 1) {
            return String.valueOf(L[26 - n]);
        } else {
            return t(n -1) + L[n] + invert(n - 1);
        }
    }
}
