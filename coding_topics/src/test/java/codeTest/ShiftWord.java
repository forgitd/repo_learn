package codeTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/*
 输入的字符串中包含大小写，每个单词之间有空格
 元音字母变大写，其它变小写   --  a e i o u
 */
public class ShiftWord {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";
        if (scanner.hasNext()) {
            str = scanner.nextLine();
        }
        char[] chars = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                if (chars[i] >= 'a' && chars[i] <= 'z') {
                    chars[i] -= 32;
                }
            } else {
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    chars[i] += 32;
                }
            }
        }
        System.out.println(String.valueOf(chars));
    }
}
