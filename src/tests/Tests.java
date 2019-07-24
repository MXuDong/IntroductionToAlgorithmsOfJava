package tests;

/**
 * Code Name : Tests
 * 代码段名称  :
 *
 * @author Dong
 */
public class Tests {
    public static void main(String[] args) {
        for (int i = 10; i < 100; i++) {
            if (isRight(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isRight(int x) {

        int f = getSum(x);
        int a = getSum(x * 3);
        int b = getSum(x * 5);
        int c = getSum(x * 7);
        int d = getSum(x * 9);

        return f == a && f == b && f == c && f == d;

    }

    public static int getSum(int x) {
        int f = x / 10;
        int s = x % 10;
        return f + s;
    }
}
