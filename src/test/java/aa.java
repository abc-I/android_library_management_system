import org.junit.Test;

import java.util.Scanner;

public class aa {
    @Test
    public void test() {
        Scanner sc=new Scanner(System.in);
        int x = 50;
        int y = 20;
        int z;
        int a, b;
        if (x > y) {
            a = x;
            b = y;
        } else {
            a = y;
            b = x;
        }
        do {
            z = a % b;
            a = b;
            b = z;
        } while (b != 0);
        System.out.println(a);
    }
}