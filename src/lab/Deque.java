package lab;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Scanner;

public class Deque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstHand = new ArrayDeque<>(5);
        ArrayDeque<Integer> secondHand = new ArrayDeque<>(5);

        for (int i = 0; i < 5; i++) {
            firstHand.addLast(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            secondHand.addLast(scanner.nextInt());
        }
        int count = 0;
        while (count < 106  && !firstHand.isEmpty() && !secondHand.isEmpty()) {
            Integer val1 = firstHand.poll();
            Integer val2 = secondHand.poll();
            int comp = val1.compareTo(val2);
            if (val1 == 9 && val2 == 0) {
                comp = -1;
            }
            if (val2 == 9 && val1 == 0) {
                comp = 1;
            }

            if (comp == 1) {
                firstHand.addLast(val1);
                firstHand.addLast(val2);
            }
            else if(comp == -1) {
                secondHand.addLast(val2);
                secondHand.addLast(val1);
            }

            printOut(firstHand);
            printOut(secondHand);
            System.out.println('\n');

            count++;
        }
        if(count == 106) // Если кол-во ходов достигло 106, то выводим botva
            System.out.println("botva");
        else if(firstHand.isEmpty()) {
            System.out.println("second " + count);
        }
        else {
            System.out.println("first " + count);
        }

    }
    private static void printOut(ArrayDeque<Integer> hand) {
        String res = "[ ";
        for(Object x: hand)
            res += x.toString() + ", ";
        res = res.substring(0, res.length() - 2);
        System.out.println(res + " ]");

    }
}
