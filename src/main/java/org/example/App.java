package org.example;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Hello world!
 *
 */
public class App 
{

    private static BlockingQueue<Integer> q = new LinkedBlockingQueue<>(1);
    private static Producer producer = new Producer(q);
    private static Consumer consumer = new Consumer(q);
    private static Thread pt = new Thread(producer);
    private static Thread ct = new Thread(consumer);

    public static void interrupt() {
        pt.interrupt();
        ct.interrupt();
    }

    public static void start() {
        pt.start();
        ct.start();
    }

    public static void main( String[] args ) throws InterruptedException {
        start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        interrupt();
    }
}
