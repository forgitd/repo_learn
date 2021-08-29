import java.util.ArrayList;

public class test01 {
    byte[] bytes = new byte[1 * 1024 * 1024];
    public static void main(String[] args) {

        ArrayList<test01> list = new ArrayList<>();
        int count = 0;

        try {
            while (true) {
                list.add(new test01());
                count = count + 1;
            }
        } catch (Exception e) {
            System.out.println(count);
        }
        // Throwable
            // Exception
            // Error
    }
}
