package lab;


import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue<Integer> firstHand = new ArrayQueue<>(10);
        ArrayQueue<Integer> secondHand = new ArrayQueue<>(10);

        for (int i = 0; i < 5; i++) {
            firstHand.add(scanner.nextInt());
        }
        for (int i = 0; i < 5; i++) {
            secondHand.add(scanner.nextInt());
        }

        int count = 0;
        while (count < 106 && !firstHand.isEmpty() && !secondHand.isEmpty()) {
            Integer val1 = firstHand.remove(0);
            Integer val2 = secondHand.remove(0);
            int comp = val1.compareTo(val2);
            if (val1 == 9 && val2 == 0) {
                comp = -1;
            }
            if (val2 == 9 && val1 == 0) {
                comp = 1;
            }

            if (comp == 1) {
                firstHand.add(val1);
                firstHand.add(val2);
            } else if (comp == -1) {
                secondHand.add(val2);
                secondHand.add(val1);
            }

            printOut(firstHand);
            printOut(secondHand);
            System.out.println('\n');

            count++;
        }
        if (count == 106)
            System.out.println("botva");
        else if (firstHand.isEmpty()) {
            System.out.println("second " + count);
        } else {
            System.out.println("first " + count);
        }

    }

    private static void printOut(ArrayQueue<Integer> hand) {
        String res = "[ ";
        for (Object x : hand)
            res += x.toString() + ", ";
        res = res.substring(0, res.length() - 2);
        System.out.println(res + " ]");

    }
}