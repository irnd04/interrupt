package org.example;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Hello world!
 *
 */
@Slf4j
public class App 
{

    private static BlockingQueue<Integer> q = new LinkedBlockingQueue<>(1);
    private static Producer producer = new Producer(q);
    private static Consumer consumer = new Consumer(q);
    private static Thread pt = new Thread(producer);
    private static Thread ct = new Thread(consumer);
    private static NoInterruptExceptionThread nt = new NoInterruptExceptionThread();

    public static void interrupt() {
        pt.interrupt();
        log.info("pt[{}].isInterrupted() {}", pt.getName(), pt.isInterrupted());
        ct.interrupt();
        log.info("ct[{}].isInterrupted() {}", ct.getName(), ct.isInterrupted());
        nt.interrupt();
        log.info("ct[{}].isInterrupted() {}", nt.getName(), ct.isInterrupted());
    }

    public static void start() {
        pt.start();
        ct.start();
        //nt.start();
    }

    public static void main( String[] args ) {
        Runtime.getRuntime().addShutdownHook(new Thread(App::interrupt));
        start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        interrupt();
    }
}
