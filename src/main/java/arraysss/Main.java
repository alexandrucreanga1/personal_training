package arraysss;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random(47);
        int[] a = new int[rand.nextInt(4)];
        System.out.println("lenght of a = " + a.length);
        System.out.println(Arrays.toString(a));
    }
}
