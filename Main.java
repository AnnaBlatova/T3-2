import java.util.*;
import java.io.*;
import java.nio.file.*;

class Methods {
    public static int _min(ArrayList<Integer> numbers) {
        return Collections.min(numbers);
    }
    public static int _max(ArrayList<Integer> numbers) {
        return Collections.max(numbers);
    }
    public static long _sum(ArrayList<Integer> numbers) {
        long summa = 0;
        try {
            summa = numbers.stream().mapToLong(Integer::longValue).sum();
        } catch (StackOverflowError a) {
            System.out.print("Too many numbers to count!");
        }
        return summa;
    }
    public static long _mult(ArrayList<Integer> numbers) {
        long mult = 0;
        try {
            mult = numbers.stream().mapToLong(Integer::longValue).reduce(1, (a, b) -> a * b);
        } catch (StackOverflowError a) {
            System.out.print("Too many numbers to count!");
        }
        return mult;
    }
}
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next(), command = scanner.next();
        File file = new File(fileName + ".txt");
        ArrayList<Integer> array = new ArrayList<>();
        Scanner in = new Scanner(file);
        while (in.hasNextInt()) {
            int number = Integer.parseInt(in.next());
            array.add(number);
        }
        switch (command){
            case ("max"):
                System.out.println("Max = " + Methods._max(array));
                break;
            case ("min"):
                System.out.println("Min = " + Methods._min(array));
                break;
            case ("sum"):
                System.out.println("Sum = " + Methods._sum(array));
                break;
            case ("mult"):
                System.out.println("Mult = " + Methods._mult(array));
                break;
        }
    }
}