import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNext()) {
            int money = scanner.nextInt();
            int num_food = scanner.nextInt();
            // money 数量 喜爱度
            int[] food_money = new int[num_food];
            int[] food_num = new int[num_food];
            int[] food_l = new int[num_food];
            for (int i = 0; i < num_food; i++) {
                food_money[i] = scanner.nextInt();
                food_num[i] = scanner.nextInt();
                food_l[i] = scanner.nextInt();
            }
            //
            int out = 0;
            for (int i = 0; i < num_food; i++) {
                if (food_money[i] < money) {
                    if (food_l[i] > out) {
                        out = food_l[i];
                    }
                }
            }
            for (int i = 0; i < num_food - 1; i++) {
                for (int j = 0; j < num_food - 1 -i; j++) {
                    if (food_money[j] + food_money[j + 1] < money) {
                        if (food_l[j] + food_l[j + 1] > out) {
                            out = food_l[j] + food_l[j + 1];
                        }
                    }
                }
            }
            System.out.println(out);
        }

    }
}
