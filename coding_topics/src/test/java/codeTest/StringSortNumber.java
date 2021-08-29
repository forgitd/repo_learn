package codeTest;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

/*
  给定一个只包含大写英文字母的字符串S，给出S重新排列的所有不相同的排列数

  例如：S为ABA， 则： ABA，AAB，BAA

  S长度不超过10，且为大写

 */
public class StringSortNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";
        if (scanner.hasNext()) {
            str = scanner.nextLine();
        }
        if (!str.isEmpty()) {
            int length = str.length();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);             // 排序
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                boolean flag = true;
                int num = 1;
                while (flag) {
                    if (i+1 < chars.length && chars[i] == chars[i + 1]) {
                        i++;
                        num++;
                    } else {
                        flag = false;
                        map.put(chars[i], num);
                    }
                }
            }
            //
            long result = getFactorial(length);
            Collection<Integer> values = map.values();
            for (Integer value : values) {
                result = result / getFactorial(value);
            }
            System.out.println(result);
        }

    }

    // get阶乘
    public static Long getFactorial(int num) {
        long result = 1;
        for (int i = 0; i < num; i++) {
            result = result * (num - i);
        }
        return result;
    }
}
