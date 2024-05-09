import org.junit.Assert;
import org.junit.Test;
import java.io.*;
import java.util.*;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MethodsTest {

    @Test
    public void _min() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int right_answer = 1;
        int answer = Methods._min(list);
        Assert.assertEquals(answer, right_answer);
    }

    @Test
    public void _max() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int right_answer = 3;
        int answer = Methods._max(list);
        Assert.assertEquals(answer, right_answer);
    }

    @Test
    public void _sum() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int right_answer = 6;
        long answer = Methods._sum(list);
        Assert.assertEquals(answer, right_answer);
    }

    @Test
    public void _mult() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        int right_answer = 6;
        long answer = Methods._mult(list);
        Assert.assertEquals(answer, right_answer);
    }

    @Test
    public void time_test() throws FileNotFoundException {
        Scanner in;
        int nextint;
        ArrayList<Integer> list;
        for (int i = 0; i < 6; i++) {
            in = new Scanner(new File("test1" + i + ".txt"));
            list = new ArrayList<>();
            while (in.hasNext()) {
                try {
                    nextint = Integer.parseInt(in.next());
                    list.add(nextint);
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Too big number");
                }
                list.add(nextint);
            }
            double time_start = System.nanoTime();
            Methods._mult(list);
            double time_end = System.nanoTime();
            Assert.assertEquals((time_end - time_start) / 1000000. < 15, true);
            System.out.println((time_end - time_start) / 1000000.);
        }
    }

    @Test
    public void mult_sign() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(-2);
        list.add(1);
        list.add(2);
        long result_mult = Methods._mult(list);
        Assert.assertEquals((int)Math.signum(result_mult), (int)Math.pow((-1), list.size()));

    }
}