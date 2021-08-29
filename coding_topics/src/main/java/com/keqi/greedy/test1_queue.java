package com.keqi.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class test1_queue {
    public static void main(String[] args) {
        PriorityQueue<Cow1> pq = new PriorityQueue<Cow1>(cc);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Cow1[] c1 = new Cow1[n];

        for (int i = 0; i < c1.length; i++) {
            c1[i] = new Cow1();
            c1[i].starting = sc.nextInt();
            c1[i].entire = sc.nextInt();
            c1[i].number = i + 1;
        }
        sc.close();

        // 通过Cow1 的比较， 按开始时间排序
        Arrays.sort(c1, new Cow1());
        int index = 1;  //  畜栏的数量
        c1[0].x = 1;    //  x：   牛在哪一个畜栏
        pq.add(c1[0]);  //  加入优先队列，加入的对象会按照 结束时间 小到大排列   cc

        for (int i = 1; i < c1.length; i++) {
            // assert 断言
            // peek element queue[0] 选取队列中头元素（优先级最高的） [peek 没有返回null  element 报异常]
            // poll remove 获取并删除   [前者 null  后者异常]
            // offer add   添加        [前者 false 后者异常]
            assert pq.peek() != null;
            if (c1[i].starting > pq.peek().entire) {
                c1[i].x = pq.peek().x;
                pq.remove();
                pq.add(c1[i]);
            } else {
                index++;
                c1[i].x = index;
                pq.add(c1[i]);
            }
        }

        // 按照number排序，  number，牛最开始的顺序
        Arrays.sort(c1, ccs);
        System.out.println(index);
        for (Cow1 cow1 : c1) {
            System.out.println(cow1.x);
        }

    }

    // 实例化接口的匿名实现类
    static Comparator<Cow1> ccs = new Comparator<Cow1>() {
        public int compare(Cow1 c1, Cow1 c2) {
            if (c1.number > c2.number) return 1;
            return -1;
        }
    };

    // 实例化接口的匿名实现类
    static Comparator<Cow1> cc = new Comparator<Cow1>() {
        @Override
        public int compare(Cow1 c1, Cow1 c2) {
            if (c1.entire > c2.entire)
                return 1;
            return -1;
        }
    };
}

// Comparator<Cow1>  两方法：compare   equals
// Comparable,提供了一个比较的方法
class Cow1 implements Comparator<Cow1> {
    int starting;
    int entire;
    int number;
    int x;

    public int compare(Cow1 c1, Cow1 c2) {
        if (c1.starting > c2.starting)
            return 1;
        return -1;
    }
}



