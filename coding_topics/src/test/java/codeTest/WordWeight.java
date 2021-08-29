package codeTest;
/*
   * 输入只有一行，只有大小写英文字母，每个单词之间有一个空格
   *
   * who love solo
   *
   * 3.67
 */

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Scanner;

public class WordWeight {

    /*
    读取控制台输入：
        1. BufferedReader （read()、readLine()） -- BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           每次调用 read() 方法，它从输入流读取一个字符并把该字符作为整数值返回。当流结束的时候返回 -1。该方法抛出 IOException。
           标准输入读取一个字符串需要使用 BufferedReader 的 readLine() 方法
        2. Scanner  Scanner scan = new Scanner(System.in);
           next(): 不能得到带有空格的字符串
           nextLine()： 以Enter为结束符,也就是说 nextLine()方法返回的是输入回车之前的所有字符,可以获得空白
           nextInt():
           nextFloat(): float f = 0.0f;
     单元测试中不可以包含对scanner.hasNext()的判断，即不可以从控制台获取值。
     List:  list.forEach(System.out::println);   jdk8

     四舍五入保留小数位数：
        1. String format = new DecimalFormat("#.0000").format(3.1415926);
        注意返回值类型 -- a.getClass().getName()
        其它查看收藏夹
     */

//    @Test
//    public void test1() {
//        Scanner scanner = new Scanner(System.in);
//
//        if (scanner.hasNext()) {
//            System.out.println(1);
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = "";
        if (scanner.hasNext()) {
            str = scanner.nextLine();
        }
        scanner.close();
        String[] s = str.split(" ");
        float str_length = 0;
        for (String value : s) {
            System.out.println(value);
            str_length += value.length();
        }
        float f = str_length/s.length;
//        String format = new DecimalFormat("#.00").format(f);
        String format = String.format("%.2f", f);
        System.out.println(format);

    }
}
